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
        BufferedReader inDalServer = new BufferedReader(new InputStreamReader(s.getInputStream()));//risposta del server
        Scanner in = new Scanner(System.in);
        Scanner inScelta = new Scanner(System.in);

        System.out.println("--------menù--------");
        System.out.println("premi 1 per vedere la stringa in maiuscolo \n");
        System.out.println("premi 2 per Trasformare stringa in minuscolo \n");
        System.out.println("premi 3 per  Ribaltare i caratteri della string \n");
        System.out.println("premi 4 per Contare il numero di caratteri \n");
        System.out.println("premi 0 per disconettere il client dal server \n");
        //invio la stringa
        System.out.println("scrivi la stringa da passare: ");
        String stringaDaInviare = in.nextLine();
        out.writeBytes(stringaDaInviare + "\n");
       // invio la mia scelta al server
        System.out.println("compiere una scelta: ");
        String scelta = inScelta.nextLine();
        out.writeBytes(scelta + "\n");
        do {
            
            
            switch (scelta) {      
                case "1":
                // risposta dal server
                String stringaRicevuta = inDalServer.readLine();
                System.out.println("Risposta dal server: " + stringaRicevuta);
                System.out.println("compiere una scelta: ");
                scelta = inScelta.nextLine();
                break;

                case "2":
                String r2 = inDalServer.readLine();
                System.out.println("Risposta dal server: " + r2);
                System.out.println("compiere una scelta: ");
                scelta = inScelta.nextLine();
                break;

                case "3":
                String r3 = inDalServer.readLine();
                System.out.println("Risposta dal server: " + r3);
                System.out.println("compiere una scelta: ");
                scelta = inScelta.nextLine();

                case "4":
                String r4 = inDalServer.readLine();
                System.out.println("Risposta dal server: " + r4);
                System.out.println("compiere una scelta: ");
                scelta = inScelta.nextLine();

                case "0":
                s.close();
                in.close();
                inScelta.close();
                System.out.println("FINE CONNESSIONE");
                break;

                default:
                    System.out.println("scelta non valida");
                    System.out.println("compiere una scelta: ");
                    scelta = inScelta.nextLine();
                    break;
            }           
        } while (scelta.equals("0") == false);
        
        
    }
}
