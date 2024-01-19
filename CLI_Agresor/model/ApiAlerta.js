import axios from 'axios';
import '../view/Components/global'
const BASE_URL=global.GLOBAL_URL+"/alertas";

class ApiLogin {
  async InsertAlerta(tipoalerta) {
    try {
      const AlertaDto = { _tipoAlerta: tipoalerta,_fechaHora: new Date().getTime(),usuario: { id: global.idusuario } };
      const response = await axios.post(`${BASE_URL}/insert`, AlertaDto);
      return { success: true };
    } catch (error) {
      console.error("Error al hacer POST",error);
      throw error;
    }
  }
}
export default ApiLogin;