import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Currency;

public class HuffmanInputStream {

    private String tree; 
    private int totalChars; 
    private DataInputStream d; 
    public HuffmanTree hufTree; //The huffman tree we will use to decode
    public String filename; //the name of the file
    public int counter = 0; //counter for readBit
    public int currentByte;
    public int[] arrayOfBits;



    public HuffmanInputStream(String filename) { 
        try { 
            d = new DataInputStream(new FileInputStream(filename)); 
            tree = d.readUTF(); 
            totalChars = d.readInt();
            hufTree = new HuffmanTree(tree, (char)128); //This is the huffman tree we will use to decode
            this.filename = filename;
            hufTree.moveToRoot(); //setting current at the root
        } 
        catch (IOException e) {

        } 
    }

    public int readBit() { 
        //returns the next bit in the file
        //the value returned will be either a 0 or a 1 
        //you will need to read each byte from the file (use readUnsignedByte) 
        //after 8 calls to readBit you will need to read another byte
        int ret = 0;
        try {
            if(counter == 0){//the start of a new byte
                currentByte = d.readUnsignedByte(); System.out.println(currentByte);
                //Create an array of the bits in this byte
                arrayOfBits = getBitArray(currentByte);
            }

            ret = arrayOfBits[counter]; //use counter to return the correct bit

            if(counter == 7){
                counter = 0; //Start new byte
            }else{
                counter++; //increment counter
            }
        } catch (IOException e) {} 
        return ret;
    }

    /*
     * This is a method that returns an array of bits representing a number
     * PRE: int number is within range [0,255]
     */

    public static int[] getBitArray(int number){
        assert (0 <= number && number <= 255); //Assertion statement to ensure the number can be contained in 8 bits
        int[] bitArray = new int[8]; //This is the array that will eventually be returned
        for (int i = 7; i >=0; i--) { //Starting by getting the highest bit
            int mask = 1 << i; //setting int mask to 1 shifted to the right i places
            bitArray[7-i] = (number & mask) != 0 ? 1 : 0; //setting the value in bitArray
        }
        return bitArray;
    }

    public String getTree() { 
        return tree; 
    } 

    public int getTotalChars() { 
        //return the character count read from the file
        return totalChars; 
    } 

    public void close(BufferedWriter bw) {//parameter is to be able to write the last char correctly to the file 
        //close the DataInputStream
        try {
            d.close();
        } catch (IOException e) {
        }

        
    } 

}



