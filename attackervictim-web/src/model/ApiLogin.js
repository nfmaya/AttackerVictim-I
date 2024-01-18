const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiLogin = {
  postLogin: async (data) => {
    try {
      const response = await fetch(`${BASE_URL}/usuarios/validar`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data), // Convertimos los datos de JavaScript a un string JSON
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const responseData = await response.json();
      return responseData;

    } catch (error) {
      console.error("Error al hacer POST en /usuarios/validar", error);
      throw error;
    }
  },

};

export default ApiLogin;