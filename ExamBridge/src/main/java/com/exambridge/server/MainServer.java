package com.exambridge.server;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {

        ExamManager examManager = new ExamManager();

        try (ServerSocket server = new ServerSocket(8000)) {

            System.out.println("ExamBridge Server Started...");

            while (true) {

                Socket client = server.accept();

                System.out.println("Student Connected!");

                ClientHandler handler =
                        new ClientHandler(client, examManager);

                new Thread(handler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}