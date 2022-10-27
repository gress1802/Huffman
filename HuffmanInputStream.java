import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HuffmanInputStream {
    private String tree; 
    private int totalChars; 
    private DataInputStream d; 
    String[] paths; //The paths array
    HuffmanTree hufTree; //The huffman tree we will use to decode
    String filename; //the name of the file

    public HuffmanInputStream(String filename) { 
        try { 
            d = new DataInputStream(new FileInputStream(filename)); 
            tree = d.readUTF(); 
            totalChars = d.readInt();
            hufTree = new HuffmanTree(tree, (char)128); //This is the huffman tree we will use to decode
            paths = hufTree.pathsToLeaves();
            this.filename = filename;
        } 
        catch (IOException e) {

        } 
    }

    public int readBit() { 
        //returns the next bit in the file
        //the value returned will be either a 0 or a 1 
        //you will need to read each byte from the file (use readUnsignedByte) 
        //after 8 calls to readBit you will need to read another byte
        int current = 0;
         try {
                current = d.readUnsignedByte();
        } 
        catch (IOException e) { 
        }
        return current; 
    }

    public String getTree() { 
        return tree; 
    } 

    public int getTotalChars() { 
        //return the character count read from the file
        return totalChars; 
    } 

    public void close() { 
        //close the DataInputStream
        try {
            d.close();
        } catch (IOException e) {

        } 
    } 

}



