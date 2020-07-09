
/**
 * Write a description of BreakingCeaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class BreakingCeaser {

    
    public String findE(String message){
        int array[] = new int[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int k=0 ; k< message.length(); k++){
            char currChar = message.charAt(k);
            char ch =Character.toLowerCase(currChar);
            int idx = alphabet.indexOf(ch);
            if (idx != -1){
            
            array[idx] +=1;
            }
        }
        int e =array[0];
        //char ch ;
        int idx =0;
        for(int k=1; k<array.length ; k++){
            if ( array[k] > e ){
                e = array[k];
                idx =k ;
                
            }
            
        }
       // idx=idx+4;
        System.out.println("e is :"+idx);
        String newChar ="";
        
       // System.out.println(newChar);
       if (idx-4 >0){
            idx =idx -4;
            newChar =  alphabet.substring(idx) +alphabet.substring(0,idx) ;
        }
        else{  
            newChar = alphabet.substring(26-idx-1) + alphabet.substring(0,26-idx-1) ;
            
        }
        //String shifted = alphabet.substring(idx) + alphabet.substring(0,idx);
        
        //System.out.println(alphabet);
        //System.out.println(shifted);
        
        return newChar;
    }
    
    
    
    public String decrypt(String shifted,String str){
        
        //System.out.println(str);
        //System.out.println(shifted);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //System.out.println(alphabet);
        StringBuilder data = new StringBuilder(str);
        //String original ="";
        for(int k=0;k<data.length();k++){
            
            char ch = data.charAt(k);
            
            int idx = shifted.indexOf(Character.toLowerCase(ch));
            if ( idx != -1){
            char newChar = alphabet.charAt(idx);
            //System.out.println(newChar);
            data.setCharAt(k,newChar);
            }
            
        }
        System.out.println(data.toString());
        
        
        return data.toString();
    }
    public void starting(){
    
        FileResource fr = new FileResource();
        String message = fr.asString();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        StringBuilder data = new StringBuilder(message);
        String str1= "";
        String str2= "";
        for(int k=0 ; k< data.length() ;k ++){
            
            if ((k+1) % 2 != 0 ) str1 = str1 + message.charAt(k);
            else str2 = str2 + message.charAt(k);
        
            
        }
        String e1 = findE(str1);
        String cr1 =decrypt(e1,str1);
        //System.out.println("==========");
        String e2 = findE(str2);
        String cr2 =decrypt(e2,str2);
        int i=0 ,j=0;
        int flag =0;
        for(int k=0; k <200 ; k++){
            if (alphabet.indexOf(Character.toLowerCase(data.charAt(k))) != -1){
             
                if ( (k+1) %2 != 0 && i<cr1.length()){
                  char  newChar = cr1.charAt(i);
                  data.setCharAt(k,newChar);
                  i +=1;
                  flag=0;
                 }
                 else if( j< cr2.length()) {
                  char  newChar = cr2.charAt(j);
                  data.setCharAt(k,newChar);
                  j +=1;
                  flag=1;
                }
            }
            else{
                if(flag == 0){
                    j +=1;
                }
                if(flag == 1){
                    i +=1;
                }
            }  
                  
            
            
        }
        System.out.println(data.toString());
        
        
        
       // decrypt(message);
    }
}
