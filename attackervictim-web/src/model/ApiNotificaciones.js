const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiNotificaciones = {

    getNotifications: async () => {
        try {
          const response = await fetch(`${BASE_URL}/alertas/findRecent`);
    
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
    
          const responseData = await response.json();
          return responseData;
    
        } catch (error) {
          console.error(`Error al hacer GET en /alertas/findRecent`, error);
          throw error;
        }
    },

};

export default ApiNotificaciones;