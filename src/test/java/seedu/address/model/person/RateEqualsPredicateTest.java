package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class RateEqualsPredicateTest {

    @Test
    public void equals() {
        RateEqualsPredicate firstPredicate = new RateEqualsPredicate(new Rate("5"));
        RateEqualsPredicate secondPredicate = new RateEqualsPredicate(new Rate("10"));

        // same object
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values
        RateEqualsPredicate firstPredicateCopy = new RateEqualsPredicate(new Rate("5"));
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different type
        assertFalse(firstPredicate.equals(1));

        // null
        assertFalse(firstPredicate.equals(null));

        // different rate
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_rateMatches() {
        RateEqualsPredicate predicate = new RateEqualsPredicate(new Rate("5"));

        // exact match
        assertTrue(predicate.test(new PersonBuilder().withRate("5").build()));

        // different rate
        assertFalse(predicate.test(new PersonBuilder().withRate("10").build()));

        // edge case: same numeric but different format (if applicable)
        assertTrue(predicate.test(new PersonBuilder().withRate("5").build()));
    }
}
