import TextInput from '../components/TextInput'
import { CiLocationOn } from "react-icons/ci";
import PlusBtn from './PlusBtn'

import React from 'react'

function GeolocationPoint({isFirstOne=false, isLastOne=false, latitude, longitude, onUpdate, onAdd, onDelete }) {
  return (
    <div style={{display:'flex', flexDirection:'row', height:'68px', padding:'0px', margin:'0px'}}>
        <TextInput 
            placeholder='Latitude...' 
            width='200px' 
            Icon={CiLocationOn}
            text={latitude}
            set_text={(val) => onUpdate(val, longitude)}
            my_type='number'
        />
        <TextInput 
            placeholder='Longitude...' 
            width='200px' 
            Icon={CiLocationOn}
            text={longitude}
            set_text={(val) => onUpdate(latitude, val)}
            my_type='number'
        />

        {isFirstOne && (
            <PlusBtn isMinus={true} executethis={onDelete}/>
        )}

        {isLastOne && (
            <PlusBtn executethis={onAdd}/>
        )}
    </div>
  )
}

export default GeolocationPoint