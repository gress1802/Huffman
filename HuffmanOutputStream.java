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
            System.out.print(bit);
            amtBytes = (amtBytes<<1) + (bit-'0'); // this shifts amtBytes to the left

            if(count == 7){ //7 is a full byte *****
                count = 0; //reset the counter
                d.writeByte(amtBytes);
                
                amtBytes = 0; //reset amtBytes
                
            }else{
                count++;
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
            System.out.println(count); 
            if(count != 0){ //Finishing off the last byte 
                while(count != 8){
                    amtBytes = (amtBytes<<1) + 0;//this will shift the final bits all the way to the left
                    count++;
                }
                d.writeByte(amtBytes);
            }
            d.close();
        } 
        catch (IOException e) { 
            System.out.println("Error");
        } 
    } 
}

