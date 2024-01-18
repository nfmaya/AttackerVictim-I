const BASE_URL = 'https://attackervictim.ngrok.io/cmcapp-backend-1.0/api/v1';

const ApiCasos = {
    getCasosCount: async () => {
        try {
            const response = await fetch(`${BASE_URL}/distancias/count`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            return data; 
        } catch (error) {
            console.error("Error al hacer GET en /distancias/count", error);
            throw error;
        }
    },

    getCaso: async (ID) => {
        try {
            const response = await fetch(`${BASE_URL}/distancias/${ID}`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            return data; 
        } catch (error) {
            console.error(`Error al hacer GET en /distancias/${ID}`, error);
            throw error;
        }
    },

    getCasoDistance: async (ID) => {
        try {
            const response = await fetch(`${BASE_URL}/distancias/calculateDistance/${ID}`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            return data; 
        } catch (error) {
            console.error(`Error al hacer GET en /distancias/calculateDistance/${ID}`, error);
            throw error;
        }
    },

    getCasoDistanceByVictim: async (VICTIMA) => {
        try {
            const response = await fetch(`${BASE_URL}/distancias/usuario/${VICTIMA}`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            return data; 
        } catch (error) {
            console.error(`Error al hacer GET en /distancias/usuario/${VICTIMA}`, error);
            throw error;
        }
    },

    postNewCaso: async (data) => {
        try {
            const response = await fetch(`${BASE_URL}/distancias/insertComplete`, {
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
            console.error(`Error al hacer POST en /distancias/insertComplete`, error);
            throw error;
        }
    },



    
};

export default ApiCasos;



