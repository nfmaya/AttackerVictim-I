import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, Image } from "react-native";


export default function User_Status ({ _isconected=false }) {


    const [timeString, setTimeString] = useState(getCurrentTime());
    let interval;
    
    useEffect(() => {
        if (_isconected) {
            interval = setInterval(() => {
                setTimeString(getCurrentTime());
            }, 1000);
        } else 
            clearInterval(interval);
    
        // Limpiar el intervalo al desmontar el componente o cuando _isconected cambie.
        return () => clearInterval(interval);
    }, [_isconected]);
    
    function getCurrentTime() {
        const now = new Date();
        return `${now.getHours()}:${String(now.getMinutes()).padStart(2, '0')}:${String(now.getSeconds()).padStart(2, '0')}`;
    }


    return(
        <>
            <View style={styles.container}>
                <Text style={styles.text}>Last Connection</Text>
                <Image
                    source={require('../../assets/cronometer.png')}
                    style={{
                        width: 160,
                        height: 160,
                    }}
                />
                <Text style={styles.hour}>{timeString}</Text>
            </View>
        </>
    )
}

const styles = StyleSheet.create({
    container: {
        alignItems: 'center',
        justifyContent: 'center',
    },
    text: {
        color: "#fff",
        fontSize: 32,
        fontWeight: "bold",
        margin: 25,
    },
    hour: {
        color: "#fff",
        fontSize: 60,
        fontWeight: "bold",
        margin: 16,
    },
})