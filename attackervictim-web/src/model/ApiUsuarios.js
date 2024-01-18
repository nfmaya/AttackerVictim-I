const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiUsuarios = {
  postInsertarUsuario: async (data) => {
    try {
      const response = await fetch(`${BASE_URL}/usuarios/insert`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data), // Convertimos los datos de JavaScript a un string JSON
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const responseStatus = await response.json();
      return responseStatus;

    } catch (error) {
      console.error("Error al hacer POST en /usuarios/insert", error);
      throw error;
    }
  },

  postInsertarLDAP: async (data) => {
    try {
      const response = await fetch(`${BASE_URL}/usuarios/insertLDAP`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data), // Convertimos los datos de JavaScript a un string JSON
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const responseStatus = await response.status;
      return responseStatus;

    } catch (error) {
      console.error("Error al hacer POST en /usuarios/insertLDAP", error);
      throw error;
    }
  },

  getUsersConection: async (ID) => {
    try {
        const response = await fetch(`${BASE_URL}/posicion/estatus/${ID}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        return data; 
    } catch (error) {
        console.error(`Error al hacer GET en /posicion/estatus/${ID}`, error);
        throw error;
    }
},

};

export default ApiUsuarios;