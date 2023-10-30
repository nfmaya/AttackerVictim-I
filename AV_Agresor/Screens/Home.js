import React, { useState, useEffect } from 'react';
import { StyleSheet, View, Text } from "react-native";
import User_Status from "../Components/User_Status";
import Last_Conection from "../Components/Last_Conection";
import Img_Button from "../Components/Boton_Imagen";
import NetInfo from '@react-native-community/netinfo';
import * as Location from 'expo-location';

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
      
        /*let location = await Location.getCurrentPositionAsync({});
        setLocationData(location.coords);*/

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

    return(
        <View style={styles.container}>
            <View style={{flex: 0.3, justifyContent: 'flex-end'}}>
                <User_Status name="Diego De Queiros" _isconected={isConnected} />
            </View>
            <View style={styles.sub_container}>
                {locationData ? (
                                    <Text>Latitud: {locationData.latitude}, Longitud: {locationData.longitude}</Text>
                                ) : (
                                    <Text>Obteniendo coordenadas...</Text>
                                )
                }
                <Last_Conection _isconected={isConnected} />
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
});

export default Home;