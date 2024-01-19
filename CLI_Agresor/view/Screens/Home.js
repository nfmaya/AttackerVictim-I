import React, { useState, useEffect } from 'react';
import { PermissionsAndroid, Platform, StyleSheet, View, Text } from "react-native";
import User_Status from "../Components/User_Status";
import Last_Conection from "../Components/Last_Conection";
import Img_Button from "../Components/Boton_Imagen";
import NetInfo from "@react-native-community/netinfo";
import Geolocation from 'react-native-geolocation-service';
import HomeViewModel from '../../view_model/HomeViewModel';
import PosicionViewModel from '../../view_model/PosicionViewModel';
const Home = ({ navigation }) => {
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
          const response = await posicionViewModel.handleAddPosicionAgresor(locationData.latitude, locationData.longitude, fechaHora, usuarioId);
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
        
    
    return(
        <View style={styles.container}>
            <View style={{flex: 0.3, justifyContent: 'flex-end'}}>
            <User_Status name={username} _isconected={isConnected} />
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