import { StyleSheet, View, ScrollView } from "react-native";
import Not_Item from "../Components/Notification_Item";

const Notifications = ({ navigation }) => {

    return(
        <View style={styles.container}>
            <ScrollView contentContainerStyle={styles.scrollview}>
                <Not_Item />
                <Not_Item />
                <Not_Item />
                <Not_Item />
                <Not_Item />
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

export default Notifications;