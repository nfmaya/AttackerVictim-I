import React, { useState } from 'react'
import './NewCase.css'
import RegisterCard from '../components/RegisterCard'
import CustomButton from '../components/CustomButton'

function NewCase() {

  const [VictimName, setVictimName] = useState("");
  const [VictimLastName, setVictimLastName] = useState("");
  const [VictimEmail, setVictimEmail] = useState("");
  const [VictimPassword, setVictimPassword] = useState("");
  const [VictimConfirmPassword, setVictimConfirmPassword] = useState("");
  const [VictimIMEI, setVictimIMEI] = useState("");

  const [AggressorName, setAggressorName] = useState("");
  const [AggressorLastName, setAggressorLastName] = useState("");
  const [AggressorEmail, setAggressorEmail] = useState("");
  const [AggressorPassword, setAggressorPassword] = useState("");
  const [AggressorConfirmPassword, setAggressorConfirmPassword] = useState("");
  const [AggressorIMEI, setAggressorIMEI] = useState("");

  return (
    <div className='container-registercase'>
        <h2 className='title-newcase'>Register a new case</h2>
        <p className='description-newcase'>Please fill out the following information :</p>
        <form className='sub-container-registercase'>
          <RegisterCard Name={VictimName} 
                        setName={setVictimName}
                        LastName={VictimLastName}
                        setLastName={setVictimLastName}
                        Email={VictimEmail}
                        setEmail={setVictimEmail}
                        password={VictimPassword}
                        setpassword={setVictimPassword}
                        confirmpassword={VictimConfirmPassword}
                        setconfirmpassword={setVictimConfirmPassword}
                        IMEI={VictimIMEI}
                        setIMEI={setVictimIMEI}
          />
          <RegisterCard BGcolor={'#22A970'} 
                        TitleName='Aggressor' 
                        Name={AggressorName} 
                        setName={setAggressorName}
                        LastName={AggressorLastName}
                        setLastName={setAggressorLastName}
                        Email={AggressorEmail}
                        setEmail={setAggressorEmail}
                        password={AggressorPassword}
                        setpassword={setAggressorPassword}
                        confirmpassword={AggressorConfirmPassword}
                        setconfirmpassword={setAggressorConfirmPassword}
                        IMEI={AggressorIMEI}
                        setIMEI={setAggressorIMEI}
          />
        </form>
        <CustomButton text={'Send'}/>
    </div>
  )
}

export default NewCase