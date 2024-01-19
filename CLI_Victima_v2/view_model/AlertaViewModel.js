import ApiAlerta from '../model/ApiAlerta';
import '../view/Components/global'

class AlertaViewModel {
  constructor() {
    this.apiAlerta = new ApiAlerta();
  }

  async EnviarAlerta(mensaje) {
    try {
      await this.apiAlerta.InsertAlerta(mensaje); // Llama al método en la instancia
      return { success: true, message: "the agent has been informed of the case" };
    } catch (error) {
      console.error(error);
      return { success: false, message: "No se pudo enviar" };
    }
  }
}

export default AlertaViewModel;