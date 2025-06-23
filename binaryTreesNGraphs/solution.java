import java.util.*;

public class solution {
    public static void main(String args[]) {

        binaryTree<Integer> tree = new binaryTree<Integer>();

        tree.insert(57);
        tree.insert(75);
        tree.insert(58);
        tree.insert(89);
        tree.insert(17);
        tree.insert(21);
        tree.insert(25);
        tree.insert(12);

        tree.inorderTrav(tree.root);

        tree.preOrderTrav(tree.root);

        tree.postOrderTrav(tree.root);

        /* current tree
                  57
               /      \
            17          75
          /   \        /   \
        12    21      58    89
                \
                 25
         
         
         Inorder Traversal:
          DFS to the left most node and comes back up printingeach left node and 
          checks if there is a right node to do dsf to that subtreeuntil it reaches 
          the root node where then it does the same process to the left most nodes 
          of the right side of the tree.

         Preorder Traversal:
          I believe it is the most commonly used traversal for DFS. We print as we 
          traverse from the node down to the deepest left node and then we go to 
          the deepest right and left nodes of the nodes we already visited if we 
          have right nodes. Then we go back to the root and go down to the first 
          right node and then as deep as we can visiting all the left nodes, then 
          coming back up as we did in the left side of the tree.

         Postorder Traversal:
          DFS to the left most node and then the deepest right node of the left 
          side of the tree, then we come up making sure we visit the deeper nodes
          before nodes closer to the root.
        */

        

        

    
    }

}

