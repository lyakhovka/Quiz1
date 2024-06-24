package org.javarush.module3;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBase {
    private static QuestionsBase instance;

    private final List<Question> questions;

    private  QuestionsBase(){
        questions = new ArrayList<Question>();

        questions.add(new Question("Q1", List.of("a1","a2"),0));
        questions.add(new Question("Q2", List.of("a1","a2"),0));
        questions.add(new Question("Q3", List.of("a1","a2"),0));
        questions.add(new Question("Q4", List.of("a1","a2"),0));
    }

    public static QuestionsBase getInstance(){
        if(instance == null){
            instance = new QuestionsBase();
        }
        return instance;
    }

    public List<Question> getQuestions(){
        return questions;
    }
}
