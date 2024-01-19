import apiLogin from '../model/ApiLogin';

const LoginViewModel = {
  loginUser: async (email, password) => {
    
    const name = ""; //para cumplir con las reglas del post

    const postData = {
      "_Username": email,
      "_Nombre": name,
      "_password": password,
    };

    // Llamada al Model para hacer el POST
    const responseData = await apiLogin.postLogin(postData);
    return responseData;

  },
  
};

export default LoginViewModel;