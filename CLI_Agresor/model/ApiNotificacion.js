import axios from 'axios';
import '../view/Components/global'
const BASE_URL=global.GLOBAL_URL+"/alertas";

class ApiNotificacion {
  async getRecentAlertas() {
    try {
      const response = await axios.get(`${BASE_URL}/findRecent/${global.idusuario}`);
      return response.data;
    } catch (error) {
      console.error("Error al hacer GET en findRecent",error);
      throw error;
    }
  }
}

export default ApiNotificacion;
