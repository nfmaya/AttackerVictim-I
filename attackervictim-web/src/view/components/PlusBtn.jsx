import React from 'react'
import { useNavigate } from 'react-router-dom';
import { FaPlus, FaMinus } from "react-icons/fa6";
import './PlusBtn.css';

function PlusBtn({executethis, rute='', isMinus=false}) {

    let navigate = useNavigate();

    const handleClick = (event) => {

        event.currentTarget.blur();
  
        if (typeof executethis === 'function') {
            executethis();
        }

        if (rute) {
            navigate(rute);
        }
    };
    
    return (
        <button className='plusbuttom' onClick={handleClick}>  
            { isMinus ? <FaMinus/> : <FaPlus /> }
        </button>
    )

}

export default PlusBtn