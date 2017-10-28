package level3.cc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.duke.*;
public class WordsInFiles {
	private static HashMap<String, ArrayList<String> > map= new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file = new File("D:\\duke\\level3\\ProgrammingImprovingGladLibsData\\brief1.txt");
		//File file2 = new File("D:\\duke\\level3\\ProgrammingImprovingGladLibsData\\brief2.txt");
		
		//addWordsFromFile(file);
		//addWordsFromFile(file2);
		buildWordFileMap();
		maxNumber();
		ArrayList<String > tmp = wordsInNumFiles(3);
		for (int k=0; k<tmp.size(); k++){
			//System.out.println(tmp.get(k));
		}
		//printFilesIn("cats");
		
	}
	private static ArrayList<String> wordsInNumFiles(int n) {
		ArrayList<String> res= new ArrayList<String>();
		for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()){
			//System.out.println(entry.getKey()+" "+entry.getValue().size());
			if (n == entry.getValue().size()){
				res.add(entry.getKey());
			}
		}
		return res;
		
	}
	private static void maxNumber() {
		int tmpS=-1;
		String tmpKey="";
		ArrayList<String> max= new ArrayList<String>();
		for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()){
			if (tmpS < entry.getValue().size()){
				tmpS = entry.getValue().size();
				tmpKey = entry.getKey();
			}
			//System.out.println("max value "+tmpS+" ");
		}		
		System.out.println("max value "+tmpS+" keyIs "+tmpKey);
		for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()){
			if (tmpS == entry.getValue().size()){
				if (!tmpKey.equals(entry.getKey())){
					tmpKey = entry.getKey();
					System.out.println("max value "+tmpS+" keyIs "+tmpKey);
				}
				
				
			}
			//System.out.println("max value "+tmpS+" ");
		}
		
	}
	private static void printFilesIn(String string) {
		for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()){
			String key = entry.getKey().toString();
		    ArrayList<String> value = entry.getValue();
		    
		   if (string.equals(key)){
		    	for (int k=0; k< value.size(); k++){
		    		System.out.print(value.get(k)+" ");
		    	}
		    }
		    /*
		    System.out.println(key );
		    for (int k=0; k< value.size(); k++){
		    	System.out.print(" "+value.get(k));
		    }
		    System.out.println("\n");
		    */
		}
		
	}
	public static void buildWordFileMap (){
		map.clear();
		DirectoryResource dr = new DirectoryResource ();
		
		for (File f: dr.selectedFiles()){
			addWordsFromFile(f);
		}
		
		
	}
	
	public static void addWordsFromFile (File f){
		//ArrayList<String> tmp = new ArrayList<String>();
		FileResource fr = new FileResource(f);
		for (String word: fr.words()){
			if ( !map.containsKey(word)){
				ArrayList<String> tmp3 = new ArrayList<String>();
				tmp3.add(f.getName());
				map.put(word, tmp3);
			}else{
				ArrayList<String> tmp2 = new ArrayList<String>();				
				tmp2= map.get(word);
				if (-1 == tmp2.indexOf(f.getName())){
					tmp2.add(f.getName());
				}	
				map.put(word, tmp2);
				//tmp2.clear();
			}
			//System.out.println(word);
		}
	}

}
