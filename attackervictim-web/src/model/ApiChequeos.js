const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiChequeos = {

    getChequeos: async () => {
        try {
          const response = await fetch(`${BASE_URL}/posicion/checkAll`);
    
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
    
          const responseStatus = await response.status;
          return responseStatus;
    
        } catch (error) {
          console.error(`Error al hacer GET en /posicion/checkAll`, error);
          throw error;
        }
    },

};

export default ApiChequeos;