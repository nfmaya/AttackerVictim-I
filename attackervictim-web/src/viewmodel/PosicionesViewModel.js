import ApiPosiciones from '../model/ApiPosiciones';

const PosicionesViewModel = {

    getPosicion: async (ID) => {
        try {
            const response = await ApiPosiciones.getPosicion(ID);
            if (response && response.response) {
                const lat = response.response.coordenadaY;
                const lng = response.response.coordenadaX;

                return {
                    lat,
                    lng
                };
            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener la posicion del usuario ${ID}`, error);
            throw error;
        }
    },

};

export default PosicionesViewModel;