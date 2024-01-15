import axios from 'axios';

const BASE_URL="https://8hnz2brw-8080.use2.devtunnels.ms/cmcapp-backend-1.0/api/v1/usuarios";

class ApiLogin {
  async validarUsuario(username, password) {
    try {
      const nombre = "";
      const userDto = { _Username: username, _Nombre: nombre, _password: password };
      const response = await axios.post(`${BASE_URL}/validar`, userDto);
      return response.data;
    } catch (error) {
      console.error("Error al hacer POST en LDAP",error);
      throw error;
    }
  }

  async getUsuario(username) {
    try {
      const response = await axios.get(`${BASE_URL}/username/${username}`);
      return response.data.response;
    } catch (error) {
      console.error("Error al hacer GET usuario",error);
      throw error;
    }
  }

  async updateUsuario(userDto) {
    try {
      const response = await axios.put(`${BASE_URL}/update`, userDto);
      return response.data;
    } catch (error) {
      console.error("Error al hacer PUT en usuario",error);
      throw error;
    }
  }
}

export default ApiLogin;