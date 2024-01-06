import React from 'react'
import CustomButton from '../components/CustomButton'
import './Notifications.css'

function Notifications() {

    const notifications = [
        "Notificación 1",
        "Notificación 2",
        "Notificación 3",
        "Notificación 4",
        "Notificación 5",
        "Notificación 6",
        "Notificación 7",
        "Notificación 8",
        "Notificación 9",
        "Notificación 10",
        "Notificación 11",
        "Notificación 12",
        "Notificación 13",
        "Notificación 14",
        "Notificación 15",
        "Notificación 16",
        // ... más notificaciones
      ];

  return (
    <div className='container-notif'>
        <h2 className='title-notif'>Notifications</h2>

        <div className='scroll-panel-notif'>
            {notifications.map((notif, index) => (
            <div key={index} className='notification-item'>
                {notif}
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