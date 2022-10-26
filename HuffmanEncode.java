import java.io.*;
import java.util.*;
public class HuffmanEncode {
    
    public String fileIn;
    public String fileOut;
    public static int totalChars; //This is the total amount of characters in the textfile

    public HuffmanEncode(String in, String out) {
        //Implements the main flow of your program 
        //in is the name of the source file 
        //out is the name of the output file
        //Add private methods and instance variables as needed

        fileIn = in;
        fileOut = out;


        try{
            FileReader fr = new FileReader(in);
            BufferedReader br = new BufferedReader(fr);
            BinaryHeap builder = new BinaryHeap(128);
            //Creation of another set of parallel arrays
            int[] priority = new int[128];
            HuffmanTree[] tree = new HuffmanTree[128];
            
            addHeap(br, priority, tree, builder); //This is a method that adds the priorities and trees to the heap

            HuffmanTree hufTree = buildHuffman(builder); //This is the huffman tree we will use for encoding/decoding
            br.close();//closing the buffered reader
    
            BufferedReader brNew = new BufferedReader(fr); //new BufferedReader so that we can start the encoding process
            String[] paths = hufTree.pathsToLeaves();


            HuffmanOutputStream output = new HuffmanOutputStream(out);
            while(brNew.ready()){
                int charIndex = brNew.read(); //This is the index we will use to get the correct encoding
                String sPath = paths[charIndex]; //This is what will be wrote to the binary file
                byte[] byteArray = sPath.getBytes("UTF-8");
                
            } 


        }catch(IOException e){
            System.out.println("File not found");
        }
    }

    public void writeToFile(BufferedReader brNew, String[] paths, String out){
        try{
            while(brNew.ready()){
                String filename = out;
                char toWrite = (char)brNew.read();
            }
        }catch(IOException e){ 

        }
    }

    
    public static HuffmanTree buildHuffman(BinaryHeap builder){ //This is a method that build a huffman tree from a binary heap
        while(builder.size != 1){

            HuffmanTree left = builder.getMinTree();
            int leftPriority = builder.getMinPriority();

            builder.removeMin();

            HuffmanTree right = builder.getMinTree();
            int rightPriority = builder.getMinPriority();

            builder.removeMin();

            int nPriority = leftPriority+rightPriority;
            HuffmanTree n = new HuffmanTree(left, (char)128, right);
            builder.insert(nPriority, n);
        }
        return builder.getMinTree();
    }


    public static void addHeap(BufferedReader br, int[] priority, HuffmanTree[] tree, BinaryHeap builder){
        try{
            while(br.ready()){ //traverses through the text file recording the priorities and trees in the arrays
                int index = br.read();
                HuffmanTree add = new HuffmanTree((char)index);
                tree[index] = add; //Adding the huffman tree to its correct ascii index
                priority[index]++;
                totalChars = totalChars + 1;
            }

            for(int x = 0; x<priority.length;x++){ //This loop adds the parallel arrays to the binary heap
                builder.insert(priority[x],tree[x]);
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }


    



    public static void main(String args[]) {
//        args[0] is the name of the source file 
//        args[1] is the name of the output file
        new HuffmanEncode(args[0], args[1]);
        //do not change anything here

/*         try{
            FileReader fr = new FileReader("./test.txt");
            BufferedReader br = new BufferedReader(fr);
            BinaryHeap builder = new BinaryHeap(128);
            //Creation of another set of parallel arrays
            int[] priority = new int[128];
            HuffmanTree[] tree = new HuffmanTree[128];
            
            addHeap(br, priority, tree, builder); //This is a method that adds the priorities and trees to the heap

            HuffmanTree hufTree = buildHuffman(builder);

            System.out.println(hufTree);

            for(int x = 0; x<priority.length;x++){
                System.out.println(priority[x]);
            } 



        }catch(FileNotFoundException e){
            System.out.println("File not found");
        } */
    }
}
