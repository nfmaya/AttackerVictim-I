import React, { useState } from 'react';
import './ComboBox.css';

function ComboBox() {
  const [selectedValue, setSelectedValue] = useState(''); // Estado para mantener el valor seleccionado

  const handleChange = (event) => {
    setSelectedValue(event.target.value); // Actualiza el estado con el nuevo valor
  };

  return (
    <select value={selectedValue} onChange={handleChange} className='select-container'>
      <option value="">Select Case</option>
      <option value="opcion1">A</option>
      <option value="opcion2">B</option>
      <option value="opcion3">C</option>
    </select>
  );
}

export default ComboBox;