const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiZonas = {
  getZonas: async (VICTIMA) => {
    try {
      const response = await fetch(`${BASE_URL}/zonasUsuario/findAllZonaSeguridadWithCoordenadas/${VICTIMA}`);

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const responseData = await response.json();
      return responseData;

    } catch (error) {
      console.error("Error al hacer GET en /zonasUsuario/findAllZonaSeguridadWithCoordenadas/1", error);
      throw error;
    }
  },

  postNewZona: async (ID, data) => {
    try {
      const response = await fetch(`${BASE_URL}/zonas/insertWithCoordenadas/${ID}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data), // Convertimos los datos de JavaScript a un string JSON
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      return response.status;

    } catch (error) {
      console.error(`Error al hacer POST en /zonas/insertWithCoordenadas/${ID}`, error);
      throw error;
    }
  },

};

export default ApiZonas;