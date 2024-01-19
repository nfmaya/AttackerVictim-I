import React, {useState} from 'react'
import './ForgetPassword.css'
import TextInput from '../components/TextInput';
import { CiMail } from "react-icons/ci";
import CustomButton from '../components/CustomButton'

function ForgetPassword() {

    const [email, set_email] = useState("");

  return (
    <div className='container'>
        <p className='title'> Verify your personal information </p>
        <div className='inputs_container'>
          <p className='description'> Enter your email to continue </p>
          <TextInput placeholder={'Email...'} text= {email}  set_text= {set_email} Icon={CiMail} my_type='email'></TextInput>  
          <CustomButton text={'Continue'} rute='/forget-password/SendPassword'/>
        </div>
    </div>
  )
}

export default ForgetPassword