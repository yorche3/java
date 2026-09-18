package naive_sort;

/**
 * naive_sort — Módulo Naive Sort con ordenamientos elementales.
 *
 * <p>Especificación: 05_Naive_Sort.
 *
 * <p>Contrato de las funciones ({@code int[] -> int[]}), de menor a mayor:
 * <ul>
 *   <li>{@code selectionSort} — encuentra el mínimo del tramo no ordenado y lo ubica al inicio.</li>
 *   <li>{@code bubbleSort}    — compara e intercambia adyacentes, con bandera {@code swapped}.</li>
 *   <li>{@code insertionSort} — inserta cada elemento en su sub-array ordenado.</li>
 * </ul>
 *
 * <p>Caso nulo: en Java un array puede ser {@code null}, así que el indicador de fallo es
 * devolver {@code null} cuando la entrada es {@code null}, sin lanzar excepciones.
 */
public class NaiveSort {
    public static int[] selectionSort(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        if (n <= 1) return arr;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        if (n <= 1) return arr;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        if (arr == null) return null;
        int n = arr.length;
        if (n <= 1) return arr;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
