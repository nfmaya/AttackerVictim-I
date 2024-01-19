import ApiLogin from '../model/ApiLogin';

class HomeViewModel {

  constructor() {
    this.apiLogin = new ApiLogin();
  }
  
  async getUserName(username) {
    try {
     userDetails = await this.apiLogin.getUsuario(username);
      console.log(userDetails);
      return userDetails._Nombre;
    } catch (error) {
      console.error(error);
      return null;
    }
  }
}

export default HomeViewModel;