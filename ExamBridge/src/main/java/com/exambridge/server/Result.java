package com.exambridge.server;

import java.util.List;

public class Result {

    private String studentName;
    private int score;
    private int totalQuestions;
    private String dateTime;
    private List<AnswerRecord> answers;

    public Result(String studentName,
                  int score,
                  int totalQuestions,
                  String dateTime,
                  List<AnswerRecord> answers) {

        this.studentName = studentName;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.dateTime = dateTime;
        this.answers = answers;
    }

    public int getScore() {
        return score;
    }
}