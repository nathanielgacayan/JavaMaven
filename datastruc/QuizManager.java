
import java.util.*;

public class QuizManager {

    private final List<Question> questions;
    private final Scanner scanner;

    public QuizManager(List<Question> questions, Scanner scanner) {
        this.questions = questions;
        this.scanner = scanner;
    }

    public void playQuiz(Player player) {

        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);

        int scoreBefore = player.getScore();

        for (Question q : shuffled) {
            System.out.println("\nQ: " + q.getQuestion());
            System.out.print("Your answer: ");

            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase(q.getAnswer().trim())) {
                System.out.println("Correct!");
                player.addScore(1);
            } else {
                System.out.println("Wrong! Correct answer: " + q.getAnswer());
            }
        }

        int gained = player.getScore() - scoreBefore;
        System.out.println("\nYou gained " + gained + " point(s).");
        System.out.println("Total Score: " + player.getScore());
    }
}
