import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

    private final Object[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public ArrayDeque(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be 1 or higher");
        }

        elements = new Object[capacity];
    }

    @Override
    public void popFront(E element) {
        if (numberOfElements == elements.length) {
            throw new IllegalStateException("The deque is full");
        }
        headIndex = decreaseIndex(headIndex);
        elements[headIndex] = element;
        numberOfElements++;
    }

    @Override
    public void pushBack(E element) {
        if (numberOfElements == elements.length) {
            throw new IllegalStateException("The deque is full");
        }
        elements[tailIndex] = element;
        tailIndex = increaseIndex(tailIndex);
        numberOfElements++;
    }

    @Override
    public E pushFront() {
        E element = elementAtHead();
        elements[headIndex] = null;
        headIndex = increaseIndex(headIndex);
        numberOfElements--;
        return element;
    }

    @Override
    public E popBack() {
        E element = elementAtTail();
        tailIndex = decreaseIndex(tailIndex);
        elements[tailIndex] = null;
        numberOfElements--;
        return element;
    }

    @Override
    public E peekFront() {
        return elementAtHead();
    }

    @Override
    public E peekBack() {
        return elementAtTail();
    }

    private E elementAtHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("unchecked")
        E element = (E) elements[headIndex];

        return element;
    }

    private E elementAtTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        @SuppressWarnings("unchecked")
        E element = (E) elements[decreaseIndex(tailIndex)];

        return element;
    }

    private int decreaseIndex(int index) {
        index--;
        if (index < 0) {
            index = elements.length - 1;
        }
        return index;
    }

    private int increaseIndex(int index) {
        index++;
        if (index == elements.length) {
            index = 0;
        }
        return index;
    }
    private int display(int index) {

        index = elements.length;

        return index;
    }
    private int size(int index) {

        index = elements.length;

        return index;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
}