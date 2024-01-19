import messaging from '@react-native-firebase/messaging';
import PushNotification from "react-native-push-notification";

class FirebaseService {
  token = ''; // Variable para almacenar el token

  FirebaseService(){}
  
  async requestUserPermission() {
    const authStatus = await messaging().requestPermission();
    const enabled =
      authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
      authStatus === messaging.AuthorizationStatus.PROVISIONAL;
  }

  async getToken() {
    this.token = await messaging().getToken(); // Almacenamos el token
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
        Authorization: 'AAAACi9DFPg:APA91bEgig-o_t-K9_VHhrPXOQnpMHe_B485BDQ7dcpPEyCHGYgowx0ijRw82hvWWk7H-TTdt66AAO6WumweJT3CgS1MNQQ8ME7i9NMc2syHzNtCxScMubB5zSJZRrDxMfP93kL5pgi9', // Reemplaza esto con tu clave de servidor
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

  handleForegroundMessage = async () => {
    messaging().onMessage(async remoteMessage => {
      console.log('A new FCM message arrived!', JSON.stringify(remoteMessage));
      PushNotification.localNotification({
        channelId: 'channel-id',
        title: remoteMessage.notification.title,
        message: remoteMessage.notification.body,
      });
    });
  }

  handleBackgroundMessage = async () => {
    messaging().setBackgroundMessageHandler(async remoteMessage => {
      console.log('A new FCM message arrived in the background!', JSON.stringify(remoteMessage));
      this.alertaViewModel.EnviarAlerta(JSON.stringify(remoteMessage).body);
    });
  }
 async requestPermissionAndGetToken (){
    const authStatus = await messaging().requestPermission();
    const enabled =
      authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
      authStatus === messaging.AuthorizationStatus.PROVISIONAL;

    if (enabled) {
      console.log("Authorization status:", authStatus);
      const token = await messaging().getToken();
      this.token=token
      console.log("Token =", token);
      return token;
    }
  };
  
  async sendNotification(token) {
    const message = {
      to: token,
      notification: {
        title: "Login",
        body: "User has logged in",
      },
    };
    const response = await fetch("https://fcm.googleapis.com/fcm/send", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "key=AAAACi9DFPg:APA91bEgig-o_t-K9_VHhrPXOQnpMHe_B485BDQ7dcpPEyCHGYgowx0ijRw82hvWWk7H-TTdt66AAO6WumweJT3CgS1MNQQ8ME7i9NMc2syHzNtCxScMubB5zSJZRrDxMfP93kL5pgi9", // Reemplaza esto con tu clave de servidor
      },
      body: JSON.stringify(message),
    });
  
    const responseText = await response.text();
  
    try {
      const data = JSON.parse(responseText);
      console.log("Response:", data);
    } catch (error) {
      console.error("Failed to parse JSON response. Original response:\n", responseText);
    }
  }
  createNotificationChannel() {
    PushNotification.createChannel(
      {
        channelId: 'channel-id',
        channelName: 'My channel',
        channelDescription: 'A channel to categorise your notifications',
        playSound: true,
        soundName: 'default',
        importance: 4,
        vibrate: true,
      },
      created => console.log(`createChannel returned '${created}'`)
    );
  }
}

export default new FirebaseService();