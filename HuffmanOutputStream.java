import java.io.*; 
public class HuffmanOutputStream { 
    
    
    private DataOutputStream d; 
    public byte write = 0; //This is the byte that is filled up and eventually written
    public int count = 0; //counter variable
    public int amtBytes; //bytes that will be written out

    public HuffmanOutputStream(String filename, String tree, int totalChars) { 
        try { 
            d = new DataOutputStream(new FileOutputStream(filename)); 
            d.writeUTF(tree);
            d.writeInt(totalChars);
        } 
        catch (IOException e) { 
            System.out.println("Error");
        } 
    }
    public void writeBit(char bit) { 
        //PRE:bit == '0' || bit == '1' 
        //You need to fill a byte with bits and after every 8 calls to writeBit 
        //you must write the byte to the file
        try{
            System.out.println(bit);
            if(bit == 0){
                amtBytes = (amtBytes<<2) + 0;//This is the case where our array is null AKA (char)0
            }else{
                int x = bit - '0'; // gives us either 0 or 1
                amtBytes = (amtBytes<<2) + x; // this shifts amtBytes to the left
            }
            count++; //increment

            if(count == 8){ //8 is a full byte
                count = 0; //reset the counter
                d.writeByte(amtBytes);
                amtBytes = 0; //reset amtBytes
                
            }
        } 
        
        catch (IOException e) { 
            System.out.println("Error");
        }   
    }

    public void close(){ 
        //write final byte (if needed); 
        //close the DataOutputStream
         try { 
            if(write != 0){
                d.writeByte(write);
            }
            d.close();
        } 
        catch (IOException e) { 
            System.out.println("Error");
        } 
    } 
}

