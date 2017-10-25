package level3.cc;

public class WordPlay {
	public static void main (String[] args){
		//System.out.print(replaceVowels("Hello World",'*'));
		//System.out.println(emphasize("dna ctgaaactga", 'a'));
		//CaesarCipher cc = new CaesarCipher();
		//cc.testCaesar();
		//WordFrequencies wf = new WordFrequencies();
		//wf.tester();
		CharactersInPlay cp = new CharactersInPlay();
		cp.tester();//.findAllCharacters();
	}
	public static boolean isVowel(char ch){
		return "AEIOUaeiou".indexOf(ch) != -1;
	}
	
	public static String replaceVowels(String phrase, char ch){
		String res="";
		for (int i=0; i< phrase.length(); i++){
			//System.out.println(phrase.charAt(i));
			if ( isVowel(phrase.charAt(i)) ){
				res+=ch;
			}
			res+=phrase.charAt(i);
		}
		return res;
	}
	
	public static String emphasize(String ph, char c){
		String res="";
		for (int i=0; i< ph.length(); i++){
			//System.out.println(phrase.charAt(i));
			if ( c == ph.charAt(i) ){
				res+="*";
			}else{
				res+=ph.charAt(i);
			}
			
		}
		return res;
	}
}
