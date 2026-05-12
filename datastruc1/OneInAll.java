import java.io.*;
import java.util.*;

public class OneInAll {

    static Scanner scanner = new Scanner(System.in);

    static List<Question> questions = new ArrayList<>();
    static List<Player> players = new ArrayList<>();

    static final String QUESTIONS_FILE = "questions.txt";
    static final String SCORES_FILE = "scores.txt";

    static String[] id = new String[100];
    static String[] name = new String[100];
    static int[] score = new int[100];
    static double[] rating = new double[100];
    static String[] rank = new String[100];
    static int count = 0;

    public static void main(String[] args) throws Exception {

        questions = loadQuestions();
        players = loadScores();

        int choice;

        do {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Grocery Program");
            System.out.println("2. Movie System");
            System.out.println("3. Quiz Game");
            System.out.println("4. Player Sort System");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> groceryProgram();
                case 2 -> movieSystem();
                case 3 -> quizSystem();
                case 4 -> sortSystem();
                case 5 -> {
                    saveQuestions(questions);
                    saveScores(players);
                    System.out.println("Data saved. Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }

    static void groceryProgram() {

        String strProdName, strAnotherP, strCustomer;
        char cCustomer, cAnotherP;
        double dQty, dBill, dPrice;
        double dTotal, dPay, dChange;

        do {

            dBill = 0;

            do {

                System.out.println("\nWelcome to Grocery ni Tanggol!!");

                System.out.print("Input product name: ");
                strProdName = scanner.nextLine();

                System.out.print("Input price: ");
                dPrice = scanner.nextDouble();

                System.out.print("Quantity: ");
                dQty = scanner.nextDouble();
                scanner.nextLine();

                dTotal = dQty * dPrice;

                System.out.println("Total: " + dTotal);

                dBill += dTotal;

                System.out.print("Another product Y/N? ");
                strAnotherP = scanner.nextLine();
                cAnotherP = strAnotherP.charAt(0);

            } while (cAnotherP == 'Y' || cAnotherP == 'y');

            System.out.println("Bill : " + dBill);

            System.out.print("Payment: ");
            dPay = scanner.nextDouble();
            scanner.nextLine();

            if (dPay >= dBill) {

                dChange = dPay - dBill;

                System.out.println("Change: " + dChange);
                System.out.println("Thank you for shopping");

            } else {

                System.out.println("Money is not enough!");

            }

            System.out.print("Another customer Y/N? ");
            strCustomer = scanner.nextLine();
            cCustomer = strCustomer.charAt(0);

        } while (cCustomer == 'Y' || cCustomer == 'y');

        System.out.println("Grocery program terminating...");
    }

    static void movieSystem() {

        int rental = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int vcdTotal = 0, dvdTotal = 0, tapeTotal = 0;

        char answer;

        do {
            System.out.println("1. DVD");
            System.out.println("2. VCD");
            System.out.println("3. Tape");
            System.out.print("Choice: ");
            int code = scanner.nextInt();

            String type = "";

            if (code == 1) {
                dvdTotal++;
                type = "DVD";
            } else if (code == 2) {
                vcdTotal++;
                type = "VCD";
            } else if (code == 3) {
                tapeTotal++;
                type = "Tape";
            }

            scanner.nextLine();

            System.out.println("Type: " + type);

            System.out.print("Input title: ");
            String title = scanner.nextLine();

            System.out.println("1. Horror");
            System.out.println("2. Scifi");
            System.out.println("3. Drama");
            System.out.println("4. Comedy");
            System.out.println("5. Cartoons");
            System.out.print("Category: ");

            int category = scanner.nextInt();

            switch (category) {
                case 1 -> horror++;
                case 2 -> scifi++;
                case 3 -> drama++;
                case 4 -> comedy++;
                case 5 -> cartoons++;
            }

            System.out.print("Minutes: ");
            int minutes = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Genre ---> Setting: ");
            String setting = scanner.nextLine();

            System.out.println("1. Rental");
            System.out.println("2. Sales");
            System.out.print("Transaction: ");

            int transactionType = scanner.nextInt();

            if (transactionType == 1) {
                rental++;
            } else if (transactionType == 2) {
                sales++;
            }

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Register another? Y/N ");
            answer = scanner.next().charAt(0);
            scanner.nextLine();

        } while (answer == 'y' || answer == 'Y');

        System.out.println("\nReports");
        System.out.println("For rent: " + rental);
        System.out.println("For Sale: " + sales);
        System.out.println("VCD Total: " + vcdTotal);
        System.out.println("DVD Total: " + dvdTotal);
        System.out.println("Tape Total: " + tapeTotal);
        System.out.println("Horror movies: " + horror);
        System.out.println("Scifi movies: " + scifi);
        System.out.println("Drama movies: " + drama);
        System.out.println("Comedy movies: " + comedy);
        System.out.println("Cartoons movies: " + cartoons);
    }

    static void quizSystem() throws Exception {

        int choice;

        do {

            System.out.println("\n--- QUIZ GAME ---");
            System.out.println("1. Register Player");
            System.out.println("2. Add Question");
            System.out.println("3. Play Quiz");
            System.out.println("4. Show Leaderboard");
            System.out.println("5. Back");

            choice = getIntInput();

            switch (choice) {
                case 1 -> registerPlayer();
                case 2 -> addQuestion();
                case 3 -> playGame();
                case 4 -> showLeaderboard();
                case 5 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);
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

    static void saveQuestions(List<Question> questions) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(QUESTIONS_FILE))) {

            for (Question q : questions) {
                writer.write(q.getQuestion() + "|" + q.getAnswer());
                writer.newLine();
            }
        }
    }

    static List<Question> loadQuestions() throws IOException {

        List<Question> list = new ArrayList<>();

        File file = new File(QUESTIONS_FILE);

        if (!file.exists()) {
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 2) {
                    list.add(new Question(parts[0], parts[1]));
                }
            }
        }

        return list;
    }

    static void saveScores(List<Player> players) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORES_FILE))) {

            for (Player p : players) {
                writer.write(p.getName() + "," + p.getScore());
                writer.newLine();
            }
        }
    }

    static List<Player> loadScores() throws IOException {

        List<Player> list = new ArrayList<>();

        File file = new File(SCORES_FILE);

        if (!file.exists()) {
            return list;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 2) {

                    try {
                        Player p = new Player(parts[0]);
                        p.addScore(Integer.parseInt(parts[1]));
                        list.add(p);

                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }

        return list;
    }

    static void sortSystem() {

        int choice;

        do {

            System.out.println("\n===== SORT MENU =====");
            System.out.println("1. Add");
            System.out.println("2. List All");
            System.out.println("3. Sort");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {

                case 1:

                    if (count == 100) {
                        System.out.println("Array full.");
                        break;
                    }

                    System.out.print("ID: ");
                    id[count] = scanner.nextLine();

                    System.out.print("Name: ");
                    name[count] = scanner.nextLine();

                    System.out.print("Score: ");
                    score[count] = scanner.nextInt();

                    System.out.print("Rating: ");
                    rating[count] = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Rank: ");
                    rank[count] = scanner.nextLine();

                    count++;

                    System.out.println("Player added!");
                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No players.");
                    } else {

                        System.out.println("\nIndex\tID\tName\tScore\tRating\tRank");

                        for (int i = 0; i < count; i++) {

                            System.out.println(
                                    i + "\t" +
                                    id[i] + "\t" +
                                    name[i] + "\t" +
                                    score[i] + "\t" +
                                    rating[i] + "\t" +
                                    rank[i]
                            );
                        }
                    }

                    break;

                case 3:

                    for (int i = 0; i < count - 1; i++) {

                        for (int j = i + 1; j < count; j++) {

                            if (score[i] < score[j]) {

                                String tempID = id[i];
                                id[i] = id[j];
                                id[j] = tempID;

                                String tempName = name[i];
                                name[i] = name[j];
                                name[j] = tempName;

                                int tempScore = score[i];
                                score[i] = score[j];
                                score[j] = tempScore;

                                double tempRating = rating[i];
                                rating[i] = rating[j];
                                rating[j] = tempRating;

                                String tempRank = rank[i];
                                rank[i] = rank[j];
                                rank[j] = tempRank;
                            }
                        }
                    }

                    System.out.println("Sorted descending by score.");
                    break;

                case 4:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}

class Player implements Serializable {

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}

class Question implements Serializable {

    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

class QuizManager {

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