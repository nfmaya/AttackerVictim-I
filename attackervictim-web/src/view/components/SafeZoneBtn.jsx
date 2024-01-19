import React from 'react'
import './SafeZoneBtn.css'

function SafeZoneBtn({text='SafeZone', executethis}) {

    const handleClick = (event) => {

      event.currentTarget.blur();

      if (typeof executethis === 'function') {
        executethis();
      }

    };
  
    return (
      <button className='btn-safezone'
              onClick={handleClick}
      > 
        {text} 
      </button>
    )
}

export default SafeZoneBtn