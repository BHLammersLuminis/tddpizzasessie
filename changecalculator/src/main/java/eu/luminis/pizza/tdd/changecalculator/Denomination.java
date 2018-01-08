package eu.luminis.pizza.tdd.changecalculator;

public enum Denomination {
    FIVE_HUNDRED(500),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIFTY(50),
    TWENTY(20),
    FIVE(5),
    TEN(10),
    TWO(2),
    ONE(1);
    
    private final int amount;
    
    private Denomination(final int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
}
