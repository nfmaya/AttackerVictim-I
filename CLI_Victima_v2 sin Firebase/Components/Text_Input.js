import React from 'react';
import { View, TextInput, StyleSheet } from 'react-native';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

export default function Text_Input ({ type="email", _placeholder="Email",text="", set_text, kb_type="default", _margin=10 }) {
    return(
        <>
            <View style={[styles.inputext_container, { margin: _margin }]}> 
                <MaterialCommunityIcons
                    name= {type}
                    size={24} 
                    style={styles.left_icon} 
                /> 
                <TextInput 
                    value={text} 
                    onChangeText={set_text} 
                    style={styles.input} 
                    placeholder= {_placeholder}
                    placeholderTextColor="#aaa"
                    cursorColor="#fff"
                    keyboardType= {kb_type}
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
})