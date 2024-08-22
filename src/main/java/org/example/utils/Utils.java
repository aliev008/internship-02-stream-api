package org.example.utils;

import org.example.Order;
import org.example.comparators.TradersNameComparator;
import org.example.comparators.ValueComparator;
import org.example.entities.Trader;
import org.example.entities.Transaction;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;


public class Utils {

    // 1. Filtering transaction by year and sorting them by value

    public static List<Transaction> getAllTransactionsByYear(List<Transaction> list, int year, Order order) {
        List<Transaction> result;

        result = list.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(new ValueComparator(order))
                .collect(Collectors.toList());

        return result;
    }

    public static List<Transaction> getAllTransactionsByYear(List<Transaction> list, int year) {
        return getAllTransactionsByYear(list, year, Order.ASCENDING);
    }

    //    2. Listing unique cities, where traders work

    public static List<String> getUniqueListOfTradersCities(List<Transaction> list) {
        return list.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    //    3. Finding traders by city and sorting them by name

    public static List<Trader> findTradersByCity(List<Transaction> list, String city, Order order) {
        List<Trader> result;

        result = list.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), city))
                .sorted(new TradersNameComparator(order))
                .collect(Collectors.toList());

        return result;
    }

    public static List<Trader> findTradersByCity(List<Transaction> list, String city) {
        return findTradersByCity(list, city, Order.ASCENDING);
    }

    //    4. Get all traders names as a string, sorted alphabetically

    public static String getAllTradersNames(List<Transaction> list, Order order) {
        StringJoiner result = new StringJoiner(", ");

        list.stream()
                .map(Transaction::getTrader)
                .sorted(new TradersNameComparator(order))
                .map(Trader::getName)
                .forEach(result::add);

        return result.toString();
    }

    public static String getAllTradersNames(List<Transaction> list) {
        return getAllTradersNames(list, Order.ASCENDING);
    }

    //    5. Verify traders existence in a city

    public static boolean isTradersExistInCity(List<Transaction> list, String city) {
        return list.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals(city));
    }

    //    6. Get sum of all transactions

    public static long getSumOfAllTransactions(List<Transaction> list) {
        return list.stream()
                .mapToLong(Transaction::getValue)
//                .reduce(0L, (acc, value) -> acc + value);
                .sum();
    }

    //    7. Get max value of all transactions:

    public static long getMaxValue(List<Transaction> list) {
        return list.stream()
                .mapToLong(Transaction::getValue)
                .max()
                .orElse(0L);
    }

    //    8. Get min value of all transactions:

    public static long getMinValue(List<Transaction> list) {
        return list.stream()
                .mapToLong(Transaction::getValue)
                .min()
                .orElse(0L);
    }


}
