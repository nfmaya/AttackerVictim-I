import React from 'react'
import Login from './screens/Login';
import ForgetPassword from './screens/ForgetPassword';
import SendPassword from './screens/SendPassword'
import Home from './screens/Home'
import NewCase from './screens/NewCase'
import Notifications from './screens/Notifications'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Banner from './components/Banner'

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
