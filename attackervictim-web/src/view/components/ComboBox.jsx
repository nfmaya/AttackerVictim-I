import React, { useState } from 'react';
import './ComboBox.css';

function ComboBox({ numOptions = 0, onValueChange }) {
  const [selectedValue, setSelectedValue] = useState(''); // Estado para mantener el valor seleccionado

  const handleChange = (event) => {
    setSelectedValue(event.target.value); // Actualiza el estado con el nuevo valor

    if (onValueChange) {
      const index = Number(event.target.value);
      onValueChange(index);
    }
  };

  // Genera un array de letras basado en el número recibido
  const options = Array.from({ length: numOptions }, (_, i) => String.fromCharCode(65 + i));

  return (
    <select value={selectedValue} onChange={handleChange} className='select-container'>
      {selectedValue === '' && <option value="" disabled>Select Case</option>}
      {options.map((option, index) => (
        <option key={index} value={ index + 1 }>{option}</option>
      ))}
    </select>
  );
}

export default ComboBox;