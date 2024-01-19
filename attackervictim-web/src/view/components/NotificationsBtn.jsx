import React from 'react'
import { useNavigate } from 'react-router-dom';
import { IoWarning } from "react-icons/io5";
import './NotificationBtn.css';

function NotificationBtn({ rute='' }) {

    let navigate = useNavigate();

    const handleClick = (event) => {

        event.currentTarget.blur();

        if (rute) {
            navigate(rute);
        }
    };

    return (
        <button className='Notificationbuttom' onClick={handleClick}>  
            <IoWarning/>
        </button>
    )

}

export default NotificationBtn