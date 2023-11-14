import React, { useState, useEffect } from 'react';
import { StyleSheet, View, Text } from "react-native";
import User_Status from "../Components/User_Status";
import Img_Button from "../Components/Boton_Imagen";
import NetInfo from '@react-native-community/netinfo';
import * as Location from 'expo-location';
import MapView, { Marker, Polygon } from 'react-native-maps';

const Home = ({ navigation }) => {


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

    async function startLocationTracking() {
        let { status } = await Location.requestForegroundPermissionsAsync();
        if (status !== 'granted') {
          alert('Permission to access location was denied');
          return;
        }
      
        //let location = await Location.getCurrentPositionAsync({});
        //setLocationData(location.coords);

        const watcher = await Location.watchPositionAsync(
            { accuracy: Location.Accuracy.High, timeInterval: 5000, distanceInterval: 1 },  // actualiza cada 5 segundos y si se movio almenos 1 metro.
            (location) => {
                setLocationData(location.coords);
            }                                                          // espera a recibir un callback para pasar las coordenadas.
        );
    
        setLocationWatcher(watcher);
    }

    useEffect(() => {
        startLocationTracking();
    
        return () => {
            if (locationWatcher) {
                locationWatcher.remove();
            }
        }
    }, []);
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
    ];
    /////////////////////////////////////////////////////////////


    return(

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
                <Marker
                    coordinate={{
                    latitude: locationData.latitude,
                    longitude: locationData.longitude,
                    }}
                    title={"Your Location"}
                />

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
                <User_Status name="Alejandro Salas" _isconected={isConnected} />
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
        flex : 1,
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
});

export default Home;