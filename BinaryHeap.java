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
     
    public BinaryHeap(int s) {
        priority = new int[s+1];
        trees = new HuffmanTree[s+1];
        size = 0;
    }

    public void removeMin() {
        //PRE: size != 0
        //removes the priority and tree at the root of the heap
        int ret = Integer.MAX_VALUE;
        int index = 0;
        for(int x = 0; x<priority.length; x++){ //This loop finds the smallest priority in the array and saves its index
            if(priority[x] < ret && priority[x] != 0){
                ret = priority[x];
                index = x;
            }
        }
        if(index == size-1){ //case where the minimum value in the array is the last value
            priority[index] = 0;
            trees[index] = null;
            size--;
            return;
        }else{ //if the minimum value is somewhere that isnt the last value

            //removing from priority[]
            priority[index] = 0; //setting the minimum value to 0 (removing it)
            priority[index] = priority[size - 1]; //filling that spot in with the last element of the array
            priority[size - 1] = 0; //removing the last element in the array

            //same thing but on the other parallel array
            trees[index] = null;
            trees[index] = trees[size - 1];
            trees[size - 1] = null;
            size--;
        }
    }
    
    public int getMinPriority() {
        //PRE: size != 0
        //return the priority in the root of the heap

        int ret = Integer.MAX_VALUE; //very large value
        for(int x = 0; x<priority.length; x++){ //This loop finds the smallest priority in the array
            if(priority[x] < ret && priority[x] != 0){
                ret = priority[x];
            }
        }
        return ret;

        
    }
    
    public HuffmanTree getMinTree() {
        //PRE: size != 0
        int ret = Integer.MAX_VALUE;
        int index = 0;
        for(int x = 0; x<priority.length; x++){ //This loop finds the smallest priority in the array and saves its index
            if(priority[x] < ret && priority[x] != 0){
                ret = priority[x];
                index = x;
            }
        }
        //with the index of the lowest priority we can find the lowest tree
        return trees[index];

    }

    public boolean full() {
        //return true if the heap is full otherwise return false
        if(size == priority.length-1) return true;
        return false;
    }

    public void insert(int p, HuffmanTree t) {
        //insert the priority p and the associated tree t into the heap
        //PRE !full()

        for(int x = 0; x<priority.length; x++){ //searches for the next 0 (empty value) in the array
            if(priority[x] == 0){
                priority[x] = p;
                trees[x] = t;
                size++;
                return; //breaking out of method
            }
        }

        
    }

    public int getSize() {
        //return the number of values, (priority , tree) pairs, in the heap
        return size;
    }

}

    

