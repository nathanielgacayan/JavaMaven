package com.exambridge.server;

import com.exambridge.model.*;
import java.util.*;

public class ExamManager {

    private List<Question> questions;

    public ExamManager() {

        questions = new ArrayList<>();

        // Multiple Choice Questions
        questions.add(new MultipleChoice(
                "What is 2 + 2?",
                "A",
                new String[]{
                        "A. 4",
                        "B. 5",
                        "C. 6"
                }
        ));

        questions.add(new MultipleChoice(
                "Which language is primarily used for Android development?",
                "B",
                new String[]{
                        "A. Python",
                        "B. Java",
                        "C. HTML"
                }
        ));

        questions.add(new MultipleChoice(
                "Which keyword is used to create a class in Java?",
                "C",
                new String[]{
                        "A. function",
                        "B. define",
                        "C. class"
                }
        ));

        questions.add(new MultipleChoice(
                "What does CPU stand for?",
                "A",
                new String[]{
                        "A. Central Processing Unit",
                        "B. Computer Personal Unit",
                        "C. Central Program Utility"
                }
            ));
        questions.add(new MultipleChoice(
                         "What is 5 + 5?", 
                        "C", 
                new String[]{
                        "A. 11",
                        "B. 12",
                        "C. 10"
                }
                    ));

        // True or False Questions
        questions.add(new TrueFalse(
                "Java is platform independent.",
                "True"
        ));

        questions.add(new TrueFalse(
                "HTML is a programming language.",
                "False"
        ));

        questions.add(new TrueFalse(
                "A variable can store data values.",
                "True"
        ));

        questions.add(new TrueFalse(
                "The Earth is flat.",
                "False"
        ));
        questions.add(new TrueFalse(
                            "The Dog has 5 Legs",
                            "False"
        ));
        
    }

    public List<Question> getQuestions() {
        return questions;
    }
}