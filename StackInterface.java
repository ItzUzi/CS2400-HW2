public interface StackInterface<T> {

    /**
     * Pushes new Entry onto top of stack
     * @param newEntry to be pushed on to stack
     */
    public void push(T newEntry);
 
    /**
     * Pops top entry from stack
     * @return top entry
     */
    public T pop();

    /**
     * Peeks at top entry in stack
     * @return top entry
     */
    public T peek();

    /**
     * Checks if stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this stack
     */
    public void clear();
}