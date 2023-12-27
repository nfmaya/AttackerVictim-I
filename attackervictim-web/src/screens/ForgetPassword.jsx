import React, {useState} from 'react'
import './ForgetPassword.css'
import TextInput from '../components/TextInput';
import { CiMail } from "react-icons/ci";
import CustomButton from '../components/CustomButton'

function ForgetPassword() {

    const [email, set_email] = useState("");

  return (
    <div className='container'>
        <text className='title'> Verify your personal information </text>
        <form className='inputs_container'>
          <text className='description'> Enter your email to continue </text>
          <TextInput placeholder={'Email...'} text= {email}  set_text= {set_email} Icon={CiMail} my_type='email'></TextInput>  
          <CustomButton text={'Continue'} rute='/forget-password/SendPassword'/>
        </form>
    </div>
  )
}

export default ForgetPassword