import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T>{

    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 50;
    
    public ResizeableArrayStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public ResizeableArrayStack(int size){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[size];
        stack = tempStack;
        topIndex = -1;
    }
    
    /**
     * Pushes entry to top of stack
     * @param anEntry entry to be pushed to top of stack
     */
    public void push(T newEntry) {
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    /**
     * Doubles capacity of stack if stack is full
     */
    private void ensureCapacity(){
        if(topIndex >= stack.length - 1){
            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    /**
     * Takes out top entry from stack
     * @return Entry at top of stack
     */
    public T pop() {
        T top = peek();
        stack[topIndex] = null;
        topIndex--;
        return top;
    }

    /**
     * Returns top entry from stack without
     * removing the object
     * @return object at top of stack
     */
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    }

    /**
     * Checks if stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /**
     * clears stack from all entries
     */
    public void clear() {
        for(;topIndex > -1;topIndex--)
            stack[topIndex] = null;
    }
    
}
