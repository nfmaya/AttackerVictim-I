import React, { useState, useEffect } from 'react'
import './Login.css'
import Image from '../assets/logo_web.jpg'
import TextInput from '../components/TextInput';
import PasswordInput from '../components/PasswordInput';
import { CiMail } from "react-icons/ci";
import CustomButton from '../components/CustomButton'

function Login() {

    const [email, set_email] = useState("");
    const [password, set_password] = useState("");

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


  return (
    <div className='container-main'>
        <div className='inputs-container-main'>
          <img src={Image} className='image'/>
          <TextInput placeholder={'Email...'} text= {email}  set_text= {set_email} Icon={CiMail} my_type='email'></TextInput>
          <PasswordInput text= {password}  set_text= {set_password}></PasswordInput>
          <CustomButton text={'Long In'} rute={'/Home'} /* executethis={() => console.log({items})} *//>
          <CustomButton text={'Forgot Password'} isprimarybutton={false} rute={'/forget-password'} /* executethis={() => setItems("carnal") } *//>
        </div>
    </div>
  )
}

export default Login