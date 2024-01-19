import React, { useState, useEffect } from 'react'
import './Home.css'
import StateCard from '../components/StateCard'
import SafeZoneBtn from '../components/SafeZoneBtn'
import GeolocationPoint from '../components/GeolocationPoint'
import ComboBox from '../components/ComboBox'
import PlusBtn from '../components/PlusBtn'
import NotificationBtn from '../components/NotificationsBtn'
import SimpleMap from '../components/SimpleMap'
import CasosViewModel from '../../viewmodel/CasosViewModel';
import ZonasViewModel from '../../viewmodel/ZonasViewModel';
import TextInput from '../components/TextInput'
import { FaCity } from "react-icons/fa6";
import UsuariosViewModel from '../../viewmodel/UsuariosViewModel'
import PosicionesViewModel from '../../viewmodel/PosicionesViewModel'
import ChequeosViewModel from '../../viewmodel/ChequeosViewModel'

function Home() {

    /*================== Start Endpoints ==================*/
    /* obtiene el numero de casos que existen */
    const [length, setLength] = useState(0);

    useEffect(() => {
        const fetchNumeroCasos = async () => {
            try {
                const count = await CasosViewModel.getCasosCount();
                setLength(count);
            } catch (error) {
                console.error("Error en obtener numero de casos", error);
            }
        };

        fetchNumeroCasos();
    }, []);

    //////////////////////////////////////////////
    /* obtiene los nombres del agresor y la victima del caso */

    const [Victim, setVictim] = useState("Loading...");
    const [Aggressor, setAggressor] = useState("Loading...");
    const [Distance, setDistance] = useState(0);

    const fetchNombres = async (caso) => {
        try {
            const { victimName, aggressorName } = await CasosViewModel.getCasoNombres(caso);
            setAggressor(aggressorName)
            setVictim(victimName)
        } catch (error) {
            console.error("Error en obtener nombres de caso", error);
        }
    };

    //////////////////////////////////////////////
    /* obtiene la distancia entre la victima y el agresor del caso */

    const fetchDistance = async (caso) => {
        try {
            const distance = await CasosViewModel.getCasoDistance(caso);
            setDistance(distance)
        } catch (error) {
            console.error("Error en obtener distancia de caso", error);
        }
    };

    //////////////////////////////////////////////

    /* actualiza los usuarios, carga zonas de seguridad, carga estados de conexion */

    const [Victim_ID, setVictim_ID] = useState(0)
    const [Aggressor_ID, setAggressor_ID] = useState(0)

    const [Zones, setZones] = useState([])

    const [ConectAggressor, setConectAggressor] = useState(false);
    const [ConectVictim, setConectVictim] = useState(false);

    const fetchLoadingZonesAndStatus = async (caso) => {
        try {
            //guardamos el id de la victima que corresponde al caso
            const victim = await CasosViewModel.getCasoVictima(caso);
            setVictim_ID(victim)

            //guardamos el id de el agresor que corresponde al caso
            const aggressor = await CasosViewModel.getCasoAgresor(caso);
            setAggressor_ID(aggressor)

            //nos traemos las zonas seguras del caso
            const zonas = await ZonasViewModel.getZonas(victim);
            setZones(zonas);

            //actualizamos conexiones y posiciones
            updateConnectionStatus(victim, aggressor);
            updatePosition(victim, aggressor);

        } catch (error) {
            console.error("Error al cargar los datos de la zona", error);
        }
    };

    ///////////////////////////////////////////////
    /*actualiza los estados de conexion y las posiciones cada 15 segundos*/
    
    const [VictimPosition, setVictimPosition] = useState([0, 0])
    const [AggressorPosition, setAggressorPosition] = useState([0, 0])

    const updateConnectionStatus = async (victim, aggresor) => {

        try {
            const statusvictim = await UsuariosViewModel.getUsersConection(victim);
            const statusagresor = await UsuariosViewModel.getUsersConection(aggresor);
            setConectAggressor(statusagresor);
            setConectVictim(statusvictim);

            console.log("Conexiones actualizadas")
        } catch (error) {
            console.error("Error al actualizar el estado de conexión", error);
        }
    };

    const updatePosition = async (victim, aggresor) => {

        try {
            const { lat: victim_pos_lat, lng: victim_pos_lng } = await PosicionesViewModel.getPosicion(victim);
            const { lat: aggressor_pos_lat, lng: aggressor_pos_lng } = await PosicionesViewModel.getPosicion(aggresor);
            setVictimPosition([victim_pos_lat, victim_pos_lng])
            setAggressorPosition([aggressor_pos_lat, aggressor_pos_lng])
        } catch (error) {
            console.error("Error al actualizar las posiciones", error);
        }
    }; 

    const fetchDistanceByVictim = async (Victim) => {
        try {
            const distance = await CasosViewModel.getCasoDistanceByVictim(Victim);
            setDistance(distance)
        } catch (error) {
            console.error("Error en obtener distancia de la victima", error);
        }
    };

    useEffect(() => {
        const interval = setInterval(() => {
            if (Victim_ID > 0) {  
                updateConnectionStatus(Victim_ID, Aggressor_ID);
                updatePosition(Victim_ID, Aggressor_ID);
                fetchDistanceByVictim(Victim_ID);
            }
        }, 15000); // 15000 milisegundos = 15 segundos

        // Función de limpieza para el intervalo
        return () => clearInterval(interval);
    }, [Victim_ID, Aggressor_ID]);
    ///////////////////////////////////////////////
    /* Le pide al Backend chequear al agresor (esta en zona, cerca de la victima...) cada 3min */

    const RealizarChequeos = async () => {
        try {
            const status = await ChequeosViewModel.getChequeos();
            if (status === 200)
                console.log('Chequeos sobre agresor realizados exitosamente')
            else
                console.log('Error al chequear amenazas del agresor, status:', status);
        } catch (error) {
            console.error("Error Chequeando amenazas del agresor", error);
        }
    };

    useEffect(() => {
        const interval = setInterval(() => {
            RealizarChequeos()
        }, 150000); // 150000 milisegundos = 2.5 minutos

        // Función de limpieza para el intervalo
        return () => clearInterval(interval);
    }, []);
    ///////////////////////////////////////////////
    /*agrega una nueva zona y posteriormente actualiza las zonas */

    const [NewZoneName, setNewZoneName] = useState("")

    const handleAddZone = async () => {
        if (Victim_ID <= 0) {
            alert('Por favor, asegúrese de seleccionar un caso.');
        } else if ( geolocationPoints.every(point => point.latitude && point.longitude) ) {
            try {
                const status = await ZonasViewModel.postNewZona(NewZoneName, geolocationPoints, Victim_ID);
    
                if (status === 200) {
                    console.log('Zona agregada con exito');

                    // Limpia el estado de geolocationPoints y NewZoneName para resetear las entradas
                    setGeolocationPoints([
                        { latitude: '', longitude: '' }, 
                        { latitude: '', longitude: '' }, 
                        { latitude: '', longitude: '' }
                    ]);
                    setNewZoneName("");

                    /*Actualiza nuevamente las zonas para cargar la ultima que se agrego*/
                    try {
                        const zonas = await ZonasViewModel.getZonas(Victim_ID);
                        setZones(zonas);
                    } catch (error) {
                        console.error("Error intentando cargar la nueva zona", error);
                    }

                } else {
                    console.log('Error al agregar la zona, status:', status);
                }
            } catch (error) {
                console.error('Error al intentar agregar la zona', error);
            } 
        } else {
            alert('Por favor, asegúrese de que todos los puntos de geolocalización tengan una latitud y una longitud válidas.');
        }
    };

    /*================== End Endpoints ==================*/

    /* COMBO BOX */
    const handleComboBoxChange = (index) => {
        fetchNombres(index);
        fetchDistance(index);

        /* actualiza los usuarios, carga zonas de seguridad, carga estados de conexion */
        fetchLoadingZonesAndStatus(index);
    };
    /* FIN COMBO BOX */

    /* FUNCIONES PARA MANEJAR LOS TEXTINPUTS DE AGREGAR NUEVA ZONA */
    const [selectedZoneName, setselectedZoneName] = useState("Any");

    const [geolocationPoints, setGeolocationPoints] = useState([
        { latitude: '', longitude: '' },
        { latitude: '', longitude: '' },
        { latitude: '', longitude: '' },
    ]);

    const addGeolocationPoint = () => {
        setGeolocationPoints([...geolocationPoints, { latitude: '', longitude: '' }]);
    };

    const deleteGeolocationPoint = () => {
        setGeolocationPoints(geolocationPoints.slice(0, -1));
    };

    const updatePoint = (index, lat, lng) => {
        const newPoints = [...geolocationPoints];
        newPoints[index] = { latitude: lat, longitude: lng };
        setGeolocationPoints(newPoints);
    };
    /* FIN FUNCIONES PARA MANEJAR LOS TEXTINPUTS DE AGREGAR NUEVA ZONA */

    /////////////////////////////////////////////////////////
    /* estiramiento del canvas por si se agregan mas coordenadas a la zona que se desea agregar */

    //Calculo de contenedores en relacion a cantidad de puntos de geolocalizacion que renderizar
    const homeHeight = 1450;         // Altura base para el contenedor
    const heightPerPoint = 68;       // Altura por cada GeolocationPoint
    const totalHeight = geolocationPoints.length * heightPerPoint;

    /////////////////////////////////////////////////////////
    /* TODO EL PROCESO PARA ACTUALIZAR EL MAPA */

    // Almacena todos los polígonos
    const [polygons, setpolygons] = useState([])

    // Crear estados para almacenar las referencias de map y maps (dentro del componente SimpleMap)
    const [map, setMap] = useState(null);
    const [maps, setMaps] = useState(null);

    // Esta función se pasa a SimpleMap y se llama con las instancias de map y maps ( UseRef )
    const handleMapLoaded = (mapInstance, mapsInstance) => {
        setMap(mapInstance);
        setMaps(mapsInstance);
    };

    // Se asegura limpiar los poligonos del mapa
    const clearPolygons = () => {
        polygons.forEach(polygon => polygon.setMap(null));
        setpolygons([]);
    };

    // Cada vez que el useState Zones es cambiado actualiza los poligonos del mapa
    useEffect(() => {
        if (map && maps && Zones) {
            renderPolygons(map, maps);
        }
    }, [Zones]);

    // Funcion para actualizar los poligonos del mapa
    const renderPolygons = (map, maps) => {
        // Primero limpia los polígonos existentes
        clearPolygons();
        
        // Luego crea los nuevos polígonos y los almacena en un nuevo array
        const newPolygons = Zones.map((zona) => {
            const polygon = new maps.Polygon({
            paths: zona.coordenadas,
            strokeColor: '#3581FF',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#3581FF',
            fillOpacity: 0.25,
            });
            polygon.setMap(map);
        
            /* LOGICA PARA SELECCIONAR POLIGONOS */
                // Configura el InfoWindow para cada polígono
                const infowindow = new maps.InfoWindow({
                content: `Nombre de Zona: ${zona.nombreZona}`,
                });
            
                // Añade el listener de eventos para cada polígono
                maps.event.addListener(polygon, 'click', () => {
                setselectedZoneName(zona.nombreZona);
                infowindow.open(map, polygon);
            
                // Restaura el color original de todos los polígonos
                newPolygons.forEach((p) => {
                    p.setOptions({ fillColor: '#3581FF', strokeColor: '#3581FF' });
                });
            
                // Cambiar el color del polígono actual
                polygon.setOptions({ fillColor: '#1400FF', strokeColor: '#1400FF' });
                });
            /* FIN LOGICA PARA SELECCIONAR POLIGONOS */

            return polygon;
        });
        
        // Actualiza el estado con los nuevos polígonos
        setpolygons(newPolygons);
    };

    /* FIN TODO EL PROCESO PARA ACTUALIZAR EL MAPA */
    /////////////////////////////////////////////////////////

  return (
    <div className='container-home' style={{height: `${totalHeight + homeHeight}px`}}>

        <div className='title-container-home'>
            <h2 className='title-home'>Case monitoring : </h2>
            <NotificationBtn rute='/Home/Notifications'/>
            <ComboBox numOptions={length} onValueChange={handleComboBoxChange}/>
            <PlusBtn rute='/Home/NewCase'/>
        </div>

        <div className='map-container'>
            <SimpleMap  victimname={Victim} 
                        aggresorname={Aggressor} 
                        renderPolygons={renderPolygons} 
                        onMapLoaded={handleMapLoaded}
                        victimPosition={VictimPosition}
                        aggressorPosition={AggressorPosition}
                        victim_id={Victim_ID}
            />
        </div>

        <div className='mts-indicator'>
            <p className='description-home'>Current distance between targets</p>
            <p className='mts-number'>{Distance}</p>
        </div>

        <div className='statecards-container'>
            <StateCard Person={Victim} isConnected={ConectVictim}/>
            <StateCard isVictim={false} isConnected={ConectAggressor} Person={Aggressor}/>
        </div>

        <h2 className='subtitle-home'>Safe areas : </h2>

        <div>
            <p className='description-home' style={{marginRight:'650px'}}>Active safe zones : {Zones.length} </p>
            <div style={{display:'flex', flexDirection:'row',alignItems:'center',justifyContent:'start', height:'80px'}}>
                {/* <SafeZoneBtn text='Delete'/> */}
                <p className='description-home' style={{marginLeft:'20px'}}>Selected zone : {selectedZoneName} </p>
            </div>
            <div style={{display:'flex', flexDirection:'row',alignItems:'center'}}>
                <SafeZoneBtn text='Add' executethis={handleAddZone}/>
                <p className='description-home' style={{marginLeft:'20px'}}>Geolocation points : </p>
                <TextInput placeholder={'Zone Name...'} Icon={FaCity} set_text={setNewZoneName} text={NewZoneName} width='440px'/>
            </div>
        </div>

        <div className='geolocation-points-container' style={{marginLeft:'550px', height: `${totalHeight}px`}}>
            {geolocationPoints.map((point, index) => (
                <GeolocationPoint 
                    key={index}
                    isFirstOne={index === 0 && (geolocationPoints.length > 3)}
                    isLastOne={index === geolocationPoints.length - 1}
                    onAdd={addGeolocationPoint}
                    onDelete={deleteGeolocationPoint}
                    latitude={point.latitude}
                    longitude={point.longitude}
                    onUpdate={(lat, lng) => updatePoint(index, lat, lng)}
                />
            ))}
        </div>
    </div>
  )
}

export default Home;