import React from 'react';
import { View, TextInput, StyleSheet } from 'react-native';
import { MaterialCommunityIcons} from '@expo/vector-icons'; 

export default function Text_Input ({ type="key", _placeholder="Password", password="", set_password, showPassword=false, toggleShowPassword, _margin=10 }) {

    return(
        <>
            <View style={[styles.inputext_container, { margin: _margin }]}> 
                <MaterialCommunityIcons 
                    name= {type}
                    style={styles.left_icon} 
                    size={24}
                /> 
                <TextInput 
                    secureTextEntry={!showPassword} 
                    value={password} 
                    onChangeText={set_password} 
                    style={styles.input} 
                    placeholder= {_placeholder}
                    placeholderTextColor="#aaa"
                    cursorColor="#fff"
                /> 
                <MaterialCommunityIcons 
                    name={showPassword ? 'eye-off' : 'eye'} 
                    style={styles.right_icon} 
                    size={24}
                    onPress={toggleShowPassword} 
                /> 
            </View>
        </>
    )
}

const styles = StyleSheet.create({
    inputext_container: { 
        flexDirection: 'row', 
        alignItems: 'center', 
        justifyContent: 'center', 
        width: 300,
        backgroundColor: '#f3f3f3', 
        borderRadius: 20, 
        paddingHorizontal: 14, 
        padding: 5,
        backgroundColor: "#444444",
    }, 
    input: { 
        flex: 1, 
        color: '#fff', 
        paddingVertical: 10, 
        paddingRight: 10, 
        fontSize: 18, 
    }, 
    left_icon: { 
        marginRight: 10, 
        color: '#fff'
    },
    right_icon: { 
        marginLeft: 10, 
        color: '#fff'
    },
})