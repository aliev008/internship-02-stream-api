package org.example.comparators;

import org.example.Order;
import org.example.entities.Trader;

import java.util.Comparator;

public class TradersNameComparator implements Comparator<Trader> {
    private final Order order;

    public TradersNameComparator() {
        this.order = Order.ASCENDING;
    }

    public TradersNameComparator(Order order) {
        this.order = order;
    }

    @Override
    public int compare(Trader trader1, Trader trader2) {
        int comparison = trader1.getName().compareTo(trader2.getName());

        // Reverse the comparison if the order is DESCENDING
        return order == Order.DESCENDING ? -comparison : comparison;
    }
}
