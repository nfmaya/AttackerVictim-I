package com.salas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    public  final static String COLA  = "Cola_AtackerVictim";
    public final static String RABBITMQ_API_URL = "http://localhost:15672/api/exchanges/%2F/amq.default/publish";

    public final static FileInputStream credencialFirebase;

    static {
        try {
            credencialFirebase = new  FileInputStream("src/main/resources/credencial.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Sender.send(4, "Alejandro", "Salas", "Ya funciona esto",COLA,RABBITMQ_API_URL);
        FirebaseConsumer.consume(COLA,credencialFirebase);
    }
}
