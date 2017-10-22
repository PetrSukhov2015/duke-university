package level3.cc;



import edu.duke.FileResource;

public class WordLengths {
	public static void main (String[] args){
		//countWordLengths(fs, a);
		testCountWordLengths();
	}
	
	
	private static void testCountWordLengths() {
		int[] a = new int[60];
		//Path p = new Path("D:\\duke\\level3\\ProgrammingBreakingCaesarData\\smallHamlet.txt");
		//FileResource fs = new FileResource("D:\\duke\\level3\\lotsOfWords.txt.");
		FileResource fs = new FileResource("D:\\duke\\level3\\QuizCryptographyData\\manywords.txt");
		
		a= countWordLengths(fs, a);
		for (int k1=0; k1<a.length; k1++){
			if (0<a[k1])
			System.out.println("words "+a[k1]+" length "+k1);
		}
		int max = indexOfMax(a);
		System.out.println("---"+max);
	}


	private static int indexOfMax(int[] a) {
		int tmpMax=0;
		for (int k2=0; k2<a.length; k2++){
			if (tmpMax< a[k2]){
				tmpMax=a[k2];
			}
		}
		System.out.println();
		return tmpMax;
	}


	public static int[] countWordLengths(FileResource resource, int[] counts){
		String[] words = resource.asString().split("\\s+");
		System.out.println(words.length);
		for (String word: words){
			//if ( ('.' == word.charAt( word.length()-1)) ||
			//		(',' == word.charAt( word.length()-1 )) ){
			String tmp="";
			
			System.out.println(word);
			if ( false == Character.isLetter(word.charAt(word.length()-1))){ 
				word=word.substring(0,word.length()-1).toLowerCase();
				System.out.println(word);
			}
			if ( false == Character.isLetter(word.charAt(0))){ 
				
				word=word.substring(1).toLowerCase();
				//System.out.println(word);
			}
			
			//System.out.println(word);
			//if (Character.isLetter(word.charAt(word.length()-1)) == false)
			for (int k=0; k< counts.length; k++){
				if (k== word.length()){
					counts[k]+=1;
				}
			}
		}
		return counts;
	}
	
}
