import React, { useState, useEffect } from 'react';
import { PermissionsAndroid, Platform, StyleSheet, View, Text } from "react-native";
import User_Status from "../Components/User_Status";
import Img_Button from "../Components/Boton_Imagen";
import NetInfo from '@react-native-community/netinfo';
import Geolocation from 'react-native-geolocation-service';

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
            console.log("Location permission granted");

            const watcher = Geolocation.watchPosition(
                (position) => {
                  setLocationData(position.coords);
                },
                (error) => {
                  console.warn(error);
                },
                { 
                  enableHighAccuracy: true, 
                  distanceFilter: 1,
                  interval: 5000, 
                  fastestInterval: 2000 
                }
            );

            setLocationWatcher(watcher);

        } else {
            console.log("Location permission denied");

            alert('Permission to access location was denied');
            return;
        }
    }

    useEffect(() => {
        requestLocationPermission();
    
        return () => {
            if (locationWatcher) {
                locationWatcher.remove();
            }
        }
    }, []);
    /////////////////////////////////////////////////////////////
    //Geolocalizacion - Obtiene Poligonos
    /////////////////////////////////////////////////////////////
    /* const polygonsCoordinates = [
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
    ]; */
    /////////////////////////////////////////////////////////////


    return(

        <View>
            <Text>hola</Text>
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