import React, { useState, useEffect } from 'react'
import './Home.css'
import StateCard from '../components/StateCard'
import SafeZoneBtn from '../components/SafeZoneBtn'
import GeolocationPoint from '../components/GeolocationPoint'
import ComboBox from '../components/ComboBox'
import PlusBtn from '../components/PlusBtn'
import NotificationBtn from '../components/NotificationsBtn'
import SimpleMap from '../components/SimpleMap'
import {readSafeZones} from '../viewmodel/data'

function Home() {

    const [selectedZoneName, setselectedZoneName] = useState("Any");

    const [Victim, setVictim] = useState("Alejandro Salas");
    const [Aggressor, setAggressor] = useState("Diego De Queiros");
    const [Distance, setDistance] = useState(15);

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

    /////////////////////////////////////////////////////////
    /* estiramiento del canvas por si se agregan mas coordenadas a la zona que se desea agregar */

    //Calculo de contenedores en relacion a cantidad de puntos de geolocalizacion que renderizar
    const homeHeight = 1450;         // Altura base para el contenedor
    const heightPerPoint = 68;       // Altura por cada GeolocationPoint
    const totalHeight = geolocationPoints.length * heightPerPoint;

    /////////////////////////////////////////////////////////
    /*extrae las zonas seguras con las coordenadas del json*/
    const zones = readSafeZones;

    // Almacena todos los polígonos
    const polygons = [];

    const renderPolygons = (map, maps) => {
        // Crea y añade los polígonos al mapa
        zones.forEach((zona) => {
          const polygon = new maps.Polygon({
            paths: zona.coordenadas,
            strokeColor: '#3581FF',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#3581FF',
            fillOpacity: 0.25,
          });
          polygon.setMap(map);

          polygons.push(polygon); // Agrega el polígono a la lista

          const infowindowhola = new maps.InfoWindow({
              content: `Nombre de Zona: ${zona.nombreZona}`
          });

          maps.event.addListener(polygon, 'click', () => {
            setselectedZoneName(zona.nombreZona);
            infowindowhola.open(map, polygon);

            // Restaura el color original de todos los polígonos
            polygons.forEach((p) => {
                p.setOptions({ fillColor: '#3581FF',  strokeColor: '#3581FF'});
            });

            // Cambiar el color del polígono actual
            polygon.setOptions({ fillColor: '#1400FF',  strokeColor: '#1400FF'});
          });
        });
    };
    /////////////////////////////////////////////////////////

  return (
    <div className='container-home' style={{height: `${totalHeight + homeHeight}px`}}>

        <div className='title-container-home'>
            <h2 className='title-home'>Case monitoring : </h2>
            <NotificationBtn rute='/Home/Notifications'/>
            <ComboBox/>
            <PlusBtn rute='/Home/NewCase'/>
        </div>

        <div className='map-container'>
            <SimpleMap victimname={Victim} aggresorname={Aggressor} renderPolygons={renderPolygons}/>
        </div>

        <div className='mts-indicator'>
            <p className='description-home'>Current distance between targets</p>
            <p className='mts-number'>{Distance}</p>
        </div>

        <div className='statecards-container'>
            <StateCard Person={Victim}/>
            <StateCard isVictim={false} isConnected={true} Person={Aggressor}/>
        </div>

        <h2 className='subtitle-home'>Safe areas : </h2>

        <div>
            <p className='description-home' style={{marginRight:'650px'}}>Active safe zones : {readSafeZones.length} </p>
            <div style={{display:'flex', flexDirection:'row',alignItems:'center'}}>
                <SafeZoneBtn text='Delete'/>
                <p className='description-home' style={{marginLeft:'20px'}}>Selected zone : {selectedZoneName} </p>
            </div>
            <div style={{display:'flex', flexDirection:'row',alignItems:'center'}}>
                <SafeZoneBtn text='Add'/>
                <p className='description-home' style={{marginLeft:'20px'}}>Geolocation points : </p>
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

export default Home