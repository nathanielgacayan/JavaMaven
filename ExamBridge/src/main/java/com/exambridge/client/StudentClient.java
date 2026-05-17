package com.exambridge.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient {

    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 8000);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);

                Scanner scanner = new Scanner(System.in)
        ) {

            String message;

            while ((message = in.readLine()) != null) {

                if (!message.trim().equals("ANSWER_NOW")) {
                    System.out.println(message);
                }

                if (message.trim().equals("ANSWER_NOW")
                        || message.contains("Enter your name")) {

                    String answer = scanner.nextLine();

                    out.println(answer);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}