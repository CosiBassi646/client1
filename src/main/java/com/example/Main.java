package com.example;

import java.io.BufferedReader;
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
        do{
        System.out.println("scrivi la stringa da passare(scrivi '!' per terminare le operazioni): ");
        Scanner in = new Scanner( System.in );
        String stringaRicevuta = in.nextLine();
        if (stringaRicevuta.equals("!")) {
            break;
        }
        System.out.println("la stringa che hai passato è: " + stringaRicevuta);
        }while(true);
        
        
        
    }
}