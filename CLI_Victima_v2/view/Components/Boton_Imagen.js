import { TouchableOpacity, StyleSheet } from "react-native";
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

export default function Boton_Imagen ({ al_apretar,type="bell", color="#878683", _size=30 }) {
    return(
        <>
            <TouchableOpacity style={[styles.Btn, { backgroundColor: color }]} onPress={al_apretar} >
                <MaterialCommunityIcons
                    name= {type}
                    size={_size} 
                    style={styles.Btn_icon} 
                /> 
            </TouchableOpacity>
        </>
    )
}

const styles = StyleSheet.create({
    Btn: {
        padding: 10,
        marginVertical: 5,
        marginHorizontal: 35,
        width: 70,
        height: 70,
        borderRadius: 20,
        alignItems: 'center',
        justifyContent: 'center',
    },
    Btn_icon: { 
        color: '#fff'
    },
})