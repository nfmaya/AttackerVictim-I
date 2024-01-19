import React, { useState, useEffect } from 'react'
import CustomButton from '../components/CustomButton'
import './Notifications.css'
import NotificationsViewModel from '../../viewmodel/NotificationsViewModel'
import { AiOutlineUndo } from "react-icons/ai";

function Notifications() {

  const [notifications, setNotifications] = useState([]);

  const obtenerNotificaciones = async () => {
    try {
      const response = await NotificationsViewModel.getNotifications();
      console.log(response);
      if(response) {
        const newNotifications = response.map(notif => ({
          victimID: notif.id_victim,
          victimName: notif.victim_name,
          alertType: notif.type_not,
          time: notif.hour
        }));
        setNotifications(newNotifications);
      }
    } catch (error) {
      console.error("Error al obtener las notificaciones", error);
    }
  };

  const handleRefreshClick = (event) => {
    event.currentTarget.blur();

    obtenerNotificaciones();
  };

  useEffect(() => {
    obtenerNotificaciones();
  }, []);

  return (
    <div className='container-notif'>
        <div className='header-notif'>
          <h2 className='title-notif'>Notifications</h2>
          <button onClick={handleRefreshClick} className='refresh-button'>
            <AiOutlineUndo size={24} />
          </button>
        </div>

        <div className='scroll-panel-notif'>
            {notifications.map((notif, index) => (
                <div key={index} className='notification-item'>
                        <div className='victim-time-container'>
                            <p className='victim-name'>Victima ID : {notif.victimID} </p>
                            <p className='victim-name'>{notif.victimName}</p>
                            <p className='time'>{notif.time} </p>
                        </div>
                        <p className='alert-name'>{notif.alertType} </p>
                </div>
            ))}
        </div>

        <div style={{display:'flex',  flexDirection:'row', width:'1200px', gap:'340px', justifyContent:'left', alignItems:'end'}}>
          <CustomButton text={'<- Back'} rute='/Home' isprimarybutton={false}/>
        </div>

    </div>
  )
}

export default Notifications