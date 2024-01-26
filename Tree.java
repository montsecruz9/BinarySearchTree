public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root ==null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public TreeNode get (int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    //for this methods we need the subtreeRoot
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }
        //this is saying that if the value is less than the root of the subtree we're searching
        // then we wanna move to the subtree's left child
        //at the end we're gonna replace the subtree's left child with whatever the result of the delete is
         if (value < subtreeRoot.getData()) {
             subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
         }
         //same here
         else if (value > subtreeRoot.getData()) {
             subtreeRoot.setRightChild((delete(subtreeRoot.getRightChild(), value)));
         }

         //when we find the value:
         else {
             //Cases 1 and 2: node to delete has 0 or 1 children
             if (subtreeRoot.getLeftChild() == null) {
                 return subtreeRoot.getRightChild();
             }
             else if (subtreeRoot.getRightChild() == null) {
                 return subtreeRoot.getLeftChild();
             }

             //Case 3: node to delete has two children
             //Replace the value in the subtreeRoot node with the smallest value
             //from the right subtree
             subtreeRoot.setData(subtreeRoot.getRightChild().min());

             //Delete the node that has the smallest value in the right subtree
             subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
         }

         return subtreeRoot;

    }

    public int min() {
        if (root == null) {
            //if the tree is empty, the console will return the smallest value you can put into an integer
            return Integer.MIN_VALUE;
        }
        else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            //if the tree is empty, the console will return the highest value you can put into an integer
            return Integer.MAX_VALUE;
        }
        else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}
