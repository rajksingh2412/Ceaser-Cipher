
/**
 * Write a description of Caesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Caesar {
        
    public String encrypt(String input , int key1,int key2){
    
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String shiftedKey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedKey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        //System.out.println(shiftedKey1);
        //System.out.println(shiftedKey2);
        for ( int k=0 ; k< encrypted.length() ;k++){
            
            char currChar = input.charAt(k);
           
            char ch =Character.toLowerCase(currChar);
         
            int idx = alphabet.indexOf(ch);
            
           // System.out.println(Character.isUpperCase(currChar));
           
           if ((k+1)%2 !=0 ){
             encrypted=convert( shiftedKey1 , idx, currChar,encrypted,k);
            
            }
            else encrypted=convert( shiftedKey2 , idx, currChar,encrypted,k);
           
        }
          return encrypted.toString();
    }
  
    public StringBuilder convert(String shifted , int idx,char currChar,StringBuilder encrypted,int k){
    
     if ( idx != -1){
                if(Character.isUpperCase(currChar)) {
                    //System.out.println("*");
                    char newChar = Character.toUpperCase(shifted.charAt(idx));
                    encrypted.setCharAt(k,newChar);
                    
                }
                else {
                char newChar = shifted.charAt(idx);
                encrypted.setCharAt(k,newChar);
                }
            } 
            return encrypted ;
    }
    
    
    public void test(){
    
        int key1 = 9;
        int key2 = 22;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
        String encrypted = encrypt(message , key1,key2);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted ,26-key1,26-key2);
        System.out.println(decrypted);
        
    
    }
}
