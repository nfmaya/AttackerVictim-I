import React, {  useRef ,useState, useEffect } from 'react';
import { PermissionsAndroid, Platform, StyleSheet, View, Text, Alert } from "react-native";
import User_Status from "../Components/User_Status";
import Img_Button from "../Components/Boton_Imagen";
import MapView, { Marker, Polygon } from 'react-native-maps';
import NetInfo from '@react-native-community/netinfo';
import Geolocation from 'react-native-geolocation-service';
import HomeViewModel from '../../view_model/HomeViewModel';
import PosicionViewModel from '../../view_model/PosicionViewModel';

const Home = ({ navigation}) => {
    /////////////////////////////////////////////////////////////
    //Nombre del Usuario
    ////////////////////////////////////////////////////////////
 
    const homeViewModel = new HomeViewModel();
    const [username, set_username] = useState("");
    useEffect(() => {
        const fetchUserName = async () => {
         
          const name = await homeViewModel.getUserName(global.usernameusuario);
          set_username(name);
        };
      
        fetchUserName();
      }, []);

    /////////////////////////////////////////////////////////////
    //Conectado a internet
    /////////////////////////////////////////////////////////////
    const [isConnected, set_IsConnected] = useState(false);

    useEffect(() => {
        // Suscribirse al cambio de estado de la conexión
        const unsubscribe = NetInfo.addEventListener(state => {
            set_IsConnected(state.isConnected);
        });

        // Revisar la conexión inicial
        NetInfo.fetch().then(state => {
            set_IsConnected(state.isConnected);
        });

        // Desuscribirse al desmontar el componente
        return () => unsubscribe();
    }, []);

    /////////////////////////////////////////////////////////////
    //Geolocalizacion - permisos - Obtiene puntos
    /////////////////////////////////////////////////////////////

    const [locationData, setLocationData] = useState(null);
    const [locationWatcher, setLocationWatcher] = useState(null);

    //Actualizacion de posicion
    useEffect(() => {
        const watchId = Geolocation.watchPosition(
          (position) => {
            const { latitude, longitude } = position.coords;
            setLocationData({ latitude, longitude });
          },
          (error) => {
            console.error(error);
          },
          {
            enableHighAccuracy: true,
            distanceFilter: 10,
            interval: 15000, // Actualiza cada 15 segundos
          }
        );
    
        // Limpieza: detener el seguimiento de la ubicación cuando el componente se desmonte
        return () => Geolocation.clearWatch(watchId);
      }, []);
    async function requestLocationPermission() {
        
        let granted;

        if (Platform.OS === 'android') {
            try {
                granted = await PermissionsAndroid.request(
                PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
                {
                title: "Location Permission",
                message: "This app needs access to your location.",
                buttonNeutral: "Ask Me Later",
                buttonNegative: "Cancel",
                buttonPositive: "OK"
                }
            );
            } catch (err) {
            console.warn(err);
            }
        }

        if (granted === PermissionsAndroid.RESULTS.GRANTED) {
            Geolocation.watchPosition(
                (position) => {
                    // Actualiza el estado
                    setLocationData(position.coords);
                },
                (error) => {
                    console.warn(error);
                },
                { enableHighAccuracy: true, timeout: 15000, maximumAge: 10000 }
            );
        } else {
            console.log("Location permission denied");
            alert('Permission to access location was denied');
            return;
        }
    }
    
    /////////////////////////////////////////////////////////////
    //Geolocalizacion - Envia coordenadas a la API
    /////////////////////////////////////////////////////////////
    const posicionViewModel = new PosicionViewModel();
    const  [distanciaagresor, setdistanciaagresor] = useState("");
      
      const runLogic = async () => {
        console.log(locationData)
          if (locationData) {
          const fechaHora = Date.now();
          const usuarioId = global.idusuario; // Aquí debes poner el ID del usuario actual
          console.log(usuarioId);
          const response = await posicionViewModel.handleAddPosicionVictima(locationData.latitude, locationData.longitude, fechaHora, usuarioId);
          setdistanciaagresor(global.distanciaagresor);
          console.log(response); // Puedes manejar la respuesta como necesites
          }
      };

      //Solicita permisos, y agrega valor a locationData

        useEffect(() => {
            requestLocationPermission();
        }, []);


        useEffect(() => {
            let intervalId;
            if (locationData) {
                intervalId = setInterval(() => {
                    runLogic();
                }, 15000); // 15000 milisegundos = 15 segundos
            }
        
            // Función de limpieza para el intervalo y el watcher
            return () => {
                if (intervalId) clearInterval(intervalId);
                if (locationWatcher) {
                    Geolocation.clearWatch(locationWatcher);
                }
            };
        }, [locationData]); 
        
    /////////////////////////////////////////////////////////////
    //Geolocalizacion - Obtiene Poligonos
    /////////////////////////////////////////////////////////////
    const polygonsCoordinates = [
        [
          { latitude: 10.492424, longitude: -66.819250 },
          { latitude: 10.485018, longitude: -66.820558 },
          { latitude: 10.491875, longitude: -66.829120 },
          { latitude: 10.494344, longitude: -66.827361 },
          { latitude: 10.492424, longitude: -66.819250 }, // cerrando el polígono
        ],
        [
          { latitude: 10.494093, longitude: -66.810209 },
          { latitude: 10.491663, longitude: -66.812474 },
          { latitude: 10.492842, longitude: -66.813944 },
          { latitude: 10.495149, longitude: -66.811942 },
          { latitude: 10.495122, longitude: -66.811400 },
          { latitude: 10.494093, longitude: -66.810209 }, // cerrando el polígono
        ],
        [
            { latitude: 10.463126, longitude: -66.978135 },
            { latitude: 10.464029, longitude: -66.978567 },
            { latitude: 10.465514, longitude: -66.976898 },
            { latitude: 10.465357, longitude: -66.974129 },
            { latitude: 10.464895, longitude: -66.973757 },
            { latitude: 10.464410, longitude: -66.975032 },
            { latitude: 10.463887, longitude: -66.975206 },
            { latitude: 10.463126, longitude: -66.978135 }, // cerrando el polígono
        ],
    ];

    /////////////////////////////////////////////////////////////
    //Enviar Posicion
    ////////////////////////////////////////////////////////////
    

    return (
        <View style={styles.container}>

        {locationData ? (
        <MapView
            style={styles.map}
            initialRegion={{
                latitude: locationData.latitude,
                longitude: locationData.longitude,
                latitudeDelta: 0.0922,
                longitudeDelta: 0.0421,
            }}
            onMapReady={() => {
                // El mapa está listo y puedes ajustar la cámara o los límites aquí si es necesario
            }}
            showsUserLocation={true}
            followsUserLocation={true}
        >


            {polygonsCoordinates.map((polygon, index) => (
                <Polygon
                    key={index}
                    coordinates={polygon}
                    strokeColor="#F00" // color del borde
                    fillColor="rgba(255,0,0,0.2)" // color de relleno
                    strokeWidth={2}
                />
            ))}

        </MapView>
        ) : (
            //indicador de carga mientras esperas la ubicación
            <Text style={styles.loadingText} >Obteniendo ubicacion...</Text>
        )}

        <View style={styles.statusContainer}>
        <User_Status name={username} _isconected={isConnected} /> 
        <Text style={styles.Agresordirectextenum} >{"Distancia del agresor:"}</Text>
        <Text style={styles.Agresordirecval} >{distanciaagresor?(distanciaagresor+" metros"):"Cargando distancia"}</Text>
        </View>

        <View style={styles.botton_container}>
            <Img_Button al_apretar={() => navigation.navigate("Alarm")} type='home' _size={37}/>
            <Img_Button al_apretar={() => navigation.navigate("Notifications")}/>
        </View>

    </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#444444',
      justifyContent: 'center',
      alignItems: 'center',
    },
    sub_container: {
        flex: 0.7,
        justifyContent: 'center',
        alignItems: 'center',
    },
    botton_container: {
        position: 'absolute',
        bottom: 50,
        left: 0,
        right: 0,
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'flex-end',
    },
    map: {
        width: "100%",
        height: "100%"
    },
    statusContainer: {
        position: 'absolute',
        top: 60,
        left: 0,
        right: 0,
        justifyContent: 'flex-start',
        alignItems: 'center',
    },
    loadingText: {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: [{ translateX: -85 }, { translateY: 0 }],
        color: '#fff',
        fontSize: 16,
    },
    Agresordirectextenum: {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: [{ translateX: -80 }, { translateY: -20 }],
        color: '#fff',
        fontSize: 16,
    },
    Agresordirecval: {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: [{ translateX: -45 }, { translateY: 2 }],
        color: '#fff',
        fontSize: 16,
    }
});

export default Home;