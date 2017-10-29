package level3.cc;
import edu.duke.*;
import java.util.*;
import java.util.Map.Entry;

public class GladLibMap {
	private HashMap<String, ArrayList<String>> myMap ;
	/*
	private ArrayList<String> adjectiveList;
	private ArrayList<String> nounList;
	private ArrayList<String> colorList;
	private ArrayList<String> countryList;
	private ArrayList<String> nameList;
	private ArrayList<String> animalList;
	private ArrayList<String> timeList;
	private ArrayList<String> verbList;
	private ArrayList<String> fruitList;
	*/
	public static ArrayList<String> uWords = new ArrayList<String>();
	public static ArrayList<String> cats = new ArrayList<String>();
	
	private Random myRandom;
	private static int num=1;
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";
	
	public GladLibMap(){
		myMap = new HashMap<String, ArrayList<String>>();
		
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
		
		//clear();
	}
	
	public GladLibMap(String source){
		myMap = new HashMap<String, ArrayList<String>>();
		
		initializeFromSource(source);
		myRandom = new Random();
		//=clear();
	}
	private void clear(){
		myMap.clear();
		
		/*
		adjectiveList.clear();
		nounList.clear();
		colorList.clear();
		countryList.clear();
		nameList.clear();
		animalList.clear();
		timeList.clear();
		verbList.clear();
		fruitList.clear();
		*/
	}
	private void initializeFromSource(String source) {
		//clear();
		//ArrayList<String> tmp = new ArrayList<String>();
		String[] patterns = {"adjective","noun","color","country","name","animal",
				"timeframe","number","verb","fruit"};
		for (String s:patterns){
			System.out.println(s);
			ArrayList<String> tmp = readIt(source+"/"+s+".txt");
			//ArrayList<String> adjectiveList= readIt(source+"/adjective.txt");	
			//System.out.println();
			//System.out.println(adjectiveList);
			myMap.put(s, tmp);
			//myMap.put(s, adjectiveList);
			//tmp.clear();
		}
		
		
		
		/*
		adjectiveList= readIt(source+"/adjective.txt");	
		nounList = readIt(source+"/noun.txt");
		colorList = readIt(source+"/color.txt");
		countryList = readIt(source+"/country.txt");
		nameList = readIt(source+"/name.txt");		
		animalList = readIt(source+"/animal.txt");
		timeList = readIt(source+"/timeframe.txt");	
		verbList = readIt(source+"/verb.txt");
		fruitList = readIt(source+"/fruit.txt");
		*/	
	}
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}
	
	private String getSubstitute(String label) {
		if (myMap.containsKey(label)) {
			return randomFrom(myMap.get(label));
		}
		return "**UNKNOWN**";
		/*
		if (label.equals("country")) {
			return randomFrom(countryList);
		}
		if (label.equals("color")){
			return randomFrom(colorList);
		}
		if (label.equals("noun")){
			return randomFrom(nounList);
		}
		if (label.equals("name")){
			return randomFrom(nameList);
		}
		if (label.equals("adjective")){
			return randomFrom(adjectiveList);
		}
		if (label.equals("animal")){
			return randomFrom(animalList);
		}
		if (label.equals("timeframe")){
			return randomFrom(timeList);
		}
		if (label.equals("number")){
			return ""+myRandom.nextInt(50)+5;
		}
		if (label.equals("verb")){
			return ""+myRandom.nextInt(50)+5;
		}
		if (label.equals("fruit")){
			return ""+myRandom.nextInt(50)+5;
		}
		return "**UNKNOWN**";
		*/
	}
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		//System.out.println("w "+w.substring(first+1,last));
		String sub = getSubstitute(w.substring(first+1,last));
		
		while (-1 != uWords.indexOf(sub) ){
			sub = getSubstitute(w.substring(first+1,last));
		}
		if (-1 == cats.indexOf(w.substring(first+1,last))){
			cats.add(w.substring(first+1,last));
		}
		uWords.add(sub);
		num++;
		return prefix+sub+suffix;
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public void makeStory(){
	    System.out.println("\n");
	    String story = fromTemplate("D:\\duke\\level3\\GladLib\\data\\madtemplate2.txt");
		clearTmp();
		printOut(story, 60);
		System.out.println("\n"+num);
		System.out.println("--------");
		for (String s: uWords){
			System.out.print(s+ " ");
		}
		
	}

	private void clearTmp() {
		if (5==uWords.size() ){
			uWords.clear();
		}
		
	}

	public void totalWordsInMap() {
		int sum=0;
		for(Entry<String, ArrayList<String>> e: myMap.entrySet()){
			System.out.println(e.getKey()+" "+e.getValue().size());
			sum+=e.getValue().size();
		}
		System.out.println("total sum: "+sum);
		
	}

	public void totalWordsConsidered() {
		//System.out.println("test");
		int sum=0;
		for (String s: cats){
			//if (s.equals(myMap.g))
			//System.out.println(s);
			for (Entry<String, ArrayList<String>> e: myMap.entrySet()){
				if (s.equals(e.getKey())){
					sum+=e.getValue().size();
				}
			}
		}
		System.out.println("cats sum: "+sum);
		
	}
	
	


}
