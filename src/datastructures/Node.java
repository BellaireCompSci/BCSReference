package datastructures;

public class Node
{
    int val = 0;
    public Node left;
    public Node right;
    /**
     * Constructor for objects of class Node
     */
    public Node(int value){
        val=value;
        right = null;
        left=null;
    }
    public String toString(){
        return ""+val;
    }
}