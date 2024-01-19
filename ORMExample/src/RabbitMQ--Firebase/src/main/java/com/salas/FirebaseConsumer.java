package com.salas;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class FirebaseConsumer {
    public static Firestore db;
    public static void consume(String COLA,FileInputStream credencialFirebase) throws IOException, TimeoutException {
        //me conecto al firebase
        db =FirebaseConsumer.conectarFirebase(credencialFirebase);
        //me conecto al rabbitMQ
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(COLA, true, false, false, null);
        //Nota si hay algun mensaje que enviar
        System.out.println("Conectado al RabbitMQ");
        channel.basicConsume(COLA, true, (consumerTag, message) -> {
            //Recibo el JSON
            String json = new String(message.getBody(), "UTF-8");
            System.out.println(json);

            // Convierto el JSON a un objeto para corroborar que todos los datos esta bien
            Objeto product = null;
            try {
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(json).getAsJsonObject();

                product = new Objeto();
                product.setObjetoId(jsonObject.get("objetoid").getAsInt());
                product.setNombre(jsonObject.get("nombre").getAsString());
                product.setApellido(jsonObject.get("apellido").getAsString());
                product.setMensaje(jsonObject.get("mensaje").getAsString());
                product.setTiempo(jsonObject.get("tiempo").getAsString());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al deserializar el mensaje JSON: " + e.getMessage());
            }

            // Envía el mensaje a Firebase utilizando la libreria GSON
            //transformo el json en un hashmap gracias a la libreria GSON
            //y lo envío exactamente a la colección mensaje y se agrega el mensaje teniendo de clave con el mismo id
            Gson gson = new Gson();
            Map<String, Object> productMap = gson.fromJson(json, Map.class);
            try {
                DocumentReference docRef =db.collection("Mensaje").document(String.valueOf(product.getObjetotId()));
                ApiFuture<WriteResult> result =docRef.set(productMap);
                System.out.println("Se envió al Firebase");
            }catch (Exception e){
                System.out.println("Error: "+e);
            }
        }, consumerTag -> {
        });

    }
    public static Firestore conectarFirebase(FileInputStream credencial){
        try {
            FileInputStream sa=credencial;
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(sa)).build();
            FirebaseApp.initializeApp(options);
            db= FirestoreClient.getFirestore();
            System.out.println("Conectado al Firebase");
            return db;
            //Se conectó
        } catch (IOException e) {
            //no se conecto
            System.err.println("Error "+e.getMessage());
        }
        return null;
    }
    public static void main(String[] args) throws IOException, TimeoutException {
        FirebaseConsumer.consume( Sender.COLA, new  FileInputStream("C:\\Users\\aleja\\ORMExample\\ORMExample\\src\\RabbitMQ--Firebase\\src\\main\\resources\\credencial.json"));
    }
}
