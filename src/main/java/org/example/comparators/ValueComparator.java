package org.example.comparators;

import org.example.Order;
import org.example.entities.Transaction;

import java.util.Comparator;

public class ValueComparator implements Comparator<Transaction> {
    private Order order;

    public ValueComparator() {
        this.order = Order.ASCENDING;
    }

    public ValueComparator(Order order) {
        this.order = order;
    }

    @Override
    public int compare(Transaction transaction1, Transaction transaction2) {
        // Compare the transaction values
        int comparison = Integer.compare(transaction1.getValue(), transaction2.getValue());

        // Reverse the comparison if the order is DESCENDING
        return order == Order.DESCENDING ? -comparison : comparison;
    }
}
