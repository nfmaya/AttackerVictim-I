import React from 'react'
import './CustomButton.css'
import { useNavigate } from 'react-router-dom';

function CustomButton({text='Button', isprimarybutton=true, rute='', executethis}) {

  let navigate = useNavigate();

  const handleClick = async () => {

    if (typeof executethis === 'function') {
      const canNavigate = await executethis();
      if (canNavigate && rute) { 
        navigate(rute); // Navega solo si la validación es verdadera
      }
    }
    else if (rute) {
      navigate(rute);
    }
  };

  return (
    <button className={isprimarybutton ? 'priamry-button' : 'secondary-button'} /* type={isprimarybutton ? "submit" : "button"} */
            onClick={handleClick}
    > 
      {text} 
    </button>
  )
}

export default CustomButton