import axios from 'axios';

const BASE_URL=global.GLOBAL_URL+"/posicion";

class ApiPosicion {
  
  async addPosicionVictima(coordenadaX, coordenadaY, fechaHora, usuarioId) {
    try {
      const posicionDto = {
        coordenadaX: coordenadaX,
        coordenadaY: coordenadaY,
        fechaHora: fechaHora,
        usuario: {
            id: usuarioId
        }
      };
      const response = await axios.post(`${BASE_URL}/insertVictima`, posicionDto);
      return response.data;
    } catch (error) {
      console.error("Error al hacer POST en insertVictima",error);
      throw error;
    }
  }
}

export default ApiPosicion;
