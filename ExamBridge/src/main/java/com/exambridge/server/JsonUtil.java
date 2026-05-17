package com.exambridge.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil {

    private static final String FILE_NAME = "results.json";

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static List<Result> loadResults() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            Reader reader = new FileReader(FILE_NAME);

            Type listType =
                    new TypeToken<List<Result>>() {}.getType();

            List<Result> results =
                    gson.fromJson(reader, listType);

            reader.close();

            if (results == null) {
                return new ArrayList<>();
            }

            return results;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveResult(Result result) {

        List<Result> results = loadResults();

        results.add(result);

        results.sort((a, b) ->
                Integer.compare(b.getScore(), a.getScore()));

        try (Writer writer = new FileWriter(FILE_NAME)) {

            gson.toJson(results, writer);

            System.out.println("Result saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayLeaderboard() {

        List<Result> results = loadResults();

        System.out.println("\n===== LEADERBOARD =====");

        int rank = 1;

        for (Result r : results) {

            System.out.println(rank + ". Score: "
                    + r.getScore());

            rank++;
        }
    }
}