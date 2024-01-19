import React, { useState } from 'react';
import { Modal, View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import AlertaViewModel from "../../view_model/AlertaViewModel";
import { Alert } from 'react-native'; // Importa el componente Alert
const CustomAlert = ({ visible, message, button_msg="OK", onDismiss, sos_visible=false }) => {

  const [ButtonDisabled, setButtonDisabled] = useState(false);

  const [underline, setunderline] = useState(sos_visible);
  const [Msg, setMsg] = useState(message);

  const handlePress =async () => {
    setMsg('You are already being contacted by an agent.');
    setunderline(false);
    setButtonDisabled(true);

    // Espera 10 segundos antes de volver a dar la opcion de SOS
    setTimeout(() => {
      setMsg(message);
      setunderline(sos_visible);
      setButtonDisabled(false);
    }, 10000);
    const alertaViewModel = new AlertaViewModel();
    const result = await alertaViewModel.EnviarAlerta("SOS");
    if (result.success) {
      Alert.alert("Sucess", result.message);
    } else {
      Alert.alert("Error", result.message);
    }
  };

  return (
    <Modal
      transparent={true}
      animationType="slide"
      visible={visible}
    >
      <View style={styles.centeredView}>
        <View style={styles.modalView}>

          <Text style={styles.modalText}>{Msg}</Text>

          {underline && (
            <TouchableOpacity onPress={handlePress} style={{alignSelf: 'flex-start'}}>
              <Text style={styles.underlinedText}>I'm in danger HELP !</Text>
            </TouchableOpacity>
          )}

          <TouchableOpacity style={[styles.button, ButtonDisabled ? styles.buttonDisabled : {} // Aplica estilos adicionales si el botón está deshabilitado
                                   ]} onPress={onDismiss} disabled={ButtonDisabled}>
            <Text style={styles.buttonText}>{button_msg}</Text>
          </TouchableOpacity>

        </View>
      </View>
    </Modal>
  );
};

const styles = StyleSheet.create({
  centeredView: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "rgba(0,0,0,0.6)"
  },
  modalView: {
    margin: 24,
    backgroundColor: "black",
    borderRadius: 20,
    padding: 30,
    alignItems: "center",
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 2
    },
    shadowOpacity: 0.25,
    shadowRadius: 4,
    elevation: 5
  },
  modalText: {
    marginBottom: 20,
    textAlign: 'justify',
  },
  button: {
    borderRadius: 20,
    paddingVertical: 10,
    paddingHorizontal: 20,
    elevation: 2,
    backgroundColor: "#878683"
  },
  buttonText: {
    color: "black",
    fontWeight: "bold",
    textAlign: "center"
  },
  buttonDisabled: {
    backgroundColor: '#BAB8B8',
  },
  underlinedText: {
    textDecorationLine: 'underline',
    color: 'white',
    fontWeight: "bold",
    marginBottom: 20,
    fontSize: 16
  }
});

export default CustomAlert;