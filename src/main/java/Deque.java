public interface Deque<E> {
    void popFront(E element);
    void pushBack(E element);
    E pushFront();
    E popBack();
    E peekFront();
    E peekBack();
    boolean isEmpty();
}