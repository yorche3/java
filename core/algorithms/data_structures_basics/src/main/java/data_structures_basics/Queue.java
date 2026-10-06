package data_structures_basics;

// queue — cola FIFO construida a mano sobre Node.
// Especificación: 06_Data_Structures_Basics.
// Contrato del paso 4b: firmas con el cuerpo en su indicador natural; el algoritmo
// es del paso 5 y la suite, del 4c.
//
// Indicadores: dequeue y peek devuelven -1 si la cola está vacía, isEmpty false y
// size 0.
//
// El init del contrato es el constructor: new Queue() es la cola vacía.
public class Queue {
    private Node front;
    private Node rear;
    private int count;

    // Queue(): cola vacía, frente y final ausentes y contador a cero (init).
    public Queue() {
        this.front = null;
        this.rear = null;
        this.count = 0;
    }

    // enqueue: añade el valor por el final de la cola.
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
        this.count++;
    }

    // dequeue: extrae y devuelve el frente, o -1 si la cola está vacía.
    public int dequeue() {
        if (this.front == null) {
            return -1;
        }
        int value = this.front.getValue();
        this.front = this.front.getNext();
        if (this.front == null) {
            this.rear = null;
        }
        this.count--;
        return value;
    }

    // peek: observa el frente sin extraerlo, o -1 si la cola está vacía.
    public int peek() {
        return this.front != null ? this.front.getValue() : -1;
    }

    // isEmpty: informa si la cola no tiene nodos.
    public boolean isEmpty() {
        return this.count == 0;
    }

    // size: número de nodos de la cola.
    public int size() {
        return this.count;
    }
}
