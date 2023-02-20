package routeBetweenNodes;

public class Node<T> {

    protected T val;
    protected Node<T>[] children;

    public Node(T val, int children) {
        this.val = val;
        this.children = new Node[children];
    }
}
