package com.salas;

import org.json.JSONObject;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {
    public final static String COLA = "Cola_AtackerVictim";
    public final static String RABBITMQ_API_URL = "http://localhost:15672/api/exchanges/%2F/amq.default/publish";

    public static void send(String mensaje) throws IOException {
        // Crear la conexión
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()) {
            // Crear el canal
            Channel channel = connection.createChannel();
            // Crear la cola o usar una existente
            channel.queueDeclare(COLA, true, false, false, null);
            // Crear la petición HTTP POST
            String json = "{ \"properties\": {}," +
                    " \"routing_key\": \"" + COLA + "\"," +
                    " \"payload\": " + JSONObject.quote(mensaje) + "," +
                    " \"payload_encoding\": \"string\" }";
            System.out.println(json);
            try {
                new JSONObject(json);
                System.out.println("El JSON está correctamente formateado");
            } catch (Exception e) {
                System.out.println("El JSON no está correctamente formateado");
                throw new IOException("JSON mal formateado", e);
            }
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
            Request request = new Request.Builder()
                    .url(RABBITMQ_API_URL)
                    .post(body)
                    .addHeader("Authorization", Credentials.basic("guest", "guest"))//Puedes cambiar el usuario que sea
                    .build();

            // Enviar la petición y obtener la respuesta
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                System.out.println("Mensaje ha sido enviado");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) throws IOException {

        Sender.send("{\\\"objetoid\\\": \\\"Todo salio bien ya\\\"}");

    }
}
