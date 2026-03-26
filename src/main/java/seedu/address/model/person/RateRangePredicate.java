package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Rate} is within the given inclusive range.
 */
public class RateRangePredicate implements Predicate<Person> {
    private final int lowerBound;
    private final int upperBound;

    /**
     * Creates a predicate that checks whether a person's rate is between
     * {@code lowerBound} and {@code upperBound}, inclusive.
     */
    public RateRangePredicate(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean test(Person person) {
        int personRate = Integer.parseInt(person.getRate().toString());
        return personRate >= lowerBound && personRate <= upperBound;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof RateRangePredicate)) {
            return false;
        }

        RateRangePredicate otherPredicate = (RateRangePredicate) other;
        return lowerBound == otherPredicate.lowerBound
                && upperBound == otherPredicate.upperBound;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("lowerBound", lowerBound)
                .add("upperBound", upperBound)
                .toString();
    }
}
