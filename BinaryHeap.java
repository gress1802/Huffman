public class BinaryHeap {
    //implements a binary heap where the heap rule is the value in the parent 
    //node is less than
    //or equal to the values in the child nodes
    
    //the implementation uses parallel arrays to store the priorities and the 
    // trees. This is un-java like but I want you to have practice with 
    //parallel arrays. you must use this implementation
    public int priority[];
    public HuffmanTree trees[];
    public int size;
    public int place;
     
    public BinaryHeap(int s) {

        priority = new int[s+1];
        trees = new HuffmanTree[s+1];
        size = 0;
    }

    public void removeMin() {
        //PRE: size != 0
        //removes the priority and tree at the root of the heap
        priority[1] = priority[size]; //moving last position to first position
        trees[1] = trees[size];
        priority[size] = 0; //reseting last position
        trees[size] = null;
        size--; //updating size

        helper(1);
    }

    public void helper(int first){
        if(first*2 > priority.length) return;//if the child of the position first results in outside of array
        if(trees[first*2] == null) return;//if the position we are at has no left child (This is the end of the heap)

        if(trees[first*2+1] == null){//this is for if there is a left child but not a right child
            if(priority[first*2] < priority[first]){//priority of left child is less than that of right (swap parent with left child)
                helperHelper(first, 0);
                return;
            }
            return; //returning
        }
        //This is for if the left and right child are both greater than their parent. We do nothing
        if(priority[first] < priority[(first*2)+1] && priority[first] < priority[first*2]) return;

        if(priority[(first*2)+1] > priority[first*2]){
            helperHelper(first, 0);
            helper(first*2);
            return;
        }else{ //the priority of left is not less than that of the right therefore we need to swap parent and right
            helperHelper(first, 1);
            helper((first*2)+1);
            return;
        }
    }


    private void helperHelper(int first, int x){
        HuffmanTree t = trees[first]; //parent data
        int p = priority[first]; //parent data

        //moving child data to parent
        priority[first] = priority[(first*2)+x]; //x represents whether it is right or left
        trees[first] = trees[(first*2)+x];

        //child to parent
        priority[(first*2)+x] = p;
        trees[(first*2)+x] = t;
    }
    
    public int getMinPriority() {
        //PRE: size != 0
        //return the priority in the root of the heap

        return priority[1];

        
    }
    
    public HuffmanTree getMinTree() {
        //PRE: size != 0
        return trees[1];

    }

    public boolean full() {
        //return true if the heap is full otherwise return false
        if(size == priority.length-1) return true;
        return false;
    }

    public void insert(int p, HuffmanTree t) {
        //insert the priority p and the associated tree t into the heap
        //PRE !full()

        size++;
        int position = size; //this is the position where we will try to insert to

        while(p < priority[position/2]){//while the priority paramenter is less than the parent
            trees[position] = trees[position/2]; //moving parent to child
            priority[position] = priority[position/2];
            position = position/2;
        }

        priority[position] = p; //We have where the new priority will be inserted
        trees[position] = t;
        
    }

    public int getSize() {
        //return the number of values, (priority , tree) pairs, in the heap
        return size;
    }

    public void printPriorities(){
        for(int x = 0; x<priority.length; x++){
            System.out.println(priority[x]);
        }
    }

    public static void main(String[] args){
       BinaryHeap joe = new BinaryHeap(128);
       HuffmanTree a = new HuffmanTree('a');
       HuffmanTree b = new HuffmanTree('b');
       HuffmanTree c = new HuffmanTree('c');
       HuffmanTree d = new HuffmanTree('d');
       joe.insert(1, d);
       joe.insert(1, c);
       joe.insert(0, b);
       joe.insert(1, a);
       joe.printPriorities();
    }

}

    

