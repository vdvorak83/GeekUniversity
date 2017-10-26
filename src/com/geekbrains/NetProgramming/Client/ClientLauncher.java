package com.geekbrains.NetProgramming.Client;

import com.geekbrains.NetProgramming.MessageHandler.*;
import java.io.IOException;
import java.net.Socket;

public class ClientLauncher {

    final String IP = "localhost";
    final int PORT = 8189;

    public static void main(String[] args) {
        ClientLauncher clientLauncher = new ClientLauncher();

        new Thread(() -> new MessageHandler(clientLauncher.connectToServer())).start();
    }


    private Socket connectToServer() {
        try {
            Socket socket = new Socket(IP,PORT);
            System.out.println("Connected to server\n" + "ip adress: " + IP + ":" + PORT);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("Failed connection to server with ip adress: " + IP + ":" + PORT);
        }
    }
}
