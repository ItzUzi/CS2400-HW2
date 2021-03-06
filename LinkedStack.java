import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{

    private Node<T> topNode = new Node<T>();

    public LinkedStack(){
        topNode = null;
    }

    /**
     * New node references the top node
     * Make the new node the top node
     * @param newEntry pushed on top of stack
     */
    public void push(T newEntry) {
        Node<T> newNode = new Node<T>(newEntry, topNode);
        topNode = newNode;
    }

    /**
     * pops out top entry
     * @return top entry
     */
    public T pop() {
        T top = peek();
        topNode = topNode.getNextNode();
        return top;
    }

    /**
     * peeks at top entry
     * @return topEntry
     * @throws EmptyStackException if stack is empty
     */
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    /**
     * checks if stack is empty
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Clears all entries from Stack
     */
    public void clear() {
        topNode = null;     
    }
    
}