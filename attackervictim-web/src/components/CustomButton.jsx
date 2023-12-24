import React from 'react'
import './CustomButton.css'

function CustomButton({text='Button', isprimarybutton=true}) {
  return (
    <button className={isprimarybutton ? 'priamry-button' : 'secondary-button'} type={isprimarybutton ? "submit" : "button"}> 
        {text} 
    </button>
  )
}

export default CustomButton