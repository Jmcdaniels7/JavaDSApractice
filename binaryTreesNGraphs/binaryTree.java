
// we add Comparable<T> to be able to compare templated types
public class binaryTree<T extends Comparable <T>> {
    
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

    Node<T> root;

    binaryTree() {
        root = null;
    }

    public void insert(T value)
    {
        root = recursInsert(root, value);

    }

    //utilizing recursion we either create a root or we add to the left or right node 
    private Node<T> recursInsert(Node<T> root, T value)
    {
        //creates a root
        if(root == null)
        {
            root = new Node<T>(value);
            return root;
        }

        // we recursively call an insert to manage if we want a new left or right node
        // left is less than current node
        if(value.compareTo(root.data) < 0)
        {
            root.left = recursInsert(root.left, value);
        }
        //right is greater than current node
        else if(value.compareTo(root.data) > 0)
        {
            root.right = recursInsert(root.right, value);
        }

        return root;

    }

    public void inorderTrav(Node<T> node)
    {
        inorderRecurs(root);
        System.out.println();
    }

    //this goes as deep as we can to the left and then goes back up to each node and 
    //asks if there is a right node to visit until we reach the root and then we do 
    //the same on the right side
    private void inorderRecurs(Node<T> node) {
        if (node != null) {
            inorderRecurs(node.left);
            System.out.print(node.data + " -> ");
            inorderRecurs(node.right);
        }
    }

    public void preOrderTrav(Node<T> node)
    {
        preorderRecurs(node);
        System.out.println("");
    }

    private void preorderRecurs(Node<T> node)
    {
        if(node != null)
        {
            System.out.print(node.data + " -> ");
            preorderRecurs(node.left);
            preorderRecurs(node.right);
        }
    }

    public void postOrderTrav(Node<T> node)
    {
        postorderRecurs(node);
        System.out.println("");
        
    }

    private void postorderRecurs(Node<T> node)
    {
        if(node != null)
        {
            postorderRecurs(node.left);
            postorderRecurs(node.right);
            System.out.print(node.data + " -> ");
        }

    }
}
