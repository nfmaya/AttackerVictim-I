package com.salas;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

import com.salas.Objeto.Objeto;
//Esta es la clase donde se envian mensajes
import okhttp3.*;

// Esta es la clase donde se envían mensajes
public class Sender {
    public  final static String COLA  = "Cola_AtackerVictim";
    public final static String RABBITMQ_API_URL = "http://localhost:15672/api/exchanges/%2F/amq.default/publish";
    public static void send(String json) throws IOException {
        // Crear la conexión
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()) {
            // Crear el canal
            Channel channel = connection.createChannel();
            // Crear la cola o usar una existente
            channel.queueDeclare(COLA, true, false, false, null);
            // Crear la petición HTTP POST
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

        Sender.send("{ \"properties\": {}," +
                " \"routing_key\": \"" + COLA + "\"," +
                " \"payload\": \"{\\\"objetoid\\\": \\\"Por fin mi loco\\\"}\"," +
                " \"payload_encoding\": \"string\" }");

    }
}
