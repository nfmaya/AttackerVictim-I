import axios from 'axios';
import '../view/Components/global'
const BASE_URL=global.GLOBAL_URL+"/posicion";

class ApiPosicion {
  async addPosicionAgresor(coordenadaX, coordenadaY, fechaHora, usuarioId) {
    try {
      const posicionDto = {
        coordenadaX: coordenadaX,
        coordenadaY: coordenadaY,
        fechaHora: fechaHora,
        usuario: {
            id: usuarioId
        }
      };
      const response = await axios.post(`${BASE_URL}/insertAgresor`, posicionDto);
      return response.data;
    } catch (error) {
      console.error("Error al hacer POST en insertAgresor",error);
      throw error;
    }
  }
}

export default ApiPosicion;
