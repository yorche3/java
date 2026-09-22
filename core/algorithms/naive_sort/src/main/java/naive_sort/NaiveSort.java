package naive_sort;

// naive_sort — ordenamientos elementales O(n^2) sobre un array de enteros (in-place).
// Especificación: 05_Naive_Sort.
// Contrato: int[] -> int[] de menor a mayor; null si la entrada es null, sin excepciones.
public class NaiveSort {
    // selectionSort: busca el mínimo del tramo no ordenado y lo intercambia con el inicio.
    // input: array de enteros (se ordena in-place)
    // output: el mismo array ordenado; null si la entrada es null
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

    // bubbleSort: compara e intercambia adyacentes, con bandera de salida temprana.
    // input: array de enteros (se ordena in-place)
    // output: el mismo array ordenado; null si la entrada es null
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

    // insertionSort: desplaza cada clave y la inserta en su posición del tramo ordenado.
    // input: array de enteros (se ordena in-place)
    // output: el mismo array ordenado; null si la entrada es null
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
