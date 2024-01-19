import React, { useState } from 'react'
import './NewCase.css'
import RegisterCard from '../components/RegisterCard'
import CustomButton from '../components/CustomButton'
import cellphoneImage from '../../assets/cellphone.png';
import { useNavigate } from 'react-router-dom';
import CasosViewModel from '../../viewmodel/CasosViewModel'
import UsuariosViewModel from '../../viewmodel/UsuariosViewModel'


function NewCase() {

  const [VictimUserName, setVictimUserName] = useState("");
  const [VictimName, setVictimName] = useState("");
  const [VictimCi, setVictimCi] = useState("")
  const [VictimEmail, setVictimEmail] = useState("");
  const [VictimPassword, setVictimPassword] = useState("");
  const [VictimConfirmPassword, setVictimConfirmPassword] = useState("");
  const [VictimIMEI, setVictimIMEI] = useState("");

  const [AggressorUserName, setAggressorUserName] = useState("");
  const [AggressorName, setAggressorName] = useState("");
  const [AggressorCi, setAggressorCi] = useState("")
  const [AggressorEmail, setAggressorEmail] = useState("");
  const [AggressorPassword, setAggressorPassword] = useState("");
  const [AggressorConfirmPassword, setAggressorConfirmPassword] = useState("");
  const [AggressorIMEI, setAggressorIMEI] = useState("");

  let navigate = useNavigate();

  // Verifica que todos los campos hayan sido llenados
  const checkFieldsAndSend = () => {

    let emptyFields = [];

    if (!VictimName) emptyFields.push("Victim Name");
    if (!VictimUserName) emptyFields.push("Victim Last Name");
    if (!VictimCi) emptyFields.push("Victim Document");
    if (!VictimEmail) emptyFields.push("Victim Email");
    if (!VictimPassword) emptyFields.push("Victim Password");
    if (!VictimConfirmPassword) emptyFields.push("Victim Confirm Password");
    if (!VictimIMEI) emptyFields.push("Victim IMEI");
    if (!AggressorName) emptyFields.push("Aggressor Name");
    if (!AggressorUserName) emptyFields.push("Aggressor Last Name");
    if (!AggressorCi) emptyFields.push("Aggressor Document");
    if (!AggressorEmail) emptyFields.push("Aggressor Email");
    if (!AggressorPassword) emptyFields.push("Aggressor Password");
    if (!AggressorConfirmPassword) emptyFields.push("Aggressor Confirm Password");
    if (!AggressorIMEI) emptyFields.push("Aggressor IMEI");

    if (emptyFields.length > 0) {
      alert(`The following fields are empty: ${emptyFields.join(", ")}`);
      return false;
    } else if (VictimPassword !== VictimConfirmPassword) {
      alert("Victim's password and confirm password do not match.");
      return false;
    } else if (AggressorPassword !== AggressorConfirmPassword) {
      alert("Aggressor's password and confirm password do not match.");
      return false;
    } else {
      return true;
    }
    
  };

  /*================== Start Endpoints ==================*/

  const fetchAgregarCasoYUsuarios = async () => {
    try {

      const postVictima = {
        username : VictimUserName,
        name : VictimName,
        ci : VictimCi,
        email : VictimEmail,
        password : VictimPassword,
        imei : VictimIMEI
      }

      const postAgresor = {
        username : AggressorUserName,
        name : AggressorName,
        ci : AggressorCi,
        email : AggressorEmail,
        password : AggressorPassword,
        imei : AggressorIMEI
      }

      const statusCaso = await CasosViewModel.postNewCaso(postVictima, postAgresor);
      const statusVictimaLDAP = await UsuariosViewModel.insertarLDAP(postVictima);
      const statusAgresorLDAP = await UsuariosViewModel.insertarLDAP(postAgresor);
      
      if (statusCaso === 200 /* && statusVictima === 200 && statusAgresor === 200 */ && statusVictimaLDAP === 200 && statusAgresorLDAP === 200) {
        alert(`New case has been register`);
        navigate('/Home');
      } else {
        if (statusCaso !== 200) console.log('Error al agregar el caso');
        if (statusVictimaLDAP !== 200) console.log('Error al agregar la víctima a LDAP');
        if (statusAgresorLDAP !== 200) console.log('Error al agregar el agresor a LDAP');
      }

    } catch (error) {
      console.error("Error al agregar caso y LDAP de los usuarios", error);
    }
  }; 

  /*================== End Endpoints ==================*/

  /* Si ingreso bien todos los datos hacer el fetch */
  const handleButton = () => {
    const IsOkey = checkFieldsAndSend();

    if (IsOkey) {
      fetchAgregarCasoYUsuarios();
    }
  };

  return (
    <div className='rc-newcase'>
        <h2 className='title-newcase'>Register a new case</h2>
        <p className='description-newcase'>Please fill out the following information :</p>
        <div className='sub-container-registercase'>
          <RegisterCard Name={VictimName} 
                        setName={setVictimName}
                        UserName={VictimUserName}
                        setUserName={setVictimUserName}
                        Ci={VictimCi}
                        setCi={setVictimCi}
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
                        UserName={AggressorUserName}
                        setUserName={setAggressorUserName}
                        Ci={AggressorCi}
                        setCi={setAggressorCi}
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
          <CustomButton text={'Send'} executethis={handleButton}/>
        </div>

        {/* <img src={cellphoneImage} className='image-newcase'/> */}
    </div>
  )
}

export default NewCase