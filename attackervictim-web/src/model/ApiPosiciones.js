const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiPosiciones = {

    getPosicion: async (ID) => {
        try {
          const response = await fetch(`${BASE_URL}/posicion/usuario/${ID}`);
    
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
    
          const responseData = await response.json();
          return responseData;
    
        } catch (error) {
          console.error(`Error al hacer GET en /posicion/usuario/${ID}`, error);
          throw error;
        }
    },

};

export default ApiPosiciones;