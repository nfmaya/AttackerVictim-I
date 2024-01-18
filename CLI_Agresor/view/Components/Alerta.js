import React, { useState } from 'react';
import { Modal, View, Text, StyleSheet, TouchableOpacity } from 'react-native';

const CustomAlert = ({ visible, message, onDismiss }) => {
  return (
    <Modal
      transparent={true}
      animationType="slide"
      visible={visible}
    >
      <View style={styles.centeredView}>
        <View style={styles.modalView}>
          <Text style={styles.modalText}>{message}</Text>
          <TouchableOpacity style={styles.button} onPress={onDismiss}>
            <Text style={styles.buttonText}>OK</Text>
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
    backgroundColor: "white",
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
    marginBottom: 24,
    textAlign: 'center',
  },
  button: {
    borderRadius: 20,
    width : 60,
    padding: 10,
    elevation: 2,
    backgroundColor: "#878683"
  },
  buttonText: {
    color: "white",
    fontWeight: "bold",
    textAlign: "center"
  }
});

export default CustomAlert;