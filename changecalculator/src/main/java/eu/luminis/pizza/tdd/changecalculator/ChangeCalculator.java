package eu.luminis.pizza.tdd.changecalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple class to calculate change for a given amount due and amount paid.
 * Does not calculate cents.
 */
public class ChangeCalculator {

    public static void main(final String[] args) {
        final int amountDue = Integer.parseInt(args[0]);
        final int amountPaid = Integer.parseInt(args[1]);
        final Map<Denomination, Integer> change = calculateChange(amountDue, amountPaid);
        final List<Denomination> denominations = Arrays.asList(Denomination.values());
        System.out.println("***********************");
        System.out.println("* Change to be given:");
        denominations.forEach(denomination -> printChange(denomination, change.get(denomination)));
        System.out.println("***********************");
    }

    public static Map<Denomination, Integer> calculateChange(final int amountDue, final int amountPaid) {
        int amountOfChange = amountPaid - amountDue;
        final Map<Denomination, Integer> change = new HashMap<>();
        for (final Denomination denomination : Denomination.values()) {
            final int number = amountOfChange / denomination.getAmount();
            if (number != 0) {
                amountOfChange -= number * denomination.getAmount();
                change.put(denomination, number);
            }
        }
        return change;
    }
    
    private static void printChange(final Denomination denomination, final Integer number) {
        if (number != null) {
            System.out.println(String.format("* %d of %d", number, denomination.getAmount()));
        }
    }
}
