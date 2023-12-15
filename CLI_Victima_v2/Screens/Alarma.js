import React, { useState, useEffect } from 'react';
import { StyleSheet, View, Text } from "react-native";
import Img_Button from "../Components/Boton_Imagen";
import Last_Conection from "../Components/Last_Conection";
import NetInfo from '@react-native-community/netinfo';
import Anim_Button from "../Components/Boton_Animado";
import CustomAlert from "../Components/Alerta";

const Alarma = ({ navigation }) => {

    /////////////////////////////////////////////////////////////
    //mensaje de advertencia
    /////////////////////////////////////////////////////////////

    // Estado para controlar la visibilidad de la alerta personalizada
    const [alertVisible, setAlertVisible] = useState(false);

    // Función para manejar el cierre de la alerta
    const handleDismissAlert = () => {
        setAlertVisible(false);
    };

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

    return(
        <View style={styles.container}>
            <View style={{flex:0.5}}>
                <Last_Conection _isconected={isConnected} />
            </View>
            
            <View style={{flex:0.3, marginTop: 20 }} >
                <Anim_Button al_apretar={() => setAlertVisible(true)}/>
            </View>

            <View style={{flex:0.2}}>
                <Img_Button al_apretar={() => navigation.navigate("Notifications")}/>
            </View>

            <CustomAlert
                visible={alertVisible}
                button_msg='CANCEL'
                sos_visible='true'
                message={'Are you sure you want to press the button ?\n\nDo so only if you feel in real danger, by doing so you will be contacted by an agent shortly.'}
                onDismiss={handleDismissAlert}
            />
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
});

export default Alarma;