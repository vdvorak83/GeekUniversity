package com.geekbrains.NetProgramming.MessageHandler;

import java.io.*;
import java.net.Socket;

public class MessageHandler {
    private Thread consoleReader;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private Socket socket;

    public MessageHandler(Socket socket) {
        if (socket == null || socket.isClosed()) {
            throw new RuntimeException("Socked is closed, connection failed!");
        }
        this.socket = socket;

        try {
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.consoleReader = new Thread(() -> MessageHandler.this.readConsole());

        startSocketReader();

        //один из вариантов - чтение консоли в потоке демоне
        consoleReader.setDaemon(true);
        consoleReader.start();
    }

    private void startSocketReader() {
        new Thread(() -> {
            try {
                while (true) {
                    String str = inputStream.readUTF();
                    if (str.equals("/end")) {
                        //второй вариант, прерываем поток
                        //consoleReader.interrupt();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.out.println("Connection closed");
            } finally {
                closeResources();
            }
        }).start();
    }


    private void readConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите сообщение: ");
        String str;

        do {
            try {
                while (!br.ready()) {
                    Thread.sleep(200);
                }

                str = br.readLine();
                outputStream.writeUTF(str);

                if (str.equals("/end")) {
                    break;
                }

            } catch (InterruptedException e) {
                System.out.println("read from console cancelled");
                break;
            } catch (IOException e) {
                System.out.println("Connection closed");
                break;
            }

        } while (true);

        closeResources();

    }


    private void closeResources() {
        try {
            if (socket != null && !socket.isClosed()) {
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Resources closed with errors!");
        }
    }
}
