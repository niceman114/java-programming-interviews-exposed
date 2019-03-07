package com.wiley.javainterviewsexposed.chapter18;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static com.google.common.collect.Sets.SetView;

public class Guava {

    @Test
    public void multiset() {
        final Multiset<String> strings = HashMultiset.create();

        strings.add("one");
        strings.add("two");
        strings.add("two");
        strings.add("three");
        strings.add("three");
        strings.add("three");

        assertEquals(6, strings.size());
        assertEquals(2, strings.count("two"));

        final Set<String> stringSet = strings.elementSet();

        assertEquals(3, stringSet.size());
    }

    @Test
    public void multimap() {
        final Multimap<String, String> mapping = HashMultimap.create();

        mapping.put("17 High Street", "Alice Smith");
        mapping.put("17 High Street", "Bob Smith");
        mapping.put("3 Hill Lane", "Simon Anderson");

        final Collection<String> smiths = mapping.get("17 High Street");
        assertEquals(2, smiths.size());
        assertTrue(smiths.contains("Alice Smith"));
        assertTrue(smiths.contains("Bob Smith"));

        assertEquals(1, mapping.get("3 Hill Lane").size());
    }

    @Test
    public void bimap() {
        final BiMap<String, String> stockToCompany = HashBiMap.create();
        final BiMap<String, String> companyToStock =
                                               stockToCompany.inverse();

        stockToCompany.put("GOOG", "Google");
        stockToCompany.put("AAPL", "Apple");
        companyToStock.put("Facebook", "FB");

        assertEquals("Google", stockToCompany.get("GOOG"));
        assertEquals("AAPL", companyToStock.get("Apple"));
        assertEquals("Facebook", stockToCompany.get("FB"));
    }

    @Test
    public void unmodifiableCollection() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        final List<Integer> unmodifiableNumbers =
                Collections.unmodifiableList(numbers);

        try {
            unmodifiableNumbers.remove(0);
        } catch (UnsupportedOperationException e) {
            return; // test passed
        }

        fail();
    }

    @Test
    public void breakUnmodifiableCollection() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        final List<Integer> unmodifiableNumbers =
                Collections.unmodifiableList(numbers);

        assertEquals(Integer.valueOf(1), unmodifiableNumbers.get(0));

        numbers.remove(0);

        assertEquals(Integer.valueOf(2), unmodifiableNumbers.get(0));
    }

    @Test
    public void immutableCollection() {
        final Set<Integer> numberSet = new HashSet<>();
        numberSet.add(10);
        numberSet.add(20);
        numberSet.add(30);

        final Set<Integer> immutableSet = ImmutableSet.copyOf(numberSet);

        numberSet.remove(10);
        assertTrue(immutableSet.contains(10));

        try {
            immutableSet.remove(10);
        } catch (Exception e) {
            return; // test passed
        }

        fail();
    }

    @Test
    public void iterators() {
        final List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        final List<Integer> list2 = Arrays.asList(3, 4);
        final List<Integer> list3 = new ArrayList<>();
        final List<Integer> list4 = Arrays.asList(5, 6, 7, 8, 9);

        final Iterable<Integer> iterable = Iterables.concat(
                                              list1, list2, list3, list4);
        final Iterator<Integer> iterator = iterable.iterator();

        for (int i = 0; i <= 9; i++) {
            assertEquals(Integer.valueOf(i), iterator.next());
        }

        assertFalse(iterator.hasNext());
    }

    @Test
    public void setOperations() {
        final Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        final Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        final SetView<Integer> unionView = Sets.union(set1, set2);
        assertEquals(5, unionView.immutableCopy().size());

        final SetView<Integer> differenceView = Sets.difference(set1, set2);
        assertEquals(2, differenceView.immutableCopy().size());

        final SetView<Integer> intersectionView =
                                              Sets.intersection(set1, set2);
        set2.add(2);
        final Set<Integer> intersection = intersectionView.immutableCopy();
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(3));
    }
}
