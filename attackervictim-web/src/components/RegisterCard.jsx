import React from 'react'
import './RegisterCard.css'
import TextInput from './TextInput'
import PasswordInput from './PasswordInput'
import { CiUser, CiMail, CiLink } from "react-icons/ci";

function RegisterCard({ BGcolor='#2255A9', 
                        border='1px solid #fff',
                        TitleName='Victim', 
                        Name='', 
                        setName, 
                        LastName='', 
                        setLastName, 
                        Email='', 
                        setEmail, 
                        password='', 
                        setpassword, 
                        confirmpassword='', 
                        setconfirmpassword,
                        IMEI='', 
                        setIMEI}) {

  return (
    <div className='container-register'  style={{ backgroundColor: BGcolor, border: border }}>
        <h3 className='title-registercard'> {TitleName} </h3>
        <TextInput width={'300px'} placeholder={'Name...'} Icon={CiUser} text={Name} set_text={setName}></TextInput>
        <TextInput width={'300px'} placeholder={'Last Name...'} Icon={CiUser} text={LastName} set_text={setLastName}></TextInput>
        <TextInput width={'300px'} placeholder={'Email...'} Icon={CiMail} text={Email} set_text={setEmail}/>
        <PasswordInput width={'300px'} textspace='78%' text={password} set_text={setpassword}/>
        <PasswordInput width={'300px'} textspace='78%' placeholder={'Confirm Password...'} text={confirmpassword} set_text={setconfirmpassword}/>
        <TextInput width={'300px'} placeholder={'IMEI...'} Icon={CiLink} text={IMEI} set_text={setIMEI}/>
    </div>
  )
}

export default RegisterCard