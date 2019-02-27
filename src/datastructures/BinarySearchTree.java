package datastructures;

import java.util.*;

public class BinarySearchTree {
    Node root;

    /**
     * visualize a binary search tree idk how to explain it
     */
    private Node addMethod(Node current, int value) {
        if (current == null)
            return new Node(value);
        if (value < current.val) {
            current.left = addMethod(current.left, value); // less is left
        } else if (value > current.val) {
            current.right = addMethod(current.right, value); // more is... right
        } else {
            return current; // already there
        }
        return current;
    }

    public void add(int value) {
        root = addMethod(root, value);
    }

    private boolean containsNodeMethod(Node current, int value) {
        if (current == null) // this node is dead end
            return false;
        if (value == current.val) // yay we found it
            return true;
        return value < current.val ? containsNodeMethod(current.left, value)
                : containsNodeMethod(current.right, value);
        // if it's less go left, if its more go right
    }

    public boolean containsNode(int value) {
        return containsNodeMethod(root, value);
    }

    private Node deleteNodeMethod(Node current, int value) {
        if (current == null)
            return null;
        if (value == current.val) {
            if (current.right == null && current.left == null) {
                return null;
            } else if (current.right == null)
                return current.left;
            else if (current.left == null)
                return current.right;
            else {
                int smallestValue = findSmallestValue(current.right);
                current.val = smallestValue;
                current.right = deleteNodeMethod(current.right, smallestValue);
                return current;
                // complicated stuff something to do with switching the
                // smallest value to the current node and setting the right
                // node to the second smallest value and recursively going on
            }
        }
        if (value < current.val) {
            current.left = deleteNodeMethod(current.left, value);
            return current;
        }
        current.right = deleteNodeMethod(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.val : findSmallestValue(root.left);
    }

    public Node findSmallestNode(Node root) {
        return root.left == null ? root : findSmallestNode(root.left);
    }

    public void delete(int value) {
        root = deleteNodeMethod(root, value);
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
        // preorder will go from all the left parts of the subtree to the right
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.val);
            traverseInOrder(node.right);
        }
        // inorder will be sorted
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.val);
        }
        // ???? look up what it does you'll prob never use it
    }

    public void BFS() {
        if (root == null)
            return;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(" " + node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        // start from the top node and go in lines like building a pyramid but starting at the top
    }

}
