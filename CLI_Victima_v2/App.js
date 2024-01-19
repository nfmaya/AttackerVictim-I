import React, { useEffect, useState } from "react";
import { StatusBar, Text, View } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import login_screen from "./view/Screens/Login";
import HomeScreen from "./view/Screens/Home";
import Alarma from "./view/Screens/Alarma";
import Notifications_screen from "./view/Screens/Notifications";
import CustomAlert from "./view/Components/Alerta";
import FirebaseService from "./view/Components/FirebaseService";//Clase FirebaseService

export default function App() {
  const Stack = createNativeStackNavigator();
  
  // Estado para controlar la visibilidad de la alerta personalizada
  const [alertVisible, setAlertVisible] = useState(false);
    // Manejador para cuando se descarte la alerta
    const handleDismissAlert = () => {
      setAlertVisible(false);
    };
  useEffect(()=>{
    FirebaseService.requestUserPermission();
    FirebaseService.getToken();
    FirebaseService.createNotificationChannel();

    // Maneja las notificaciones entrantes cuando la aplicación está en primer plano
    FirebaseService.handleForegroundMessage();
    // Maneja las notificaciones entrantes cuando la aplicación está en segundo plano
    FirebaseService.handleBackgroundMessage();
    
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
