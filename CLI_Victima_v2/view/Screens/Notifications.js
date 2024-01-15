import { StyleSheet, View, ScrollView } from "react-native";
import Not_Item from "../Components/Notification_Item";

const Notifications = ({ navigation }) => {

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

export default Notifications;