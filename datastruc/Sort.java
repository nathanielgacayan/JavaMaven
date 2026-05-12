

import java.util.*;


public class Sort {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        String[] id = new String[100];
        String[] name = new String[100];
        int[] score = new int[100];
        double[] rating = new double[100];
        String[] rank = new String[100];


        int count = 0;
        int choice;


        do {


            System.out.println("\n===== MENU =====");
            System.out.println("1. Add");
            System.out.println("2. Search (by Index)");
            System.out.println("3. Edit (by Index)");
            System.out.println("4. Delete (by ID)");
            System.out.println("5. Sort (by Score)");
            System.out.println("6. List All");
            System.out.println("7. Search & Delete (by ID or Name)");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            scan.nextLine();


            switch (choice) {


                case 1:
                    if (count == 100) {
                        System.out.println("Array is full!");
                        break;
                    }


                    System.out.println("\n1. Add at End");
                    System.out.println("2. Insert at Beginning");
                    System.out.println("3. Insert at Middle");
                    System.out.print("Choose position: ");
                    int pos = scan.nextInt();
                    scan.nextLine();


                    System.out.print("ID: ");
                    String newID = scan.nextLine();


                    System.out.print("Name: ");
                    String newName = scan.nextLine();


                    System.out.print("Score: ");
                    int newScore = scan.nextInt();


                    System.out.print("Rating: ");
                    double newRating = scan.nextDouble();
                    scan.nextLine();


                    System.out.print("Rank: ");
                    String newRank = scan.nextLine();


                    int index = count;


                    if (pos == 2) {
                        index = 0;
                        for (int i = count; i > 0; i--) {
                            id[i] = id[i - 1];
                            name[i] = name[i - 1];
                            score[i] = score[i - 1];
                            rating[i] = rating[i - 1];
                            rank[i] = rank[i - 1];
                        }


                    } else if (pos == 3) {
                        index = count / 2;
                        for (int i = count; i > index; i--) {
                            id[i] = id[i - 1];
                            name[i] = name[i - 1];
                            score[i] = score[i - 1];
                            rating[i] = rating[i - 1];
                            rank[i] = rank[i - 1];
                        }
                    }


                    id[index] = newID;
                    name[index] = newName;
                    score[index] = newScore;
                    rating[index] = newRating;
                    rank[index] = newRank;


                    count++;
                    System.out.println("Player added!");
                    break;


                case 2:
                    System.out.print("Enter index to search: ");
                    int searchIndex = scan.nextInt();
                    scan.nextLine();


                    if (searchIndex >= 0 && searchIndex < count) {
                        System.out.println("\nPlayer Found:");
                        System.out.println("ID: " + id[searchIndex]);
                        System.out.println("Name: " + name[searchIndex]);
                        System.out.println("Score: " + score[searchIndex]);
                        System.out.println("Rating: " + rating[searchIndex]);
                        System.out.println("Rank: " + rank[searchIndex]);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;


                case 3:
                    System.out.print("Enter index to edit: ");
                    int editIndex = scan.nextInt();
                    scan.nextLine();


                    if (editIndex >= 0 && editIndex < count) {
                        System.out.println("\nCurrent Details:");
                        System.out.println("ID: " + id[editIndex]);
                        System.out.println("Name: " + name[editIndex]);
                        System.out.println("Score: " + score[editIndex]);
                        System.out.println("Rating: " + rating[editIndex]);
                        System.out.println("Rank: " + rank[editIndex]);


                        System.out.print("Do you want to edit this player? (yes/no): ");
                        String confirm = scan.nextLine();


                        if (confirm.equalsIgnoreCase("yes")) {
                            System.out.print("New ID: ");
                            id[editIndex] = scan.nextLine();


                            System.out.print("New Name: ");
                            name[editIndex] = scan.nextLine();


                            System.out.print("New Score: ");
                            score[editIndex] = scan.nextInt();


                            System.out.print("New Rating: ");
                            rating[editIndex] = scan.nextDouble();
                            scan.nextLine();


                            System.out.print("New Rank: ");
                            rank[editIndex] = scan.nextLine();


                            System.out.println("Player updated!");
                        } else {
                            System.out.println("Edit cancelled.");
                        }


                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;


                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteID = scan.nextLine();
                    boolean deleteFound = false;


                    for (int i = 0; i < count; i++) {
                        if (id[i].equalsIgnoreCase(deleteID)) {
                            for (int j = i; j < count - 1; j++) {
                                id[j] = id[j + 1];
                                name[j] = name[j + 1];
                                score[j] = score[j + 1];
                                rating[j] = rating[j + 1];
                                rank[j] = rank[j + 1];
                            }
                            count--;
                            deleteFound = true;
                            System.out.println("Player deleted!");
                            break;
                        }
                    }
                    if (!deleteFound) {
                        System.out.println("Player not found.");
                    }
                    break;


                case 5:
                    if (count == 0) {
                        System.out.println("No players to sort.");
                        break;
                    }


                    System.out.println("\nSort by Score:");
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.print("Enter choice: ");
                    int sortChoice = scan.nextInt();
                    scan.nextLine();


                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            boolean swap = false;


                            if (sortChoice == 1 && score[i] > score[j]) { // ascending
                                swap = true;
                            } else if (sortChoice == 2 && score[i] < score[j]) { // descending
                                swap = true;
                            }


                            if (swap) {
                                String tempID = id[i];
                                String tempName = name[i];
                                int tempScore = score[i];
                                double tempRating = rating[i];
                                String tempRank = rank[i];


                                id[i] = id[j];
                                name[i] = name[j];
                                score[i] = score[j];
                                rating[i] = rating[j];
                                rank[i] = rank[j];


                                id[j] = tempID;
                                name[j] = tempName;
                                score[j] = tempScore;
                                rating[j] = tempRating;
                                rank[j] = tempRank;
                            }
                        }
                    }


                    System.out.println((sortChoice == 1 ? "Ascending" : "Descending") + " sort completed!");
                    break;


                case 6:
                    if (count == 0) {
                        System.out.println("No players available.");
                    } else {
                        System.out.println("\nIndex\tID\tName\tScore\tRating\tRank");
                        for (int i = 0; i < count; i++) {
                            System.out.println(i + "\t" + id[i] + "\t" + name[i] + "\t" + score[i] + "\t" + rating[i] + "\t" + rank[i]);
                        }
                    }
                    break;


                case 7:
                    if (count == 0) {
                        System.out.println("No players available.");
                        break;
                    }


                    System.out.print("Enter ID or Name to search: ");
                    String query = scan.nextLine();
                    boolean found = false;


                    for (int i = 0; i < count; i++) {
                        if (id[i].equalsIgnoreCase(query) || name[i].equalsIgnoreCase(query)) {
                            System.out.println("\nPlayer Found at index " + i + ":");
                            System.out.println("ID: " + id[i]);
                            System.out.println("Name: " + name[i]);
                            System.out.println("Score: " + score[i]);
                            System.out.println("Rating: " + rating[i]);
                            System.out.println("Rank: " + rank[i]);


                            System.out.print("Do you want to remove this player? (yes/no): ");
                            String confirmDelete = scan.nextLine();


                            if (confirmDelete.equalsIgnoreCase("yes")) {
                                for (int j = i; j < count - 1; j++) {
                                    id[j] = id[j + 1];
                                    name[j] = name[j + 1];
                                    score[j] = score[j + 1];
                                    rating[j] = rating[j + 1];
                                    rank[j] = rank[j + 1];
                                }
                                count--;
                                System.out.println("Player removed!");
                            } else {
                                System.out.println("Player not removed.");
                            }


                            found = true;
                            break;
                        }
                    }


                    if (!found) {
                        System.out.println("Player not found.");
                    }
                    break;


                case 8:
                    System.out.println("Program ended.");
                    break;


                default:
                    System.out.println("Invalid choice.");
            }


        } while (choice != 8);


        scan.close();
    }
}



