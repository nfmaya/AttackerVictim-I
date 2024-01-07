import { StatusBar, View, Text  } from 'react-native';
import React, { useState } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import login_screen from './Screens/Login';
import registro_screen from './Screens/Register';
import HomeScreen from './Screens/Home';
import Notifications_screen from './Screens/Notifications';
import CustomAlert from "./Components/Alerta";

export default function App() {

  const Stack = createNativeStackNavigator();
  
  // Estado para controlar la visibilidad de la alerta personalizada
  const [alertVisible, setAlertVisible] = useState(false);

  // Función para manejar el cierre de la alerta
  const handleDismissAlert = () => {
    setAlertVisible(false);
  };


  function NoBackScreen({navigation}) {
  
    React.useEffect(() => {
      const unsubscribe = navigation.addListener('beforeRemove', (e) => { //se dispara justo antes de que quites una pantalla.
        // Previenes el comportamiento predeterminado (que elimine la pantalla y volver a la anterior en la pila)
        e.preventDefault();
  
        // Manda una alerta al usuario
        /*Alert.alert(
          'Log Out!',
          'You cant go back from this screen.',
          [{ text: "OK", style: 'cancel', onPress: () => {} }]
        );*/
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
          <Stack.Screen name="Register" component={registro_screen} options={{title: "Sing Up"}}/>
          <Stack.Screen name="Home" component={NoBackScreen} options={{headerShown: false, gestureEnabled: false}} />
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
