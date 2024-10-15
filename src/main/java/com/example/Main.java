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
        System.out.println("Client partito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Il client si è collegato");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inDalServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner in = new Scanner(System.in);

        String scelta;

        do {
            // Mostra il menù
            System.out.println("--------MENÙ--------");
            System.out.println("Premi 1 per vedere la stringa in maiuscolo");
            System.out.println("Premi 2 per trasformare la stringa in minuscolo");
            System.out.println("Premi 3 per ribaltare i caratteri della stringa");
            System.out.println("Premi 4 per contare il numero di caratteri");
            System.out.println("Premi 0 per disconnettere il client dal server");

            // invia la scelta al server
            System.out.print("Compiere una scelta: ");
            scelta = in.nextLine();
            if(scelta.equals("0") == false && scelta.equals("1") == false && scelta.equals("2") == false && scelta.equals("3") == false && scelta.equals("4") == false ){
                System.out.println("inserisci una scelta valida!");   
            }else{
                out.writeBytes(scelta + "\n");  

                // Se la scelta non è "0", chiedi la stringa solo per le scelte rilevanti
                if (scelta.equals("0") == false) {
                    System.out.print("Inserisci la stringa: ");
                    String stringaDaInviare = in.nextLine();
                    out.writeBytes(stringaDaInviare + "\n");  // Invia la stringa al server
    
                    // Ricevi la risposta dal server
                    String risultatoOperazione = inDalServer.readLine();
                    System.out.println("Risposta dal server: " + risultatoOperazione);
                }
            }
    

        } while (!scelta.equals("0"));

        // Chiudi la connessione e gli stream
        System.out.println("FINE CONNESSIONE");
        s.close();
        in.close();
    }
}
