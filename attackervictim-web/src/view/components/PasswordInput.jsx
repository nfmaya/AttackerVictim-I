import React, {useState} from 'react'
import './TextInput.css';
import './PasswordInput.css'
import { CiRead, CiUnread, CiLock } from "react-icons/ci";

function PasswordInput({text='',set_text, placeholder='Password...', width='400px', textspace='83%' }) {
 
  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (event) => {
    set_text(event.target.value);
  };

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className="input-container" style={{width: width}}>
        <CiLock className='icono'/>
        <input
          type= {showPassword ? "text" : "password"}
          value={text}
          onChange={handleChange}
          className="password-input"
          style={{width: textspace}}
          placeholder= {placeholder}
        />
        <button onClick={togglePasswordVisibility} className='icon_button' type="button">
            {showPassword ? <CiUnread className='left_icono'/> : <CiRead className='left_icono'/>}
        </button>
    </div>
  );
}

export default PasswordInput;