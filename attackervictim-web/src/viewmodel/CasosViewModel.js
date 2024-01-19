import ApiCasos from '../model/ApiCasos';

const CasosViewModel = {
    getCasosCount: async () => {
        // Aquí podrías añadir cualquier lógica adicional si es necesario
        const count = await ApiCasos.getCasosCount();
        return count;
    },

    getCasoNombres: async (ID) => {
        try {
            const response = await ApiCasos.getCaso(ID);
            if (response && response.response) {
                const victimName = response.response._victima._Nombre;
                const aggressorName = response.response._agresor._Nombre;
                return {
                    victimName,
                    aggressorName
                };
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener los nombres con ID ${ID}`, error);
            throw error;
        }
    },

    getCasoConexiones: async (ID) => {
        try {
            const response = await ApiCasos.getCaso(ID);
            if (response && response.response) {
                const victimConection = response.response._victima.estatus;
                const aggressorConection = response.response._agresor.estatus;
                return {
                    victimConection,
                    aggressorConection
                };
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener las conexiones con ID ${ID}`, error);
            throw error;
        }
    },

    getCasoDistance: async (ID) => {
        try {
            const response = await ApiCasos.getCasoDistance(ID);
            if (response && response.hasOwnProperty('response')) {
                return response.response;
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener la distancia con ID ${ID}`, error);
            throw error;
        }
    },

    getCasoDistanceByVictim: async (VICTIMA) => {
        try {
            const response = await ApiCasos.getCasoDistance(VICTIMA);
            if (response && response.hasOwnProperty('response')) {
                return response.response;
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener la distancia con VICTIMA ${VICTIMA}`, error);
            throw error;
        }
    },

    getCasoVictima: async (ID) => {
        try {
            const response = await ApiCasos.getCaso(ID);
            if (response && response.response) {
                return response.response._victima.id;
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener la victima con ID ${ID}`, error);
            throw error;
        }
    },

    getCasoAgresor: async (ID) => {
        try {
            const response = await ApiCasos.getCaso(ID);
            if (response && response.response) {
                return response.response._agresor.id;
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener el agresor con ID ${ID}`, error);
            throw error;
        }
    },

    postNewCaso: async (Victima, Agresor) => {
    
        const postData = {
            "_distanciaMinima": 100.0,
            "_victima": {
                "_Username": Victima.username,
                "_Nombre": Victima.name,
                "docIdentidad": Victima.ci,
                "estatus": true,
                "imei": Victima.imei,
                "usuarioTypeDto": {
                    "name": "Victima",
                    "id": 1
                }
            },
            "_agresor": {
                "_Username": Agresor.username,
                "_Nombre": Agresor.name,
                "docIdentidad": Agresor.ci,
                "estatus": true,
                "imei": Agresor.imei,
                "usuarioTypeDto": {
                    "name": "Agresor",
                    "id": 2
                }
            }
        };
    
        // Llamada al Model para hacer el POST
        const responseStatus = await ApiCasos.postNewCaso(postData);
        return responseStatus;
    },

};

export default CasosViewModel;