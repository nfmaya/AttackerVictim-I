import React, { useEffect, useState } from "react";
import { StyleSheet, View, Image, ScrollView, Text } from "react-native";
import Boton from "../Components/Boton";
import Email_Input from "../Components/Text_Input";
import Password_Input from "../Components/Password_Input";
import FirebaseService from "../Components/FirebaseService";//Clase Firebase
import { Alert } from 'react-native'; // Importa el componente Alert
import LoginViewModel from "../../view_model/LoginViewModel";

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

    /////////////////////////////////////////////////////////////
    //Se valida el usuario cuando quiere inicia sesion
    ////////////////////////////////////////////////////////////
    const loginViewModel = new LoginViewModel();

    const handleLogin = async () => {
      const result = await loginViewModel.handleLogin(username, password, token, navigation);
      if (result.success) {
        global.usernameusuario = username;
        navigation.navigate('Home');
      } else {
        Alert.alert("Error", result.message);
      }
    };
    return(
        <View style={styles.container}>
            <View style={styles.header_container}>
                <Image
                    source={require('../../assets/logo_app.jpg')}
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