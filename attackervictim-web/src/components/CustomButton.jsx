import React from 'react'
import './CustomButton.css'
import { useNavigate } from 'react-router-dom';

function CustomButton({text='Button', isprimarybutton=true, rute='/'}) {

  let navigate = useNavigate();

  const handleForgetPasswordClick = () => {
    navigate(rute);
  };

  return (
    <button className={isprimarybutton ? 'priamry-button' : 'secondary-button'} type={isprimarybutton ? "submit" : "button"}
            onClick={handleForgetPasswordClick}
    > 
      {text} 
    </button>
  )
}

export default CustomButton