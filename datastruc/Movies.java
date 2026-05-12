
import java.util.Scanner;

public class Movies {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rental = 0, sales = 0;
        int horror = 0, scifi = 0, drama = 0, comedy = 0, cartoons = 0;
        int vcdTotal = 0, dvdTotal = 0, tapeTotal = 0;

        char answer;

        do {
            System.out.println("1. DVD");
            System.out.println("2. VCD");
            System.out.println("3. Tape");
            System.out.print("Choice: ");
            int code = sc.nextInt();

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

            sc.nextLine();
            System.out.println("Type: " + type);
            System.out.print("Input title: ");
            String title = sc.nextLine();

            System.out.println("1. Horror");
            System.out.println("2. Scifi");
            System.out.println("3. Drama");
            System.out.println("4. Comedy");
            System.out.println("5. Cartoons");
            System.out.print("Category: ");
            int category = sc.nextInt();

            switch (category) {
                case 1 ->
                    horror++;
                case 2 ->
                    scifi++;
                case 3 ->
                    drama++;
                case 4 ->
                    comedy++;
                case 5 ->
                    cartoons++;
            }

            System.out.print("Minutes: ");
            int minutes = sc.nextInt();

            sc.nextLine();
            System.out.print("Genre ---> Setting: ");
            String setting = sc.nextLine();

            System.out.println("1. Rental");
            System.out.println("2. Sales");
            System.out.print("Transaction: ");
            int transactionType = sc.nextInt();

            if (transactionType == 1) {
                rental++; 
            }else if (transactionType == 2) {
                sales++;
            }

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Register another? Y/N ");
            answer = sc.next().charAt(0);

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

        sc.close();
    }
}
