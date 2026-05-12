
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Question> questions = new ArrayList<>();
    static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        questions = FileHandler.loadQuestions();
        players = FileHandler.loadScores();

        while (true) {
            System.out.println("\n--- QUIZ GAME ---");
            System.out.println("1. Register Player");
            System.out.println("2. Add Question");
            System.out.println("3. Play Quiz");
            System.out.println("4. Show Leaderboard");
            System.out.println("5. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1 ->
                    registerPlayer();
                case 2 ->
                    addQuestion();
                case 3 ->
                    playGame();
                case 4 ->
                    showLeaderboard();
                case 5 ->
                    exitProgram();
                default ->
                    System.out.println("Invalid choice.");
            }
        }
    }

    static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    static void registerPlayer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        if (name.isBlank()) {
            System.out.println("Invalid name.");
            return;
        }

        players.add(new Player(name));
        System.out.println("Player added.");
    }

    static void addQuestion() {
        System.out.print("Question: ");
        String q = scanner.nextLine().trim();

        System.out.print("Answer: ");
        String a = scanner.nextLine().trim();

        if (q.isBlank() || a.isBlank()) {
            System.out.println("Invalid input.");
            return;
        }

        questions.add(new Question(q, a));
        System.out.println("Question added.");
    }

    static void playGame() {
        if (players.isEmpty()) {
            System.out.println("No players registered.");
            return;
        }

        Player player = selectPlayer();
        if (player == null) {
            return;
        }

        QuizManager qm = new QuizManager(questions, scanner);
        qm.playQuiz(player);
    }

    static Player selectPlayer() {
        System.out.println("\nSelect Player:");

        for (int i = 0; i < players.size(); i++) {
            System.out.println(i + ". " + players.get(i).getName());
        }

        int index = getIntInput();

        if (index < 0 || index >= players.size()) {
            System.out.println("Invalid selection.");
            return null;
        }

        return players.get(index);
    }

    static void showLeaderboard() {
        if (players.isEmpty()) {
            System.out.println("No players yet.");
            return;
        }

        players.sort((a, b) -> b.getScore() - a.getScore());

        System.out.println("\n--- LEADERBOARD ---");
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getScore());
        }
    }

    static void exitProgram() throws Exception {
        FileHandler.saveQuestions(questions);
        FileHandler.saveScores(players);
        System.out.println("Data saved. Goodbye!");
        System.exit(0);
    }
}
