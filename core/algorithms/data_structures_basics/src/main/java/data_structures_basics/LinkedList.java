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
        return this.head != null ? this.head.getValue() : -1;
    }

    // insertHead: inserta el valor al principio de la lista.
    public void insertHead(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.count++;
    }

    // insertTail: inserta el valor al final de la lista.
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.count++;
    }

    // delete: elimina la primera aparición del valor; false cuando no está.
    public boolean delete(int value) {
        if (this.head == null) {
            return false;
        }
        if (this.head.getValue() == value) {
            this.head = this.head.getNext();
            if (this.head == null) {
                this.tail = null;
            }
            this.count--;
            return true;
        }
        Node current = this.head;
        while (current.getNext() != null && current.getNext().getValue() != value) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return false;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) {
            this.tail = current;
        }
        this.count--;
        return true;
    }

    // isEmpty: informa si la lista no tiene nodos.
    public boolean isEmpty() {
        return this.count == 0;
    }

    // size: número de nodos de la lista.
    public int size() {
        return this.count;
    }
}
