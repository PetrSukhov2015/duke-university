package level3.cc;
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        
        boolean low;
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
        	low=false;
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            if ( Character.isLowerCase(currChar) ){low=true;}
            currChar = Character.toUpperCase(currChar);
            
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if (low){newChar = Character.toLowerCase(newChar);}
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 15;
        //FileResource fr = new FileResource("D:\\duke\\level3\\CaesarCipher\\message1.txt");
        //String message = fr.asString();
        String message="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        //String encrypted = encrypt(message, key);
        //String encrypted = encryptTwoKeys("First Legion", 8, 21);
        String encrypted = encryptTwoKeys(message, 8, 21);
        
        System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
    }
	private String encryptTwoKeys(String input, int i, int j) {
		StringBuilder encrypted = new StringBuilder(input);
        
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alSh1=alphabet.substring(i)+alphabet.substring(0, i);
        String alSh2=alphabet.substring(j)+alphabet.substring(0, j);
        boolean low ;
        
        for (int k=0; k< encrypted.length(); k++){
        	low =false;
        	char tmp = encrypted.charAt(k);
        	if (Character.isLowerCase(tmp)){low=true;}
        	tmp = Character.toUpperCase(tmp);
        	int tmpI=-1;
        	char tmpC;
        	
        	if (0==(k%2) ){
        		tmpI=alphabet.indexOf(tmp);
        		if (-1 != tmpI){
        			tmpC = alSh1.charAt(tmpI);
        			if (low) {tmpC = Character.toLowerCase(tmpC);}
            		encrypted.setCharAt(k, tmpC);
        		}
        		
        	}else{
        		tmpI=alphabet.indexOf(tmp);
        		if ( -1 != tmpI){
        			tmpC = alSh2.charAt(tmpI);
        			if (low) {tmpC = Character.toLowerCase(tmpC);}
            		encrypted.setCharAt(k, tmpC);
        		}
        		
        	}
        	
        	
        }
        
		return encrypted.toString();
	}
}

