import React, { useState } from 'react'
import './NewCase.css'
import RegisterCard from '../components/RegisterCard'
import CustomButton from '../components/CustomButton'
import cellphoneImage from '../assets/cellphone.png';
import { useNavigate } from 'react-router-dom';


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

  let navigate = useNavigate();

  const checkFieldsAndSend = () => {

    let emptyFields = [];
    if (!VictimName) emptyFields.push("Victim Name");
    if (!VictimLastName) emptyFields.push("Victim Last Name");
    if (!VictimEmail) emptyFields.push("Victim Email");
    if (!VictimPassword) emptyFields.push("Victim Password");
    if (!VictimConfirmPassword) emptyFields.push("Victim Confirm Password");
    if (!VictimIMEI) emptyFields.push("Victim IMEI");
    if (!AggressorName) emptyFields.push("Aggressor Name");
    if (!AggressorLastName) emptyFields.push("Aggressor Last Name");
    if (!AggressorEmail) emptyFields.push("Aggressor Email");
    if (!AggressorPassword) emptyFields.push("Aggressor Password");
    if (!AggressorConfirmPassword) emptyFields.push("Aggressor Confirm Password");
    if (!AggressorIMEI) emptyFields.push("Aggressor IMEI");

    if (emptyFields.length > 0) {
      alert(`The following fields are empty: ${emptyFields.join(", ")}`);
    } else {
      alert(`New case has been register`);
      navigate('/Home');
    }
  };

  return (
    <div className='container-registercase'>
        <h2 className='title-newcase'>Register a new case</h2>
        <p className='description-newcase'>Please fill out the following information :</p>
        <div className='sub-container-registercase'>
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
        </div>

        <div style={{display:'flex',  flexDirection:'row', width:'1200px', gap:'340px', justifyContent:'left', alignItems:'end'}}>
          <CustomButton text={'<- Back'} rute='/Home' isprimarybutton={false}/>
          <CustomButton text={'Send'} executethis={checkFieldsAndSend}/>
        </div>

        <img src={cellphoneImage} className='image-newcase'/>
    </div>
  )
}

export default NewCase