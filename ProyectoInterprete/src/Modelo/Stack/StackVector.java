package Modelo.Stack;
import java.util.EmptyStackException;
import java.util.Vector;

public class StackVector<E> implements IStack {
    protected Vector<E> data = new Vector<E>(1);

    /*
     * Add new element to top
     */
    @Override
    public void push(Object item) {
        data.addElement((E) item);
    }

    /*
     * Remove last element pushed and return value
     */
    @Override
    public E pop() throws EmptyStackException {
        return data.remove(data.size() - 1);
    }

    /*
     * Return last element pushed
     */
    @Override
    public E peek() throws EmptyStackException {
        return data.lastElement();
    }

    /*
     * Return true if stack is empty
     */
    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    /*
     * Returns the size of stack
     */
    @Override
    public int size() {
        return data.size();
    }
}
