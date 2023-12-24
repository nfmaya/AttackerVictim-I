import React, { useState } from 'react'
import './App.css'
import Image from './assets/logo_web.jpg'
import TextInput from './components/TextInput';
import PasswordInput from './components/PasswordInput';
import { CiMail } from "react-icons/ci";
import CustomButton from './components/CustomButton'

function App() {
  const [email, set_email] = useState("");
  const [password, set_password] = useState("");

  return (
    <>
      <div className='container'>
        <form className='inputs_container'>
          <img src={Image} className='image'/>
          <TextInput placeholder={'Email...'} text= {email}  set_text= {set_email} Icon={CiMail} my_type='email'></TextInput>  
          <PasswordInput text= {password}  set_text= {set_password}></PasswordInput>
          <CustomButton text={'Long In'}/>
          <CustomButton text={'Forgot Password'} isprimarybutton={false} />
        </form>
      </div>
    </>
  )
}

export default App
