import React, { useEffect, useState } from "react";
import { StatusBar, Text, View } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import login_screen from "./Screens/Login";
import HomeScreen from "./Screens/Home";
import Alarma from "./Screens/Alarma";
import Notifications_screen from "./Screens/Notifications";
import CustomAlert from "./Components/Alerta";
import messaging from "@react-native-firebase/messaging";
import PushNotification from "react-native-push-notification";


export default function App() {
  const Stack = createNativeStackNavigator();
  
  // Estado para controlar la visibilidad de la alerta personalizada
  const [alertVisible, setAlertVisible] = useState(false);

  // Función para manejar el cierre de la alerta
  const handleDismissAlert = () => {
    setAlertVisible(false);
  };

  //Funcion de firebase
  async function requestUserPermission() {
    const authStatus = await messaging().requestPermission();
    const enabled =
      authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
      authStatus === messaging.AuthorizationStatus.PROVISIONAL;
  
    if (enabled) {
      console.log('Authorization status:', authStatus);
    }
  }

  //Aqui obtengo el token de firebase
  const getToken =async()=>{
    const token=await messaging().getToken()
    console.log("Token =",token)
  }

  useEffect(()=>{
    requestUserPermission()
    getToken()

    // Maneja las notificaciones entrantes cuando la aplicación está en primer plano
    messaging().onMessage(async remoteMessage => {
      console.log('A new FCM message arrived!', JSON.stringify(remoteMessage));

      // Muestra la notificación al usuario
      PushNotification.localNotification({
        title: remoteMessage.notification.title,
        message: remoteMessage.notification.body,
      });
    });

    // Maneja las notificaciones entrantes cuando la aplicación está en segundo plano
    messaging().setBackgroundMessageHandler(async remoteMessage => {
      console.log('A new FCM message arrived in the background!', JSON.stringify(remoteMessage));
    });
  },[])

  function NoBackScreen({navigation}) {
  
    React.useEffect(() => {
      const unsubscribe = navigation.addListener('beforeRemove', (e) => { //se dispara justo antes de que quites una pantalla.
        // Previenes el comportamiento predeterminado (que elimine la pantalla y volver a la anterior en la pila)
        e.preventDefault();
  
        setAlertVisible(true)
      });
      
      //cuando se desmonte NoBackScreen limpiamos para evitar fugas de memoria.
      return unsubscribe;
    }, [navigation]);
  
    // Pasa el navigation a HomeScreen (para poder accerde a notifications)
    return <HomeScreen navigation={navigation} />;
  }


  return (
    <>
      <StatusBar style="auto"/>
      <NavigationContainer>
        <Stack.Navigator  screenOptions={{  headerStyle: {backgroundColor: '#444444'}, headerTintColor: '#fff' }}>
          <Stack.Screen name="Login" component={login_screen} options={{headerShown: false}} />
          <Stack.Screen name="Home" component={NoBackScreen} options={{headerShown: false, gestureEnabled: false}} />
          <Stack.Screen name="Alarm" component={Alarma} options={{title: "Alarm"}} />
          <Stack.Screen name="Notifications" component={Notifications_screen} options={{title: "Notifications"}} />
        </Stack.Navigator>
      </NavigationContainer>

      <CustomAlert
        visible={alertVisible}
        message="You cant go back from this screen, you must remain logged in at all times."
        onDismiss={handleDismissAlert}
      />
    </>
  );
};
