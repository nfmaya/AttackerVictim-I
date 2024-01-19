import ApiNotificacion from '../model/ApiNotificacion';

class NotificacionViewModel {
  constructor() {
    this.apiNotificacion = new ApiNotificacion();
  }

  async handleGetRecentAlertas() {
    try {
      const response = await this.apiNotificacion.getRecentAlertas();
      return response.response;
    } catch (error) {
      console.error(error);
      return { success: false, message: "Ocurrió un error al obtener las alertas recientes" };
    }
  }
}

export default NotificacionViewModel;
