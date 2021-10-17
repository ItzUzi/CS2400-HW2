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
    
    public void push(T newEntry) {
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    private void ensureCapacity(){
        if(topIndex >= stack.length - 1){
            int newLength = 2 * stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    public T pop() {
        T top = peek();
        stack[topIndex] = null;
        topIndex--;
        return top;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        for(;topIndex > -1;topIndex--)
            stack[topIndex] = null;
    }
    
}
