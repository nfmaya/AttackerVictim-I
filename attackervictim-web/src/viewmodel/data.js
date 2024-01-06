import dataJson from '../model/data'

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

export const readSafeZones = extractSafeZones(dataJson);