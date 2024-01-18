import ApiPosicion from '../model/ApiPosicion';

class PosicionViewModel {
  constructor() {
    this.apiPosicion = new ApiPosicion();
  }

  async handleAddPosicionVictima(coordenadaX, coordenadaY, fechaHora, usuarioId, id) {
    try {
      const response = await this.apiPosicion.addPosicionVictima(coordenadaX, coordenadaY, fechaHora, usuarioId, id);
      return response;
    } catch (error) {
      console.error(error);
      return { success: false, message: "Ocurrió un error al agregar la posición de la víctima" };
    }
  }
}

export default PosicionViewModel;
