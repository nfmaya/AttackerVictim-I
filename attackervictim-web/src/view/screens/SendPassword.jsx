import React, {useState} from 'react'
import './SendPassword.css'
import './ForgetPassword'
import CustomButton from '../components/CustomButton'

function SendPassword() {

  const [selectedOption, setSelectedOption] = useState('');

  const handleRadioChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div className='container'>
        <h2 className='title-sendpassword'>Reset your password</h2>
        <div className='inputs_container' style={{marginTop: '60px'}}>

          <p className='description-top-passwordrecovery'>How would you like to recover your password? :</p>

          <div className='buttonradio-container'>
             <input
              type="radio"
              id="option1"
              value="option1"
              name="myRadioGroup"
              checked={selectedOption === 'option1'}
              onChange={handleRadioChange}
              className="custom-radio"
            />
            <label htmlFor="option1" className="radio-label"></label>
            <span className='description-bottom-passwordrecovery' style={{marginRight: '300px'}}>Email</span>
          </div>

          <div className='buttonradio-container'>
            <input
              type="radio"
              id="option2"
              value="option2"
              name="myRadioGroup"
              checked={selectedOption === 'option2'}
              onChange={handleRadioChange}
              className="custom-radio"
            />
            <label htmlFor="option2" className="radio-label"></label>
            <span className='description-bottom-passwordrecovery'>Text message (SMS)</span>
          </div>

          <CustomButton text={'Send'} rute='/'/>
        </div>
    </div>
  )
}

export default SendPassword