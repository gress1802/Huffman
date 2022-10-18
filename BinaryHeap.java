public class BinaryHeap {
    //implements a binary heap where the heap rule is the value in the parent 
    //node is less than
    //or equal to the values in the child nodes
    
    //the implementation uses parallel arrays to store the priorities and the 
    // trees. This is un-java like but I want you to have practice with 
    //parallel arrays. you must use this implementation
    int priority[];
    HuffmanTree trees[];
    int size;
    public BinaryHeap(int s) {
        priority = new int[s+1];
        trees = new HuffmanTree[s+1];
        size = 0;
    }

    public void removeMin() {
        //PRE: size != 0
        //removes the priority and tree at the root of the heap
    }
    
    public int getMinPriority() {
        //PRE: size != 0
        //return the priority in the root of the heap
        
    }
    
    public HuffmanTree getMinTree() {
        //PRE: size != 0
        //return the tree in the root of the heap
    }

    public boolean full() {
        //return true if the heap is full otherwise return false
    }

    public void insert(int p, HuffmanTree t) {
        //insert the priority p and the associated tree t into the heap
        //PRE !full()
    }

    public int getSize() {
        //return the number of values, (priority , tree) pairs, in the heap
    }
}

    

