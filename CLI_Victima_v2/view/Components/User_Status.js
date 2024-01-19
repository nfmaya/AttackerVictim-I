import { StyleSheet, Text, View } from "react-native";

export default function User_Status ({ name="No Name", _isconected=false }) {
    return(
        <>
            <View style={styles.container}>
                <Text style={styles.User_Text}> {name} </Text>
                <Text style={[styles.Status_Text, {color: _isconected ? '#00FF1A' : "#FF0000"}]}> {_isconected ? 'Connected' : 'Disconnected'} </Text>
            </View>
        </>
    )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: "#878683",
        width: 300,
        height: 160,
        borderRadius: 20,
        alignItems: 'center',
        justifyContent: 'center',
    },
    User_Text: {
        color: "#fff",
        fontSize: 28,
        fontWeight: "bold",
        margin: 30,
    },
    Status_Text: {
        fontSize: 34,
        fontWeight: "bold",
        margin: 20,
    },
})