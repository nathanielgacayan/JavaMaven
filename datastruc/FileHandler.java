
import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String QUESTIONS_FILE = "questions.txt";
    private static final String SCORES_FILE = "scores.txt";

    public static void saveQuestions(List<Question> questions) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(QUESTIONS_FILE))) {
            for (Question q : questions) {
                writer.write(q.getQuestion() + "|" + q.getAnswer());
                writer.newLine();
            }
        }
    }

    public static List<Question> loadQuestions() throws IOException {
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

    public static void saveScores(List<Player> players) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORES_FILE))) {
            for (Player p : players) {
                writer.write(p.getName() + "," + p.getScore());
                writer.newLine();
            }
        }
    }

    public static List<Player> loadScores() throws IOException {
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
}
