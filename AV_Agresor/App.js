import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import login_screen from './Screens/Login';
import registro_screen from './Screens/Register';
import home_screen from './Screens/Home';
import Notifications_screen from './Screens/Notifications';

export default function App() {

  const Stack = createNativeStackNavigator();
  
  return (
    <>
      <StatusBar style="auto"/>
      <NavigationContainer>
        <Stack.Navigator  screenOptions={{  headerStyle: {backgroundColor: '#444444'}, headerTintColor: '#fff' }}>
          <Stack.Screen name="Login" component={login_screen} options={{headerShown: false}} />
          <Stack.Screen name="Register" component={registro_screen} options={{title: "Sing Up"}}/>
          <Stack.Screen name="Home" component={home_screen} options={{headerShown: false, gestureEnabled: false}} />
          <Stack.Screen name="Notifications" component={Notifications_screen} options={{title: "Notifications"}} />
        </Stack.Navigator>
      </NavigationContainer>
    </>
  );
};
