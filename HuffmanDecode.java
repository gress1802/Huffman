import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanDecode {
    public HuffmanDecode(String in, String out) { 
        //implements the Huffman Decode Algorithm
        //Add private methods and instance variables as needed

        HuffmanInputStream input = new HuffmanInputStream(in);

         try {
            int countChars = 0;
            int totalChars = input.getTotalChars();
            FileWriter fw = new FileWriter(out, true);
            BufferedWriter bw = new BufferedWriter(fw);
            while(countChars < totalChars){
                if(input.hufTree.atLeaf()){//In this case we write the leaf char and start over
                    char toWrite = input.hufTree.current();
                    bw.write(toWrite);
                    input.hufTree.moveToRoot(); //moving back to the root so we can read a new bit
                    countChars++;

                }else{ //We keep reading bits and moving to the left or right until we hit a leaf
                    int inp = input.readBit();

                    if(countChars == totalChars - 1){
                        System.out.println("Joe");
                    }

                    if(inp == 0){//Move to the left
                        input.hufTree.moveToLeft();
                    }else{//Move to the right
                        input.hufTree.moveToRight();
                    }
                }
            }
            input.close(bw);
            bw.close();
            //Now writing the last bit
        } catch (IOException e) { 

        }
    } 
    public static void main(String args[]) { 
        //args[0] is the name of a input file (a file created by Huffman Encode)
        //args[1] is the name of the output file for the uncompressed file
//        new HuffmanDecode(args[0], args[1]);
        HuffmanDecode dec = new HuffmanDecode("output.bin", "output2.txt");
        //do not add anything here
    }
}


