package com.geekbrains.IO_lesson;

import java.io.*;

public class FileWorker {
    public FileWorker() {
        checkExampleFile();
    }

    private void checkExampleFile() {
        File file = new File("Resources/example.txt");
        if (!file.exists()){
            try {
                long t = System.currentTimeMillis();
                file.createNewFile();
                fillNewFile(file);
                System.out.println("File created for time(ms):" + (System.currentTimeMillis() - t));
            } catch (IOException e) {
                System.out.println("Error File creating");
                e.printStackTrace();
            }
        } else System.out.println("File already exist");
    }

    private void fillNewFile(File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        byte[] arr = new byte[20000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 'X';
            if (i%100 == 0) arr[i]='\n';
        }

        for (int i = 0; i < 50000000 / arr.length; i++) {
            out.write(arr);
        }
    }

    public String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        int x;
        byte[] arr = new byte[5000];
        while ((x = fileInputStream.read(arr)) > 0){
            sb.append(new String(arr,0,x));
        }
        return sb.toString();
    }

    public void splitFiles(String nameNewFile, File... files) throws IOException {
        File newFile = new File(nameNewFile);
        if (newFile.exists()) newFile.delete(); newFile.createNewFile();
        for (File file:files) {
            fillResulFile(newFile,readFile(file));
        }
        System.out.println(newFile.toString());
    }

    public void fillResulFile(File resultFile,String data) throws IOException {
        FileWriter fileWriter = new FileWriter(resultFile,true);
        fileWriter.append(data + "\n");
        fileWriter.flush();
    }
}