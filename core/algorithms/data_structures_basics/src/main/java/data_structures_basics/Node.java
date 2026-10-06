package data_structures_basics;

// node — celda enlazada compartida por LinkedList, Stack y Queue.
// Especificación: 06_Data_Structures_Basics.
// Contrato del paso 4b: tipos nuevos y firmas; el algoritmo es del paso 5.
//
// Indicadores: solo el enlace de un Node puede ser null (getNext); el resto de las
// operaciones devuelve -1 (números), false (banderas) o 0 (contadores).
//
// El init del contrato es el constructor: new Node(value) fija el valor y deja el
// enlace ausente.
public class Node {
    private final int value;
    private Node next;

    // Node(int value): celda con su valor y el enlace ausente (init).
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    // getValue: valor de la celda.
    public int getValue() {
        return value;
    }

    // getNext: enlace de la celda; null cuando está ausente.
    public Node getNext() {
        return next;
    }

    // setNext: actualiza el enlace de la celda.
    public void setNext(Node next) {
        this.next = next;
    }
}
