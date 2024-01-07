import { StyleSheet, Switch, Text, View } from "react-native";
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

export default function Notification_Item ({ _title="NONE", mesage="hello world" }) {

    let _type;
    let _color;

    switch (_title) {
        case 'INFORMATION':
            _type = "alpha-i-circle-outline";
            _color="#084EFF";
            break;
        case 'WARNING':
            _type = "alert-outline";
            _color="#FFF500";
            break;
        default: 
            _type = "alert-circle-outline";
            _color="#FF0000";
            break;
    }

    return(
        <>
            <View style={styles.container}>
                <MaterialCommunityIcons
                    name= {_type}
                    color={_color}
                    size={40} 
                    margin= {8}
                /> 
                <View style={styles.sub_container}>
                    <Text style={styles.Text_Title}>{_title}</Text>
                    <Text style={styles.Text_content}>{mesage}</Text>
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