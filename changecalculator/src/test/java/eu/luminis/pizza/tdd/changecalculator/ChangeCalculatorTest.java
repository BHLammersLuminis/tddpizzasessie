package eu.luminis.pizza.tdd.changecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.hamcrest.collection.IsMapContaining;
import java.util.Map;

import org.junit.Test;

public class ChangeCalculatorTest {

    @Test
    public void calculateChange() {
        final Map<Denomination, Integer> change = ChangeCalculator.calculateChange(377, 400);
        assertEquals(3, change.size());
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWENTY, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWO, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.ONE, 1));
    }

    @Test
    public void calculateChange_ExactAmount() {
        final Map<Denomination, Integer> change = ChangeCalculator.calculateChange(377, 377);
        assertTrue(change.isEmpty());
    }

    @Test
    public void calculateChange_WrongDenominations() {
        final Map<Denomination, Integer> change = ChangeCalculator.calculateChange(87, 100);
        assertEquals(3, change.size());
        assertThat(change, IsMapContaining.hasEntry(Denomination.TEN, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWO, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.ONE, 1));
    }

    @Test
    public void calculateChange_AllDenominations() {
        final Map<Denomination, Integer> change = ChangeCalculator.calculateChange(222, 1000);
        assertEquals(9, change.size());
        assertThat(change, IsMapContaining.hasEntry(Denomination.FIVE_HUNDRED, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWO_HUNDRED, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.HUNDRED, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.FIFTY, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWENTY, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TEN, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.FIVE, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.TWO, 1));
        assertThat(change, IsMapContaining.hasEntry(Denomination.ONE, 1));
    }
}
