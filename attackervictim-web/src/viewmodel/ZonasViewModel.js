import apiZonas from '../model/ApiZonas';

const ZonasViewModel = {
    
    getZonas: async (VICTIMA) => {

        const extractSafeZones = (dataJson) => {
            // Paso 1: Agrupar las coordenadas por zona de seguridad
            const zonas = {};
            dataJson.response.forEach(item => {
                const idZona = item.zonaSeguridad.id;
                const nombreZona = item.zonaSeguridad.nombreZona;
        
                if (!zonas[idZona]) {
                    zonas[idZona] = {
                        id: idZona,
                        nombreZona: nombreZona,
                        coordenadas: []
                    };
                }
        
                item.coordenadas.forEach(coordenada => {
                    zonas[idZona].coordenadas.push({
                        lat: coordenada.coordenadaX,
                        lng: coordenada.coordenadaY,
                    });
                });
            });
        
            // Paso 2: Transformar el objeto en un array
            return Object.values(zonas);
        };


        const responseData = await apiZonas.getZonas(VICTIMA);
        return extractSafeZones(responseData);

    },

    postNewZona: async (placeName, geolocationPoints, VICT_ID) => {
    
        // Crea un nuevo arreglo cuya casillas cumplan con el formato del json
        const coordenadas = geolocationPoints.map(point => ({
            "coordenadaX": point.latitude,
            "coordenadaY": point.longitude,
            "zonaSeguridad": {
                "nombreZona": placeName
            }
        }));
    
        // Crea el objeto postData con la lista de coordenadas
        const postData = {
            "zonaSeguridad": {
                "nombreZona": placeName
            },
            "coordenadas": coordenadas
        };
    
        // Llamada al Model para hacer el POST
        const responseStatus = await apiZonas.postNewZona(VICT_ID, postData);
        return responseStatus;
    },

};

export default ZonasViewModel;