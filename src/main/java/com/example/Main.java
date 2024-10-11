package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client si è collegato");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inDalServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner in = new Scanner(System.in);

        do {
            //input della stringa
            System.out.println("scrivi la stringa da passare (scrivi '!' per terminare le operazioni): ");
            String stringaDaInviare = in.nextLine();

            if (stringaDaInviare.equals("!")) {
                out.writeBytes(stringaDaInviare + "\n");
                break;
            }

            // Invia la stringa al server
            out.writeBytes(stringaDaInviare + "\n");

            // risposta dal server
            String stringaRicevuta = inDalServer.readLine();
            System.out.println("Risposta dal server: " + stringaRicevuta);
        } while (true);

        s.close();
        in.close();
        System.out.println("FINE CONNESSIONE");
    }
}
