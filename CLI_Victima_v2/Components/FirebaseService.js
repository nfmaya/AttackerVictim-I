import messaging from '@react-native-firebase/messaging';

class FirebaseService {
  token = ''; // Variable para almacenar el token

  async requestUserPermission() {
    const authStatus = await messaging().requestPermission();
    const enabled =
      authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
      authStatus === messaging.AuthorizationStatus.PROVISIONAL;

    if (enabled) {
      console.log('Authorization status:', authStatus);
    }
  }

  async getToken() {
    this.token = await messaging().getToken(); // Almacenamos el token
    console.log("Token =", this.token);
    return this.token;
  }

  async sendNotification() {
    const message = {
      to: this.token, // Usamos el token almacenado
      notification: {
        title: 'Login',
        body: 'User has logged in',
      },
    };
  
    await fetch('https://fcm.googleapis.com/fcm/send', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: 'AAAACi9DFPg:APA91bFoz_h5vJts87e4bNE9jq3ep-JKa4TT5G_GSk4VH9q3zVHJCXCZlr6oxVEruTmHGBJm9tTwkN-oKNIaFwmJJ7ZwmdcQ-i0tMRy7E-isy7GuJ1-_mFY45nz2sZVEMlWNb3IUQlMn', // Reemplaza esto con tu clave de servidor
      },
      body: JSON.stringify(message),
    })
    .then(response => response.json()) // Convierte la respuesta en JSON
    .then(data => {
      console.log('Response:', data); // Imprime la respuesta en la consola
    })
    .catch(error => {
      console.error('Error:', error); // Imprime cualquier error en la consola
    });
  }
  
  
}

export default new FirebaseService();