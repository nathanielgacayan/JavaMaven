package com.exambridge.model;

public abstract class Question {

    protected String questionText;
    protected String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
    
    public String getQuestionText() {
        return questionText;
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public abstract String displayQuestion();
}