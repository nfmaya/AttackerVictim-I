import ApiUsuarios from '../model/ApiUsuarios';
import apiUsuarios from '../model/ApiUsuarios';

const LoginViewModel = {

    insertarLDAP: async (User) => {

        const postData = {
            "_Username": User.username,
            "_Nombre": User.name,
            "_password": User.password,
        };

        // Llamada al Model para hacer el POST
        const responseData = await apiUsuarios.postInsertarLDAP(postData);
        return responseData;
    },

    insertarUsuarios: async (User, IsVictim=true) => {

        const postData = {
            "_Username": User.username,
            "_Nombre": User.name,
            "usuarioTypeDto": {
                "id": IsVictim ? 1 : 2
            },
            "imei": User.imei,
            "estatus": true,
            "docIdentidad": User.ci,
            "id": IsVictim ? 1 : 2
        };

        // Llamada al Model para hacer el POST
        const responseData = await apiUsuarios.postInsertarUsuario(postData);
        return responseData;
    },
  
    getUsersConection: async (ID) => {

        const status = await ApiUsuarios.getUsersConection(ID);
        return status;
    },
};

export default LoginViewModel;