import React, {useState} from 'react'
import './TextInput.css';
import './PasswordInput.css'
import { CiRead, CiUnread, CiLock } from "react-icons/ci";

function PasswordInput({text='',set_text }) {
 
  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (event) => {
    set_text(event.target.value);
  };

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className="input-container">
        <CiLock className='icono'/>
        <input
          type= {showPassword ? "text" : "password"}
          value={text}
          onChange={handleChange}
          className="password-input"
          placeholder='Password...'
        />
        <button onClick={togglePasswordVisibility} className='icon_button' type="button">
            {showPassword ? <CiUnread className='left_icono'/> : <CiRead className='left_icono'/>}
        </button>
    </div>
  );
}

export default PasswordInput;