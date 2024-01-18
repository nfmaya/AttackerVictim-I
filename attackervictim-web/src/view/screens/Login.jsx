import React, { useState, useEffect } from 'react'
import './Login.css'
import Image from '../../assets/logo_web.jpg'
import TextInput from '../components/TextInput';
import PasswordInput from '../components/PasswordInput';
import { CiMail } from "react-icons/ci";
import CustomButton from '../components/CustomButton'
import loginViewModel from '../../viewmodel/loginViewModel';
import UsuariosViewModel from '../../viewmodel/UsuariosViewModel'

function Login() {

    const [username, set_username] = useState("");
    const [password, set_password] = useState("");

/*==================== Local Storage Stest ====================*/
/*     const [items, setItems] = useState("");

    useEffect(() => {
        const storedItems = JSON.parse(localStorage.getItem('items'));
        if (storedItems) {
            setItems(storedItems);
        }
    }, []);

    useEffect(() => {
      localStorage.setItem('items', JSON.stringify(items));
    }, [items]); */
/*================== Fin Local Storage Stest ==================*/

/*================== Start Endpoint ==================*/
   const handleLogin = async () => {
      //verifica si es administrador, debe volver username null ya que lo chequea en la tabla de usuarios
      try {
        const isuser = await UsuariosViewModel.validateUserName(username);
        console.log(isuser)
        if (isuser != null) {
          // La validación es falsa, muestra una alerta al usuario
          alert("Agresores y Victimas no pueden logearse en la pagina web.");
          return false;
        }
      } catch (error) {
        console.error("Error validando administrador", error);
      }

      try {
        const loginData = await loginViewModel.loginUser(username, password);
        
        if (loginData.description.includes("Validacion: true")) {

          // La validación es verdadera, guardamos el estado de autenticación
          localStorage.setItem('isAuthenticated', 'true');

          // La validación es verdadera, puedes continuar
          console.log("Usuario validado correctamente.");
          return true;
        } else {
          // La validación es falsa, muestra una alerta al usuario
          alert("El usuario proporcionado no existe.");
          return false;
        }

      } catch (error) {
        console.error("Error en el login", error);
      }
    }; 
/*==================== Fin Endpoint ====================*/

  return (
    <div className='container-main'>
        <div className='inputs-container-main'>
          <img src={Image} className='image'/>
          <TextInput placeholder={'UserName...'} text= {username}  set_text= {set_username} Icon={CiMail}></TextInput>
          <PasswordInput text= {password}  set_text= {set_password}></PasswordInput>
          <CustomButton text={'Long In'} rute={"/Home"}   executethis={handleLogin} />
          <CustomButton text={'Forgot Password'} isprimarybutton={false} rute={'/forget-password'} />
        </div>
    </div>
  )

}

export default Login