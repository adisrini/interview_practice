package ch4.treesandgraphs.practice;

import ch4.treesandgraphs.implementations.BinaryTreeNode;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary 
 * search tree with minimal height.
 * 
 * @author Aditya Srinivasan
 *
 */
public class MinimalTree {

    //
    // We're given a sorted array with unique integer elements and told to make a binary search tree with minimal height
    // A binary search tree means the left subtree of each node must be less than the node value, and the right subtree
    // must be greater than the node value. Since there are no duplicates, there is no case for equal numbers.
    //
    // By this, it would make the most sense to start in the middle and then recursively work with each half.
    //
    // Suppose we had the array 1 2 3. The middle element, 2, would become the root. The middle of the left half, 1, becomes
    // it's left child and the middle of the right half becomes it's right child. Then it ends since we've visited all nodes.
    //
    // What about 1 2 3 4 5? The middle element, 3, becomes the root. There is no middle element of either subtree, so we just
    // round up. The root of our left subtree becomes 2 and the root of our right subtree becomes 5. Then, we look at either side
    // and take those elements and make them the left children. Then the entire array has been sorted.
    //
    // What about 1 2 3 4? There is no middle element so we can just round up, giving 3 as the root. Then the right child is 4
    // and the left child is 2. Then 2's left child is 1.
    //
    // So, what is our base case? Our base case is when we've visited every item in the array.
    //
    
    public static BinaryTreeNode<Integer> create(int[] array) {
        return createHelper(array, 0, array.length - 1);
    }
    
    public static BinaryTreeNode<Integer> createHelper(int[] array, int start, int end) {
        if(start == end) return new BinaryTreeNode<Integer>(array[start]);
        if(start > end) return null;
        
        int middleIndex = (int) Math.ceil(end + start)/2;
        int middle = array[middleIndex];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(middle);
        
        root.left = createHelper(array, start, middleIndex - 1);
        root.right = createHelper(array, middleIndex + 1, end);
        
        return root;
    }
    
    // 1 2 3 4
    //
    // start = 0, end = 3
    // middleIndex = Math.ceil(1.5) = 2
    // middle = array[2] = 3
    // root = new Node(3);
    // root.left = call(array, start = 0, start = 1);
    //           -> middleIndex = Math.ceil(0.5) = 1
    //           -> middle = array[1] = 2;
    //           -> root =  new Node(2);
    //           -> root.left = call(array, 0, 0)
    //                        -> return new Node(1);
    //           -> root.right = call(array, 2, 1);
    //                        -> return null;
    //           -> return Node(2);
    // root.left = Node(2) where left is 1, right is null
    // root.right = call(array, start = 3, end = 3);
    //           -> return new Node(4);
    //
    //              3
    //             / \
    //            /   \
    //           2     4
    //          /
    //         1
    //
    
    // 1 2 3 4 5 6 7   ->           4
    //                             / \
    //                            /   \
    //                           2     6
    //                          / \   / \
    //                         1   3 5   7
    // start = 0, end = 6
    // middleIndex = 3
    // middle = array[3] = 4
    // root = new Node(4);
    // root.left = call(array, start = 0, end = 2)
    //           -> middleIndex = 1
    //           -> middle = array[1] = 2
    //           -> root = new Node(2);
    //           -> root.left = call(array, start = 0, end = 0)
    //                        -> return new Node(1);
    //           -> root.right = call(array, start = 2, end = 2)
    //                        -> return new Node(3);
    //           -> return Node(2);
    // root.left = 2, where 2.left = 1, 2.right = 3
    // root.right = ... same process
    //
    //
    
    private static void inorder(BinaryTreeNode<Integer> root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = MinimalTree.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        MinimalTree.inorder(root);
    }
    
}