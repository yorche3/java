package data_structures_basics;

// linked_list — lista enlazada construida a mano sobre Node.
// Especificación: 06_Data_Structures_Basics.
// Contrato del paso 4b: firmas con el cuerpo en su indicador natural; el algoritmo
// es del paso 5 y la suite, del 4c.
//
// Indicadores: getHead devuelve -1 si la lista está vacía, delete false cuando el
// valor no está, isEmpty false y size 0.
//
// El init del contrato es el constructor: new LinkedList() es la lista vacía.
public class LinkedList {
    private Node head;
    private Node tail;
    private int count;

    // LinkedList(): lista vacía, cabeza y cola ausentes y contador a cero (init).
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // getHead: valor de la cabeza, o -1 si la lista está vacía.
    public int getHead() {
        return -1;
    }

    // insertHead: inserta el valor al principio de la lista.
    public void insertHead(int value) {
    }

    // insertTail: inserta el valor al final de la lista.
    public void insertTail(int value) {
    }

    // delete: elimina la primera aparición del valor; false cuando no está.
    public boolean delete(int value) {
        return false;
    }

    // isEmpty: informa si la lista no tiene nodos.
    public boolean isEmpty() {
        return false;
    }

    // size: número de nodos de la lista.
    public int size() {
        return 0;
    }
}
