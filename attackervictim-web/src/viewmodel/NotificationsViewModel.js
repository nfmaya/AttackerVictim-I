import ApiNotificaciones from '../model/ApiNotificaciones';

const NotificationsViewModel = {

    getNotifications: async () => {
        try {
            const response = await ApiNotificaciones.getNotifications();
            if (response && Array.isArray(response.response)) {

                // Chequea que el array no este vacio
                if (response.response.length > 0) {
                    return response.response.map(notif => {
                        // Crear un objeto Date con el timestamp
                        const date = new Date(notif._fechaHora);
                        
                        // Restar 4 horas para la hora de Venezuela
                        date.setHours(date.getHours() - 4);

                        // Formatear la fecha a una cadena de tiempo "HH:MM:SS"
                        const timeString = date.toISOString().split('T')[1].slice(0, 8);
                        
                        return {
                            type_not: notif._tipoAlerta,
                            id_victim: notif.usuario.id,
                            victim_name: notif.usuario._Nombre,
                            hour: timeString,
                        };
                    });
                } else {
                    return [{ victimName: "???", victimID: 0, alertType: "Vuelva a cargar las notificaciones", time: "???" }];
                }

            } else {
                throw new Error('Response format is incorrect');
            }
        } catch (error) {
            console.error(`Error al obtener las notificaciones (ViewModel)`, error);
            throw error;
        }
    },

}


export default NotificationsViewModel;