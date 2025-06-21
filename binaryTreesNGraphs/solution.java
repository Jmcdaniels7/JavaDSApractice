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

        /* current tree
                  57
               /      \
            17          75
          /   \        /   \
        12    21      58    89
                \
                 25
         
         
         Inorder Traverse:
          DFS to the left most node and comes back up printingeach left node and 
          checks if there is a right node to do dsf to that subtreeuntil it reaches 
          the root node where then it does the same process to the left most nodes 
          of the right side of the tree
        */

        

        

    
    }

}

