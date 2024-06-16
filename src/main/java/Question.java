import java.util.List;
import java.util.Objects;

public class Question {

    private String question;
    private List<String> answers;
    private int correctAnswer;

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public Question(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return correctAnswer == question1.correctAnswer && Objects.equals(question, question1.question) && Objects.equals(answers, question1.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answers, correctAnswer);
    }
}
