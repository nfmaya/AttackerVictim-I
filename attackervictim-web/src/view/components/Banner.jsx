import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import './Banner.css';

function Banner() {

  let navigate = useNavigate();
  let location = useLocation();

  const handleLogout = () => {
    
    localStorage.removeItem('isAuthenticated') //cierra sesion

    navigate('/'); // Redirigir al usuario a la página de inicio de sesión
  };

  // Verifica si la ruta actual comienza con /Home
  const shouldShowLogout = location.pathname.startsWith('/Home');

  return (
    <div className="banner">
      <div className="banner-content">

        <h1 className='banner-title'>Attacker Victim</h1>
        
        {shouldShowLogout && (
            <span className="logout-text" onClick={handleLogout}>Cerrar sesión</span>
        )}

      </div>
    </div>
  );
}

export default Banner;