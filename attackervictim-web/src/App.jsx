import React from 'react'
import Login from './view/screens/Login';
import ForgetPassword from './view/screens/ForgetPassword';
import SendPassword from './view/screens/SendPassword'
import Home from './view/screens/Home'
import NewCase from './view/screens/NewCase'
import Notifications from './view/screens/Notifications'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Banner from './view/components/Banner'

function App() {
  
  return (
    <BrowserRouter>

        <Banner/>

      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/forget-password" element={<ForgetPassword />} />
        <Route path="/forget-password/SendPassword" element={<SendPassword />} />

        <Route path="/Home" element={<Home/>} />
        <Route path="/Home/Notifications" element={<Notifications />} />
        <Route path="/Home/NewCase" element={<NewCase />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
