import React, { useEffect, useState } from "react";
import { StyleSheet, View, Image, ScrollView, Text } from "react-native";
import Boton from "../Components/Boton";
import Email_Input from "../Components/Text_Input";
import Password_Input from "../Components/Password_Input";
import FirebaseService from "../Components/FirebaseService";
import messaging from "@react-native-firebase/messaging";//FirebaseService
import axios from 'axios'; // Para hacer las solicitudes HTTP
import { Alert } from 'react-native'; // Importa el componente Alert


const Login = ({ navigation }) => {

    // Function to toggle the password visibility state 
    const toggleShowPassword = () => { 
        setShowPassword(!showPassword); 
    }; 

    const [showPassword, setShowPassword] = useState(false); 
    const [username, set_username] = useState("");
    const [password, set_password] = useState("");
    const [token, setToken] = useState('');

    // Solicita permiso al firebase y obtén el token al cargar la aplicación
    useEffect(() => {
      const getToken = async () => {
        const token = await FirebaseService.requestPermissionAndGetToken();
        setToken(token);
        FirebaseService.createNotificationChannel();
      };
    
      getToken();
    }, []);


  const handleLogin = async () => {
    //Esto lo hago para probar si se envian notificaciones push
    await FirebaseService.sendNotification(token);

    //Variable para guardar el JSON de todo los datos del usuario
    let userDetails = null;  
    
    try{// Obtiene los detalles del usuario
      const response = await axios.get(`https://8hnz2brw-8080.use2.devtunnels.ms/cmcapp-backend-1.0/api/v1/usuarios/username/${username}`);
      userDetails = response.data.response;
    } catch (error) {
      console.error(error);
    }
    //Agregar el imei en la API backend solo para el usuario nuevo que acaba de ingresar sesión
    if (userDetails.imei=="" || userDetails.imei==token) {
      try {
        // Actualiza el IMEI del usuario
        const updatedUserDetails = { ...userDetails, imei: token };
        await axios.put(`https://8hnz2brw-8080.use2.devtunnels.ms/cmcapp-backend-1.0/api/v1/usuarios/update`, updatedUserDetails);
        //Lo cambia a home
        navigation.navigate("Home");
      } catch (error) {
        console.error(error);
      }
      //Si ya inicio sesión en otro telefono, no podra entrar y le sale este error 
    }else{Alert.alert(
      "Error",
      "No se puede agregar porque ya inicio sesión en otro teléfono"
    );};
    
  };
    return(
        <View style={styles.container}>
            <View style={styles.header_container}>
                <Image
                    source={require('../assets/logo_app.jpg')}
                    style={{
                        width: 200,
                        height: 200,
                        borderRadius: 20,
                    }}
                />
            </View>
            <View style={styles.content_container}>
                <ScrollView contentContainerStyle={styles.scrollview} showsVerticalScrollIndicator={false}> 

                    <View style={{flex: 0.5, justifyContent: 'center', alignItems: 'center'}}> 
                        <Email_Input text={username} set_text={set_username} kb_type="default" _margin={15} />
                        <Password_Input showPassword={showPassword} toggleShowPassword={toggleShowPassword} password={password} set_password={set_password}/>
                    </View>
                    <View style={{flex: 0.5, justifyContent: 'top'}}>
                    <Boton text="Log In" color="#878683" al_apretar={handleLogin} />
                    </View>
                </ScrollView>
                </View>
        </View> 
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#444444',
      justifyContent: 'center',
    },
    header_container: {
        flex: 0.5,
        backgroundColor: '#444444',
        alignItems: 'center',
        justifyContent: 'center',
    },
    content_container: {
        flex: 0.5,
        backgroundColor: '#2069E0',
        alignItems: 'center',
        justifyContent: 'center',
        borderTopLeftRadius: 30,
        borderTopRightRadius: 30,
        padding: 5,
    },
    scrollview: {
        flexGrow: 1,
        justifyContent: 'center', 
        alignItems: 'center',
    },
});

export default Login;