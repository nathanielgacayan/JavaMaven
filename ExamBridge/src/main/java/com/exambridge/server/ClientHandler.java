package com.exambridge.server;

import com.exambridge.model.Question;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable {

    private Socket socket;
    private ExamManager examManager;

    public ClientHandler(Socket socket, ExamManager examManager) {
        this.socket = socket;
        this.examManager = examManager;
    }

   @Override
public void run() {

    try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true)
    ) {

        out.println("Enter your name:");

        String name = in.readLine();

        Student student = new Student(name);

        List<AnswerRecord> answerRecords =
                new ArrayList<>();

        out.println("Welcome " + student.getName());
        out.println("Exam Starts Now!");

        for (Question q : examManager.getQuestions()) {

            out.println("--------------------------------");
            out.println(q.displayQuestion());

            out.println("ANSWER_NOW");

            String answer = in.readLine();

            boolean correct =
                    q.checkAnswer(answer);

            if (correct) {

                student.addScore();
                out.println("Correct!");

            } else {

                out.println("Wrong!");
            }

            answerRecords.add(
                    new AnswerRecord(
                            q.getQuestionText(),
                            answer,
                            q.getCorrectAnswer(),
                            correct
                    )
            );
        }

        out.println("--------------------------------");
        out.println("Exam Finished!");

        out.println("Final Score: "
                + student.getScore()
                + "/"
                + examManager.getQuestions().size());

        String dateTime =
                java.time.LocalDateTime.now().toString();

        Result result = new Result(
                student.getName(),
                student.getScore(),
                examManager.getQuestions().size(),
                dateTime,
                answerRecords
        );

        JsonUtil.saveResult(result);

        JsonUtil.displayLeaderboard();

        socket.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}