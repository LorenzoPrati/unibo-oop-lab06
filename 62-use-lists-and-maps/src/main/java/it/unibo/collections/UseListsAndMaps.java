package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int START = 1000;
    private static final int END = 2000;
    private static final int ELEMS = 100_000;
    private static final int CONST = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> arr = new ArrayList<>();
        for (int i = START; i < END; i++) {
            arr.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linked = new LinkedList<>(arr);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tmp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int elem : arr) {
            System.out.append(Integer.toString(elem) + " ");
        }
        System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arr.add(0, i);
        }
        System.out.println("Inserting 100.000 elements in an ArrayList : " + getTime(time));
        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            linked.add(i);
        }
        System.out.println("Inserting 100.000 elements in a LinkedList : " + getTime(time));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < CONST; i++) {
            arr.get(arr.size() / 2);
        }
        System.out.println("Reading 1000 times the element in the middle of an ArrayList : " + getTime(time));
        time = System.nanoTime();
        for (int i = 0; i < CONST; i++) {
            linked.get(linked.size() / 2);
        }
        System.out.println("Reading 1000 times the elements in the middle of a LinkedList : " + getTime(time));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("America", 972_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_00L);
        /*
         * 8) Compute the population of the world
         */
        final Set<Map.Entry<String, Long>> set = map.entrySet();
        long sum = 0;
        for (final var elem : set) {
            sum = sum + elem.getValue();
        }
        System.out.println("The population of the world is = " + sum);
    }

    private static String getTime(final long time) {
        final var diff = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(diff);
        return diff + " ns" + ", " + millis + " ms";
    }
}
