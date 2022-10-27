import java.io.*; 
public class HuffmanOutputStream { 
    
    
    private DataOutputStream d; 
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
    public void writeBit(byte bit) { 
        //PRE:bit == '0' || bit == '1' 
        //You need to fill a byte with bits and after every 8 calls to writeBit 
        //you must write the byte to the file
        try { 
            if(bit == 0){
                byte toWrite = 0<<0;
                d.writeByte(toWrite);
            }else{
                byte toWrite = 1<<0;
                d.writeByte(toWrite);
            }
        } 
        
        catch (IOException e) { 
            System.out.println("Error");
        }   
    }

    public void close(){ 
        //write final byte (if needed); 
        //close the DataOutputStream
/*         try { 

        } 
        catch (IOException e) { 
            System.out.println("Error");
        } */
    } 
}

