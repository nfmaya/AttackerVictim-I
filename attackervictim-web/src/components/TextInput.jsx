import React from 'react';
import './TextInput.css';
import { CiCircleQuestion } from "react-icons/ci";

function TextInput({placeholder = 'Escribe algo...', text='',set_text, Icon=CiCircleQuestion, my_type="text", width='400px'}) {

  const handleChange = (event) => {
    set_text(event.target.value);
  };

  return (
    <div className="input-container" style={{width: width}}>
        <Icon className='icono'/>
        <input
          type={my_type}
          value={text}
          onChange={handleChange}
          className="text-input"
          placeholder={placeholder}
        />
    </div>
  );
}

export default TextInput;