import { TouchableOpacity, StyleSheet, Text } from "react-native";

export default function Boton ({ al_apretar, text="Boton", color="#444444" }) {
    return(
        <>
            <TouchableOpacity style={[styles.Btn, { backgroundColor: color }]} onPress={al_apretar} >
                <Text style={styles.Btn_Text}>{text}</Text>
            </TouchableOpacity>
        </>
    )
}

const styles = StyleSheet.create({
    Btn_Text: {
        color: "#FFF",
        fontSize: 18, 
    },
    Btn: {
        padding: 18,
        margin: 10,
        width: 200,
        borderRadius: 20,
        alignItems: 'center',
        justifyContent: 'center',
    },
})