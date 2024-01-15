import axios from 'axios';

const BASE_URL="https://8hnz2brw-8080.use2.devtunnels.ms/cmcapp-backend-1.0/api/v1/posicion";

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
