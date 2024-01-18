import React from 'react'
import Login from './view/screens/Login';
import ForgetPassword from './view/screens/ForgetPassword';
import SendPassword from './view/screens/SendPassword'
import Home from './view/screens/Home'
import NewCase from './view/screens/NewCase'
import Notifications from './view/screens/Notifications'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Banner from './view/components/Banner'
import PrivateRoute from './authentication/PrivateRoute'

function App() {

  return (
    <BrowserRouter>

      <Banner/>

      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/forget-password" element={<ForgetPassword />} />
        <Route path="/forget-password/SendPassword" element={<SendPassword />} />

        {/* Rutas protegidas usando el componente PrivateRoute */}
        <Route 
          path="/Home" 
          element={
            <PrivateRoute>
              <Home/>
            </PrivateRoute>
          }
        />
        <Route 
          path="/Home/Notifications" 
          element={
            <PrivateRoute>
              <Notifications />
            </PrivateRoute>
          }
        />
        <Route 
          path="/Home/NewCase" 
          element={
            <PrivateRoute>
              <NewCase />
            </PrivateRoute>
          }
        />

      </Routes>
    </BrowserRouter>
  )
}

export default App
