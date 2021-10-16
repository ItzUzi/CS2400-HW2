public class Node <T> {
    private T data;
    private Node<T> next;

    public Node(){
        this(null);
    }

    public Node(T value){
        this(value, null);
    }
    public Node(T value, Node<T> ret){
        data = value;
        next = ret;
    }

    public void setNextNode(Node<T> firstNode) {
        this.next = firstNode;
    }

    public Node<T> getNextNode() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}