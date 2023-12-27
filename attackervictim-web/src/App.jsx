import React from 'react'
import Login from './screens/Login';
import ForgetPassword from './screens/ForgetPassword';
import SendPassword from './screens/SendPassword'
import NewCase from './screens/NewCase'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/forget-password" element={<ForgetPassword />} />
        <Route path="/forget-password/SendPassword" element={<SendPassword />} />

        <Route path="/NewCase" element={<NewCase />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
