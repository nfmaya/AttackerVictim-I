import React from 'react'
import './StateCard.css'

function StateCard({isVictim=true, isConnected=false, Person=''}) {

  return (
    <div className='container-usercard'>
        <div className='description-usercard'>
            <h3 className='description-text-bold'> {isVictim ? 'Victim' : 'Aggressor'} </h3>
            <p className='description-text-regular'> {Person} </p>
        </div>

        {isConnected ? 
            <h3 className='connection-status' style={{color:'#24FF00'}}>Connected</h3>
                     :
            <h3 className='connection-status' style={{color:'#FF0000'}}>Disconnected</h3>
        }
    </div>
  )
}

export default StateCard