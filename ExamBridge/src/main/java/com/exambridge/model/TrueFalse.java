package com.exambridge.model;

public class TrueFalse extends Question {

    public TrueFalse(String questionText, String correctAnswer) {
        super(questionText, correctAnswer);
    }

    @Override
    public String displayQuestion() {
        return questionText + " (True/False)";
    }
}