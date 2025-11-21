public class Stack<T> {

    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size >= data.length) {
            throw new RuntimeException("Stack overflow: no space to push new element.");
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack underflow: cannot pop from empty stack.");
        }
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty: nothing to peek.");
        }
        return data[size - 1];
    }
}
