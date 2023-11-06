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

    public static void send(int id, String nombre, String apellido, String mensaje,String COLA,String RABBITMQ_API_URL) throws IOException {
        // Obtener los valores de los atributos del objeto usando los métodos getter
        Objeto objeto = new Objeto();
        objeto.setObjetoId(id);
        objeto.setNombre(nombre);
        objeto.setApellido(apellido);
        objeto.setMensaje(mensaje);

        // Crear el JSON para la petición
        String json = "{ \"properties\": {}," +
                " \"routing_key\":" + " \"" + "" + COLA + "\"," +
                " \"payload\": \"{\\\"objetoid\\\":" + id +
                ", \\\"nombre\\\":\\\"" + nombre + "\\\", " +
                "\\\"apellido\\\":\\\"" + apellido +
                "\\\", \\\"mensaje\\\":\\\"" + mensaje +
                "\\\", \\\"tiempo\\\":" + "\\\"" + String.valueOf(LocalDateTime.now())+ "\\\"}\"," +
                " \"payload_encoding\": \"string\" }";
        System.out.println(json);

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
    }

    public static void main(String[] args) throws IOException {
        Sender.send(6, "Alejandra", "Salas", "Ya funciona esto",Main.COLA,Main.RABBITMQ_API_URL);
    }
}