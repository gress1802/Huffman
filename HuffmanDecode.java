import java.io.BufferedWriter;
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
            FileWriter fw = new FileWriter(out);
            BufferedWriter bw = new BufferedWriter(fw);
            while(countChars < totalChars){
                fw.write((char)input.readBit());
                countChars++;
            }
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


