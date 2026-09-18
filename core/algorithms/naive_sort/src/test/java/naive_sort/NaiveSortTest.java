package naive_sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias de la especificación 05_Naive_Sort.
 *
 * <p>Caso nulo incluido: en Java {@code int[]} admite {@code null} y el contrato exige
 * devolverlo como indicador de fallo, sin lanzar excepciones.
 */
public class NaiveSortTest {

    // Casos de prueba de la especificación 05_Naive_Sort.md
    private static final int[] STANDARD_INPUT = {5, 2, 9, 1, 5, 6};
    private static final int[] STANDARD_OUTPUT = {1, 2, 5, 5, 6, 9};

    private static final int[] SORTED_INPUT = {1, 2, 3, 4, 5};
    private static final int[] SORTED_OUTPUT = {1, 2, 3, 4, 5};

    private static final int[] REVERSE_INPUT = {5, 4, 3, 2, 1};
    private static final int[] REVERSE_OUTPUT = {1, 2, 3, 4, 5};

    private static final int[] IDENTICAL_INPUT = {7, 7, 7, 7};
    private static final int[] IDENTICAL_OUTPUT = {7, 7, 7, 7};

    private static final int[] NEGATIVE_INPUT = {3, -1, 4, -5, 0};
    private static final int[] NEGATIVE_OUTPUT = {-5, -1, 0, 3, 4};

    private static final int[] SINGLE_INPUT = {42};
    private static final int[] SINGLE_OUTPUT = {42};

    private static final int[] EMPTY_INPUT = {};
    private static final int[] EMPTY_OUTPUT = {};

    private record SortCase(String description, int[] input, int[] expected) {}

    private static final List<SortCase> CASES = List.of(
            new SortCase("an unsorted array", STANDARD_INPUT, STANDARD_OUTPUT),
            new SortCase("an already sorted array", SORTED_INPUT, SORTED_OUTPUT),
            new SortCase("a reverse ordered array", REVERSE_INPUT, REVERSE_OUTPUT),
            new SortCase("an array of identical elements", IDENTICAL_INPUT, IDENTICAL_OUTPUT),
            new SortCase("an array with negative numbers", NEGATIVE_INPUT, NEGATIVE_OUTPUT),
            new SortCase("a single element array", SINGLE_INPUT, SINGLE_OUTPUT),
            new SortCase("an empty array", EMPTY_INPUT, EMPTY_OUTPUT),
            new SortCase("a null input", null, null));

    /**
     * Helper compartido: recibe la función a probar y el nombre del algoritmo, y ejecuta todos
     * los casos con un mensaje descriptivo cada uno.
     *
     * <p>Cada caso ordena una copia del fixture, porque los algoritmos ordenan in-place y los
     * arrays de Java son mutables.
     */
    private static void assertSortsAllCases(UnaryOperator<int[]> sort, String algorithm) {
        for (SortCase testCase : CASES) {
            int[] input = testCase.input() == null ? null : testCase.input().clone();
            int[] actual = sort.apply(input);
            String message = algorithm + " should sort " + testCase.description();
            if (testCase.expected() == null) {
                assertNull(actual, message);
            } else {
                assertArrayEquals(testCase.expected(), actual, message);
            }
        }
    }

    @Test
    void testSelectionSort() {
        assertSortsAllCases(NaiveSort::selectionSort, "selection_sort");
    }

    @Test
    void testBubbleSort() {
        assertSortsAllCases(NaiveSort::bubbleSort, "bubble_sort");
    }

    @Test
    void testInsertionSort() {
        assertSortsAllCases(NaiveSort::insertionSort, "insertion_sort");
    }
}
