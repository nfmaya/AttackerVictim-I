package com.salas;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FirebaseSender{

    public void SenderVictim(String token) throws IOException, FirebaseMessagingException {
        // Ruta al archivo de configuración descargado desde Firebase Console
        //FileInputStream serviceAccount = new FileInputStream("ORMExample\\src\\RabbitMQ--Firebase\\src\\main\\java\\com\\salas\\attacker.json");

        InputStream serviceAccount = FirebaseSender.class.getResourceAsStream("/attacker.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Check if FirebaseApp is already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        // Construir el mensaje de la notificación
        Message message = Message.builder()
                //.setToken("f6pIHEg_QVCPankV0cBSJq:APA91bF8pdkwuXP89onw4tY0xcTc-GOxKY4XVH4yenJRTFTEBb-QMUOPt2Gq5rAZENwhNdc5mkdK0_3tlLwJJOCHlBLrhbyIMQkfnTZ3oO9Nh-eE4t9RVK5nlb6IsYqrsjncOzvlRUCQ")
                .setToken(token)
                .putData("key", "value") // Datos adicionales si los necesitas
                .setNotification(Notification.builder()
                        .setTitle("Título de la notificación Hola ALe")
                        .setBody("Cuerpo de la notificación que mas")
                        .build())
                .build();

        // Enviar la notificación
        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Mensaje enviado correctamente: " + response);
    }
}
