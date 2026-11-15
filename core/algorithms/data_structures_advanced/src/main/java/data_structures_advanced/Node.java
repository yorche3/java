package data_structures_advanced;

public abstract class Node {

    protected int value;

    protected Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
