import React, { useEffect, useState } from 'react';
import { Text, StyleSheet, TouchableOpacity} from 'react-native';

export default function Boton_Anim ({al_apretar}) {
  
  const [color, setColor] = useState('rgba(255, 0, 0, 0.5)');

  useEffect(() => {
    const intervalId = setInterval(() => {
      setColor(prevColor =>
        prevColor === 'rgba(255, 0, 0, 0.5)' ? 'rgba(255, 0, 0, 1)' : 'rgba(255, 0, 0, 0.5)'
      );
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return (
    <TouchableOpacity style={[styles.button, { backgroundColor: color }]} onPress={al_apretar}>
        <Text style={styles.text}>SOS</Text>
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  button: {
    padding: 20,
    justifyContent: 'center',
    alignItems: 'center',
    margin: 20,
    width: 140,
    height: 140,
    borderRadius: 70,
  },
  text: {
    color: 'white',
    fontSize: 50,
    fontWeight: 'bold',
  },
});