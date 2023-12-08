package com.salas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class Main {

    public final static FileInputStream credencialFirebase;


    static {
        try {
            credencialFirebase = new  FileInputStream("src/main/resources/credencial.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //FirebaseConsumer.consume(Sender.COLA,credencialFirebase);
    }
}
