package com.exambridge.model;

public class MultipleChoice extends Question {

    private String[] choices;

    public MultipleChoice(String questionText,
                          String correctAnswer,
                          String[] choices) {

        super(questionText, correctAnswer);
        this.choices = choices;
    }

    @Override
    public String displayQuestion() {

        StringBuilder sb = new StringBuilder();

        sb.append(questionText).append("\n");

        for (String choice : choices) {
            sb.append(choice).append("\n");
        }

        return sb.toString();
    }
}