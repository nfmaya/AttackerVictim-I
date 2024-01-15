import ApiLogin from '../model/ApiLogin';
import '../view/Components/global'
class LoginViewModel {
  constructor() {
    this.apiLogin = new ApiLogin();
  }

  async handleLogin(username, password, token, navigation) {
    try {
      const validationResponse = await this.apiLogin.validarUsuario(username, password);

      if (validationResponse && validationResponse.description === "Validacion: true") {
        const userDetails = await this.apiLogin.getUsuario(username);

        if (userDetails && userDetails.usuarioTypeDto.name === "Victima") {
          if (userDetails.imei === "" || userDetails.imei === token) {
            const updatedUserDetails = { ...userDetails, imei: token };
            await this.apiLogin.updateUsuario(updatedUserDetails);
            global.idusuario=userDetails.id;
            return { success: true };
          } else {
            return { success: false, message: "No se puede agregar porque ya inicio sesión en otro teléfono" };
          }
        } else {
          return { success: false, message: "No se puede iniciar sesion porque no esta registrado como agresor" };
        }
      } else {
        return { success: false, message: "No se puede iniciar sesion porque el usuario no esta registrado" };
      }
    } catch (error) {
      console.error(error);
      return { success: false, message: "Ocurrió un error al iniciar sesión" };
    }
  }
}

export default LoginViewModel;