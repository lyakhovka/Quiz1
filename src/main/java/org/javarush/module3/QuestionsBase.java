package org.javarush.module3;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBase {
    private static QuestionsBase instance;
    private final List<Question> questions;
    private int correctAnswersAmount;
    private int incorrectAnswersAmount;
    private  QuestionsBase(){
       questions = init();
       correctAnswersAmount = 0;
       incorrectAnswersAmount = 0;
    }

    private List<Question> init(){
        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question("What is the right shape to form an apple or pear tree?",
                List.of("Cup shape",
                        "Pyramid shape with one central main brunch"),
                1));
        questions.add(new Question("What is the right shape to form a plum or apricot tree?",
                List.of("Cup shape",
                        "Pyramid shape with one central main brunch"),
                0));
        questions.add(new Question("What is NOT an aim of a fruit tree pruning?",
                List.of("Remove or redirect all horizontal branches",
                        "Remove or redirect all vertical branches",
                        "Remove all damaged branches",
                        "Make enough space within the tree crown."),
                0));
        questions.add(new Question("Is there any difference in the trimming approach " +
                "for fruit and decorative trees?",
                List.of("Yes","No"),0));
        questions.add(new Question("What is the right time for splitting or moving peony bushes?",
                List.of("Spring (up to the middle of Jun)",
                        "End of summer up to the middle of September",
                        "Late Autumn when the bushes completely faded away",
                        "Any time"),1));
        questions.add(new Question("When NOT to fertilize plants with nitrogen?",
                List.of("Spring",
                        "Summer",
                        "Autumn"),
                2));
        questions.add(new Question("What are the three basic components of mineral fertilizers?",
                List.of("Nitrogen, Potassium, Serum",
                        "Serum, Nitrogen, Chalk",
                        "Fluoride, Potassium, Chalk",
                        "Nitrogen, Potassium, Fluoride"),
                3));
        questions.add(new Question("What is NOT a kind of roses?",
                List.of("Climbers",
                        "Runners",
                        "Shrubs",
                        "Tea roses"),
                1));
        questions.add(new Question("What is the right place to plant hydrangea?",
                List.of("Sunny place with alkaline soil, not a lot of water.",
                        "Any place, hydrangea is not picky.",
                        "Shaded place, properly hydrated, acidic soil."),
                2));
        questions.add(new Question("What to apply when your plant is affected by fungus?",
                List.of("Fungicides",
                        "Insecticide",
                        "Herbicide"),
                0));

        return questions;
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

    public int getCorrectAnswersAmount(){
        return correctAnswersAmount;
    }

    public int getIncorrectAnswersAmount(){
        return incorrectAnswersAmount;
    }

    public void setCorrectAnswersAmount(int correctAnswersAmount){
        this.correctAnswersAmount = correctAnswersAmount;
    }

    public void setIncorrectAnswersAmount(int incorrectAnswersAmount){
        this.incorrectAnswersAmount = incorrectAnswersAmount;
    }
}
