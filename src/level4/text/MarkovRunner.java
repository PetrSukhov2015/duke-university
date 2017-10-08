
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */
package level4.text;
import edu.duke.*;

public class MarkovRunner {
	public static void main(String[] args) {		
		//runMarkovOne();
		//runMarkovFour();
		//testGetFollowsWithFile();
		runMarkovModel();
		//runMarkovZero();
	}
	
    public static void runMarkovZero() {
    	String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		//MarkovOne markov = new MarkovOne();
		markov.setRandom(88);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
    public static void runMarkovOne(){
    	String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setRandom(273);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
    }
    public static void runMarkovFour(){
    	String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		//MarkovZero markov = new MarkovZero();
		MarkovFour markov = new MarkovFour();
		markov.setRandom(371);
		markov.setTraining(st);
		for(int k=0; k < 6; k++){
			String text = markov.getRandomText(100);
			printOut(text);
		}
    }
    
    public static void runMarkovModel(){
    	String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel(8);
		markov.setRandom(365);
		markov.setTraining(st);
		for(int k=0; k < 2; k++){
			String text = markov.getRandomText(100);
			printOut(text);
		}
    }
	
	private static void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
