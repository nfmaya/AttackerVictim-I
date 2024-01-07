import React, { useEffect, useState } from "react";
import { StyleSheet, View, Image, ScrollView, Text } from "react-native";
import Boton from "../Components/Boton";
import Email_Input from "../Components/Text_Input";
import Password_Input from "../Components/Password_Input";
import messaging from "@react-native-firebase/messaging";//FirebaseService
const Login = ({ navigation }) => {


    // Function to toggle the password visibility state 
    const toggleShowPassword = () => { 
        setShowPassword(!showPassword); 
    }; 

    const [showPassword, setShowPassword] = useState(false); 
    const [email, set_email] = useState("");
    const [password, set_password] = useState("");
    const [token, setToken] = useState('');
    // Solicita permiso y obtén el token al cargar la aplicación
  useEffect(() => {
    const requestPermissionAndGetToken = async () => {
      const authStatus = await messaging().requestPermission();
      const enabled =
        authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
        authStatus === messaging.AuthorizationStatus.PROVISIONAL;

      if (enabled) {
        console.log("Authorization status:", authStatus);
        const token = await messaging().getToken();
        console.log("Token =", token);
        setToken(token);
      }
    };

    requestPermissionAndGetToken();
  }, []);

  // Función para enviar la notificación
  const sendNotification = async () => {
    const message = {
      to: token,
      notification: {
        title: "Login",
        body: "User has logged in",
      },
    };
  
    const response = await fetch("https://fcm.googleapis.com/fcm/send", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "key=AAAACi9DFPg:APA91bEgig-o_t-K9_VHhrPXOQnpMHe_B485BDQ7dcpPEyCHGYgowx0ijRw82hvWWk7H-TTdt66AAO6WumweJT3CgS1MNQQ8ME7i9NMc2syHzNtCxScMubB5zSJZRrDxMfP93kL5pgi9", // Reemplaza esto con tu clave de servidor
      },
      body: JSON.stringify(message),
    });
  
    const responseText = await response.text();
  
    try {
      const data = JSON.parse(responseText);
      console.log("Response:", data);
    } catch (error) {
      console.error("Failed to parse JSON response. Original response:\n", responseText);
    }
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
                        <Email_Input text= {email}  set_text= {set_email} kb_type="email-address" _margin={15} />
                        <Password_Input showPassword={showPassword} toggleShowPassword={toggleShowPassword} password={password} set_password={set_password}/>
                    </View>

                    <View style={{flex: 0.5, justifyContent: 'top'}}>
                    <Boton text="Log In" color="#878683" al_apretar={async () => { navigation.navigate("Home"); await sendNotification(); }} />
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