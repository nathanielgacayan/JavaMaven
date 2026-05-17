package com.exambridge.server;

public class AnswerRecord {

    private String question;
    private String studentAnswer;
    private String correctAnswer;
    private boolean correct;

    public AnswerRecord(String question,
                        String studentAnswer,
                        String correctAnswer,
                        boolean correct) {

        this.question = question;
        this.studentAnswer = studentAnswer;
        this.correctAnswer = correctAnswer;
        this.correct = correct;
    }
}