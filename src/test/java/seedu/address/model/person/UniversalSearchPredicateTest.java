package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class UniversalSearchPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        UniversalSearchPredicate firstPredicate = new UniversalSearchPredicate(firstPredicateKeywordList);
        UniversalSearchPredicate secondPredicate = new UniversalSearchPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        UniversalSearchPredicate firstPredicateCopy = new UniversalSearchPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_universalSearch_returnsTrue() {
        // Name match (prefix)
        UniversalSearchPredicate predicate = new UniversalSearchPredicate(Collections.singletonList("Ali"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Phone match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("123"));
        assertTrue(predicate.test(new PersonBuilder().withPhone("12345").build()));

        // Email match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("ali"));
        assertTrue(predicate.test(new PersonBuilder().withEmail("alice@example.com").build()));

        // Address match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("Jurong"));
        assertTrue(predicate.test(new PersonBuilder().withAddress("Jurong West").build()));

        // Subject match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("Mat"));
        assertTrue(predicate.test(new PersonBuilder().withSubject("Math").build()));

        // Rate match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("5"));
        assertTrue(predicate.test(new PersonBuilder().withRate("50").build()));

        // Tag match (prefix)
        predicate = new UniversalSearchPredicate(Collections.singletonList("fri"));
        assertTrue(predicate.test(new PersonBuilder().withTags("friend").build()));

        // Multiple keywords, one matches
        predicate = new UniversalSearchPredicate(Arrays.asList("NoMatch", "Ali"));
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_universalSearch_returnsFalse() {
        // Non-matching keyword
        UniversalSearchPredicate predicate = new UniversalSearchPredicate(Collections.singletonList("Carol"));
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        UniversalSearchPredicate predicate = new UniversalSearchPredicate(keywords);

        String expected = UniversalSearchPredicate.class.getCanonicalName() + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
