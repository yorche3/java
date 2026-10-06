package data_structures_basics;

// stack — pila LIFO construida a mano sobre Node.
// Especificación: 06_Data_Structures_Basics.
// Contrato del paso 4b: firmas con el cuerpo en su indicador natural; el algoritmo
// es del paso 5 y la suite, del 4c.
//
// Indicadores: pop y peek devuelven -1 si la pila está vacía, isEmpty false y size 0.
//
// El init del contrato es el constructor: new Stack() es la pila vacía.
public class Stack {
    private Node top;
    private int count;

    // Stack(): pila vacía, tope ausente y contador a cero (init).
    public Stack() {
        this.top = null;
        this.count = 0;
    }

    // push: apila el valor sobre el tope.
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(this.top);
        this.top = newNode;
        this.count++;
    }

    // pop: extrae y devuelve el tope, o -1 si la pila está vacía.
    public int pop() {
        if (this.top == null) {
            return -1;
        }
        int value = this.top.getValue();
        this.top = this.top.getNext();
        this.count--;
        return value;
    }

    // peek: observa el tope sin extraerlo, o -1 si la pila está vacía.
    public int peek() {
        return this.top != null ? this.top.getValue() : -1;
    }

    // isEmpty: informa si la pila no tiene nodos.
    public boolean isEmpty() {
        return this.count == 0;
    }

    // size: número de nodos de la pila.
    public int size() {
        return this.count;
    }
}
