package level4.text.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel{
	protected String myText;
	protected Random myRandom;
	
	
	protected ArrayList<String> getFollows(String key){
		int kl=key.length();
		ArrayList<String> res = new ArrayList<String>();
		for (int i =0; i<myText.length()-kl; i++){
			if ( key.equals(myText.substring(i,i+kl)) ){
				String tmp = myText.substring(i+kl,i+kl+1);
				res.add(tmp);
			}
		}
		//
		//int size=res.size();
		//System.out.println("size is: "+size);
		//for (String s: res){			System.out.println(s);		}
		return res;
	}
	
	protected ArrayList<String> newGetFollows(HashMap<String, ArrayList<String>> hm, String key1){
		if (null==hm){System.out.println("hm is empty");return null;}
		if (null==key1){System.out.println("key is empty");return null;}
		System.out.println(key1);
		hm.get(key1);
		ArrayList<String> tmp = (ArrayList<String>) hm.get(key1);
		return tmp;
	}

}
