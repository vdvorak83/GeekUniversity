package com.geekbrains.NetProgramming.Server;

import com.geekbrains.NetProgramming.MessageHandler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {
    private int PORT = 8189;


    public static void main(String[] args) {
        ServerLauncher serverLauncher = new ServerLauncher();

        new Thread(() -> new MessageHandler(serverLauncher.startServer())).start();
    }

    private Socket startServer() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running");

            Socket socket = server.accept();
            System.out.println("Client connected " + socket.getLocalAddress());
            return socket;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
