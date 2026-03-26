package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Rate} is greater than the given value.
 */
public class RateGreaterThanPredicate implements Predicate<Person> {
    private final int lowerBound;

    /**
     * Creates a predicate that checks whether a person's rate is
     * greater than {@code lowerBound}.
     */
    public RateGreaterThanPredicate(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    public boolean test(Person person) {
        int personRate = Integer.parseInt(person.getRate().toString());
        return personRate > lowerBound;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof RateGreaterThanPredicate)) {
            return false;
        }

        RateGreaterThanPredicate otherPredicate = (RateGreaterThanPredicate) other;
        return lowerBound == otherPredicate.lowerBound;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("lowerBound", lowerBound)
                .toString();
    }
}
