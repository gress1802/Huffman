import java.io.*; 
public class HuffmanOutputStream { 
    
    
    private DataOutputStream d; 
    public HuffmanOutputStream(String filename) { 
        try { 
            d = new DataOutputStream(new FileOutputStream(filename)); 
        
        } 
        catch (IOException e) { 

        } 
    }
    public void writeBit(char bit) { 
        //PRE:bit == '0' || bit == '1' 
        //You need to fill a byte with bits and after every 8 calls to writeBit 
        //you must write the byte to the file
        try { 
            d.writeByte(bit);
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

