package level3.mp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import edu.duke.*;

public class VigenereBreaker {
	public static void main (String[] args){
		//String path = "D:\\duke\\level3\\mini_project\\VigenereTestData\\athens_keyflute.txt";
		//FileResource fr = new FileResource(path);							  //0123456789012
		//tryKeyLength(fr.asString(), 5,'e' );
		//System.out.println(sliceString("abcdefghijklm", 0, 3));
		breakVigenere();
	}
    public static String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
    	StringBuilder sb= new StringBuilder();
    	for (int k=whichSlice; k<=message.length(); k+=totalSlices){
    		if (message.length()< k+totalSlices){break;}
    		sb.append(message.charAt(k));
    		
    	}
    	return sb.toString();
        //return "WRITE ME!";
    }

    public static int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker();
        
        //System.out.println(cc.decrypt(sliceString(encrypted, 0, 3))  );
        //
        for (int k=0; k< klength; k++){
        	//System.out.println(cc.getKey(sliceString(encrypted,k,klength)) );
        	key[k]=cc.getKey(sliceString(encrypted,k,klength) );
        	//3,20,10,4
        }
        //System.out.println(cc.getKey(sliceString(encrypted,0,5)) );
        //System.out.println(cc.getKey(sliceString(encrypted,1,5)) );
        
        
        return key;
    }
    
    //main test method
    public static void breakVigenere () {
        //WRITE YOUR CODE HERE
    	String path = "D:\\duke\\level3\\mini_project\\VigenereProgram\\messages\\secretmessage3.txt";
		String pathD = "D:\\duke\\level3\\mini_project\\VigenereProgram\\dictionaries\\French";
    	FileResource fr = new FileResource(path);							  //0123456789012
    	FileResource fr2 = new FileResource(pathD);
    	FileResource fr3 = new FileResource(path);
    	
    	//VigenereCipher vc = new VigenereCipher( tryKeyLength(fr.asString(),1 ,'b') );
    	//String res = vc.decrypt(fr.asString());
    	//System.out.println( res );
    	String file = breakForLanguage( fr.asString(), readDictionary(fr2) ) ;
    	HashSet<String> mySet = readDictionary(fr2);
    	System.out.println(mySet.size());
    	String[] lines = file.split("\n");
    	System.out.println(lines[0]);
    	//readDictionary(file);
    	//System.out.println(countWords( file, readDictionary(fr2)) );
    	//enter brutus and cassius, and a throng of citizens
    }
    
    //create dictionary
    public static HashSet<String> readDictionary(FileResource  fr){
    	HashSet<String> set = new HashSet<String>();
    	for (String word : fr.asString().split("\\W")){
    		set.add( word.toLowerCase() );
    	}
    	return set;
    	
    }
    //count words join
    public static int countWords(String message, HashSet<String> dictionary){
    	int contains=0;
    	contains=0;
    	for (String word : message.split("\\W")){
    		//System.out.println(word);
    		if ( dictionary.contains(word.toLowerCase()) ){
    			//System.out.println(word);
    			contains++;
    		}
    	}
    	return contains;
    }
    //find out text
    public static String breakForLanguage(String encrypted, HashSet<String> dictionary){
    	int maxJoin=0;
    	int key=0;
    	for (int k=1; k<=100; k++){
    	//int k=38;
    		//System.out.println(tryKeyLength (encrypted,k,'a').length);
    		VigenereCipher vc = new VigenereCipher( tryKeyLength (encrypted,k,'e') );
    		//System.out.println(encrypted);
    		//System.out.println( vc.decrypt(encrypted) );
    		String dec = vc.decrypt(encrypted);
    		int tmp = countWords(dec,  dictionary);
    		if (tmp>maxJoin){
    			maxJoin=tmp;
    			key=k;
    		}
    	}
    	System.out.println(tryKeyLength (encrypted,key,'a').length);
    	System.out.println(maxJoin);
    	VigenereCipher vc2 = new VigenereCipher( tryKeyLength (encrypted,key,'a') );
		return vc2.decrypt(encrypted);
    }
    
 

    
}
