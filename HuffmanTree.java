import java.util.*;
public class HuffmanTree {
    //DO NOT include the frequency or priority in the tree
    private class Node {
        private Node left;
        private char data;
        private Node right;
        private Node(Node L, char d, Node R) {
            left = L;
            data = d;
            right = R;
        }
    }

    private Node root;
    private Node current; //this value is changed by the move methods
    public char nonLeaf;

    public HuffmanTree() {
        root = null;
        current = null;
    }

    public HuffmanTree(char d) {
        //makes a single node tree
        root = new Node(null,d,null);
    }

    public HuffmanTree(String t, char nonLeaf) {
        this.nonLeaf = nonLeaf;
        Stack<HuffmanTree> postorderStack = new Stack<HuffmanTree>();
        for(int x = 0;x<t.length();x++){
            if(t.charAt(x) != nonLeaf){
                HuffmanTree z = new HuffmanTree(t.charAt(x));
                postorderStack.push(z);
            }else{ //t.charAt(x) == nonLeaf
                HuffmanTree z = new HuffmanTree(t.charAt(x));
                postorderStack.push(z);
                postorderStack.pop();
                HuffmanTree b1 = postorderStack.pop();
                HuffmanTree b2 = postorderStack.pop();
                HuffmanTree tree = new HuffmanTree(b2,nonLeaf,b1);
                postorderStack.push(tree);
            }
        }
        HuffmanTree ret = postorderStack.pop();
        this.root = ret.root;
         
        //Assumes t represents a post order representation of the tree as discussed 
        //in class
        //nonLeaf is the char value of the data in the non-leaf nodes
        //in the following I will use (char) 128 for the non-leaf value

    }

    public HuffmanTree(HuffmanTree b1, char d, HuffmanTree b2) {
        //makes a new tree where b1 is the left subtree and b2 is the right subtree
        //d is the data in the root. Do not make a copy of b1 and b2
        this.root = new Node(b1.root,d,b2.root);
    }

    //the move methods to traverse the tree
    //the move methods change the value of current
    //use these in the decoding process

    public void moveToRoot() {
        //change current to reference the root of the tree
        current = root;
    }

    public void moveToLeft() {
        //PRE: the current node is not a leaf
        //change current to reference the left child of the current node
        current = current.left;
    }

    public void moveToRight() {
        //PRE: the current node is not a leaf
        //change current to reference the right child of the current node
        current = current.right;
    }

    public boolean atRoot() {
        //returns true if the current node is the root otherwise returns false
        if(current == root) return true;
        return false;
    }

    public boolean atLeaf() {
        //returns true if current references a leaf other wise returns false
        if(current.left == null && current.right == null) return true;
        return false;
    
    
    }

    public char current() {
        //returns the data value in the node referenced by current
        return current.data;
    
    
    }

    public String[] pathsToLeaves() { 
        /*returns an array of 128 strings (some of which could be null) with all paths from the root to the leaves
        Each string will be a string of 0s and 1s. Store the path for a particular leaf in the array 
        at the location of the leaf value’s character code 
        */
        String[] ret = new String[128];
        pathsHelper("",root,ret); 
        return ret;
    }

    public void pathsHelper(String x, Node r, String[] ret){ //recursive helper method for pathsToLeaves()

        if(r.left == null && r.right == null){ //When we are at a leaf
            int d = r.data; //this converts the character to its integer value
            ret[d] = x; //sets the character integer value index of the String[] array to the path value created below
            return;
        }

        pathsHelper(x + "0", r.left, ret);
        pathsHelper(x + "1", r.right, ret);

    }


    public String toString() {
        //returns a string representation of the tree using the postorder format 
        // discussed in class
        String ret = String.format("");
        Queue<Character> list = new ArrayDeque<Character>(); //Using a FIFO Queue to store the values 
        toStringHelper(root, list);
        int size = list.size(); 
        for(int x = 0; x<size; x++){ //for loop to iterate through the Queue and store the values in a string to be returned
            ret = ret + list.poll();
        }
        return ret;
    }

    public void toStringHelper(Node r, Queue<Character> j){ //recursive helper method for toString
        if(r != null){ //basic postorder representation algorithm
            toStringHelper(r.left, j);
            toStringHelper(r.right, j);
            j.add(r.data);
        }
    }

    public static void main(String[] args){
        
    }
}


