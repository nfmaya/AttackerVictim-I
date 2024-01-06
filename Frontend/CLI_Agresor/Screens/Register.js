import React, { useState } from "react";
import { StyleSheet, View, Image, ScrollView } from "react-native";
import Boton from "../Components/Boton";
import Email_Input from "../Components/Text_Input";
import Password_Input from "../Components/Password_Input";

const Register = ({ navigation }) => {

    // Function to toggle the password visibility state 
    const toggleShowPassword = () => { 
        setShowPassword(!showPassword); 
    }; 

    const [showPassword, setShowPassword] = useState(false); 
    const [email, set_email] = useState("");
    const [tlfn, set_tlfn] = useState("");
    const [password, set_password] = useState("");

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
                        <Email_Input text= {email}  set_text= {set_email} kb_type="email-address"/>
                        <Email_Input type="phone" _placeholder="Phone Number" text= {tlfn}  set_text= {set_tlfn} kb_type="phone-pad" />
                        <Password_Input showPassword={showPassword} toggleShowPassword={toggleShowPassword} password={password} set_password={set_password}/>
                    </View>

                    <View style={{flex: 0.5, justifyContent: 'top'}}>
                        <Boton text="Register Me" color="#878683" al_apretar={() => navigation.navigate("Home")} />
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
        flex: 0.4,
        backgroundColor: '#444444',
        alignItems: 'center',
        justifyContent: 'center',
    },
    content_container: {
        flex: 0.6,
        backgroundColor: '#23851B',
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

export default Register;