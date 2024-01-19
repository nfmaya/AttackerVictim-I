import React, { useEffect, useState } from 'react';
import { StyleSheet, View, ScrollView, Button } from "react-native";
import Not_Item from "../Components/Notification_Item";
import NotificacionViewModel from '../../view_model/NotificacionViewModel';

const Notifications = ({ navigation }) => {
    const notificacionViewModel = new NotificacionViewModel();
    const [notifications, setNotifications] = useState([]);
    
    useEffect(() => {
        // Obtener las alertas recientes una vez al inicio
        const fetchData = async () => {
            const response = await notificacionViewModel.handleGetRecentAlertas();
            if(response){
                const newNotifications = response.map(alert => {
                    return {
                        _title: "INFORMATION",
                        mesage: alert._tipoAlerta
                    };
                });
                setNotifications(prevNotifications => [...prevNotifications, ...newNotifications]);
            }
        };
    
        fetchData();
    }, []);
    

    const handleRemoveNotification = (index) => {
        setNotifications(prevNotifications => prevNotifications.filter((_, i) => i !== index));
    };
    

    return(
        <View style={styles.container}>
            <ScrollView contentContainerStyle={styles.scrollview}>
                {notifications.map((notification, index) => (
                    <View key={index}>
                        <Not_Item _title={notification._title} mesage={notification.mesage} />
                    </View>
                ))}
            </ScrollView>
        </View>
    );
}


const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#444444',
    },
    scrollview: {
        flexGrow: 1,
    },
});

export default Notifications;






/**const Notifications = ({ navigation }) => {

    return(
        <View style={styles.container}>
            <ScrollView contentContainerStyle={styles.scrollview}>
                <Not_Item _title="INFORMATION" mesage="We now offer customer support 12 hours a day." />
                <Not_Item _title="WARNING" mesage="We need that you verify your email." />
                <Not_Item _title="ERROR" mesage="Please activate real-time location on your phone." />
                <Not_Item />
                <Not_Item />
                <Not_Item />
                <Not_Item />
                <Not_Item />
            </ScrollView>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#444444',
    },
    scrollview: {
        flexGrow: 1,
    },
});

export default Notifications;*/