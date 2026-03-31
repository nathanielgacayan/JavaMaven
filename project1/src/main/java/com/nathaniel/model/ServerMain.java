package com.nathaniel.model;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started .... Waiting for players...");

            Socket p1 = serverSocket.accept();
            System.out.println("Client 1 connected");

            Socket p2 = serverSocket.accept();
            System.out.println("Client 2 connected");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
