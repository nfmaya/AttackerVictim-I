import React from 'react'
import './RegisterCard.css'
import TextInput from './TextInput'
import PasswordInput from './PasswordInput'
import { CiUser, CiMail, CiLink, CiCreditCard2 } from "react-icons/ci";

function RegisterCard({ BGcolor='#2255A9', 
                        border='1px solid #fff',
                        TitleName='Victim', 
                        Name='', 
                        setName, 
                        UserName='', 
                        setUserName, 
                        Ci='',
                        setCi='',
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
        <TextInput width={'300px'} placeholder={'Username...'} Icon={CiUser} text={UserName} set_text={setUserName}></TextInput>
        <TextInput width={'300px'} placeholder={'Name...'} Icon={CiUser} text={Name} set_text={setName}></TextInput>
        <TextInput width={'300px'} placeholder={'Identification Document...'} Icon={CiCreditCard2} text={Ci} set_text={setCi} my_type='number'></TextInput>
        <TextInput width={'300px'} placeholder={'Email...'} Icon={CiMail} text={Email} set_text={setEmail}/>
        <PasswordInput width={'300px'} textspace='78%' text={password} set_text={setpassword}/>
        <PasswordInput width={'300px'} textspace='78%' placeholder={'Confirm Password...'} text={confirmpassword} set_text={setconfirmpassword}/>
        <TextInput width={'300px'} placeholder={'IMEI...'} Icon={CiLink} text={IMEI} set_text={setIMEI}/>
    </div>
  )
}

export default RegisterCard