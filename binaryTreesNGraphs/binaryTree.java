

public class binaryTree<T> {
    
    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        Node(T data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    
}
