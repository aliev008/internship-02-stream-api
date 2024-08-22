package org.example;

import org.example.entities.Trader;
import org.example.entities.Transaction;
import org.example.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Filtering transactions by year and sorting them by value:");
        System.out.println(Utils.getAllTransactionsByYear(transactions, 2011));
        System.out.println();


        System.out.println("2. A list of unique cities where traders work:");
        System.out.println(Utils.getUniqueListOfTradersCities(transactions));
        System.out.println();


        System.out.println("3. List of Cambridge traders sorted by name:");
        System.out.println(Utils.findTradersByCity(transactions, "Cambridge", Order.ASCENDING));
        System.out.println();


        System.out.println("4. Retrieve all trader names as a string sorted alphabetically:");
        System.out.println(Utils.getAllTradersNames(transactions, Order.ASCENDING));
        System.out.println();


        System.out.println("5. Verifying the existence of traders in Milan:");
        if (Utils.isTradersExistInCity(transactions, "Milan")) {
            System.out.println("Yes, there is at least 1 trader exists in Milan");
        } else {
            System.out.println("There is no traders exist in Milan");
        }
        System.out.println();


        System.out.println("6. Get the sum of all transactions:");
        System.out.println(Utils.getSumOfAllTransactions(transactions));
        System.out.println();


        System.out.println("7. Get the max value of all transactions:");
        System.out.println(Utils.getMaxValue(transactions));
        System.out.println();


        System.out.println("8. Get the min value of all transactions:");
        System.out.println(Utils.getMinValue(transactions));
        System.out.println();
    }
}