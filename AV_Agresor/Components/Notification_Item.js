import { StyleSheet, Text, View } from "react-native";
import { MaterialCommunityIcons} from '@expo/vector-icons'; 

export default function Notification_Item ({ type="alert-circle-outline", _color="#FF0000" }) {
    return(
        <>
            <View style={styles.container}>
                <MaterialCommunityIcons
                    name= {type}
                    color={_color}
                    size={40} 
                    margin= {8}
                /> 
                <View style={styles.sub_container}>
                    <Text style={styles.Text_Title}>ERROR</Text>
                    <Text style={styles.Text_content}>Por favor active la ubicaion en tiempo real en su telefono.</Text>
                </View>
            </View>
        </>
    )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: "#878683",
        flexDirection: "row",
        height: 100,
        borderRadius: 20,
        margin: 5,
        padding : 5,
        alignItems: "center",
    },
    sub_container: {
        width:300,
        alignItems: "baseline",
        justifyContent: 'center',
    },
    Text_Title: {
        color: "#fff",
        fontSize: 22,
        fontWeight: "bold",
        margin: 5,
    },
    Text_content: {
        color: "#fff",
        fontSize: 16,
        margin: 5,
    },
})