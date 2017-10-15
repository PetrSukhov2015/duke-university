package level4.text.interfaces;

import edu.duke.FileResource;

public class MarkovRunnerWithInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runMarkov(5);
		//testHashMap(42);
		//String[] st = "this is just a test yes this is a simple test".split("\\s+");
		//System.out.println(MarkovWordOne.indexOf(st,"this",0) );
		//compareMethods();
		//MarkovWordOne mwo = new MarkovWordOne();
		MarkovWordTwo mwt = new MarkovWordTwo();
		mwt.setRandom(549);
		//String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		//String file = "this is just a test yes this is a simple test";
		String file = "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		//String[] s = st.split("\\s+");
		//String st = "this is just a test yes this is a simple test";
		mwt.setTraining(st);
		
		String text = mwt.getRandomText(120);
		printOut(text);
		
	}

	private static void compareMethods() {
		// TODO Auto-generated method stub
		
	}

	private static void testHashMap(int i) {
		// TODO Auto-generated method stub
		//String st = "yes-this-is-a-thin-pretty-pink-thistle";
		String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\romeo.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		
		EfficientMarkovModel emm1 = new EfficientMarkovModel(5,615);
		emm1.setTraining(st);
		emm1.buildHashMap();
		//emm1.printNumKeysHM();
		//emm1.printHM();
		emm1.printLagestLists();
		
		//emm1.setTraining(st);
		/*
		System.out.println("markov model, seed:"+i);
		for(int k=0; k < 3; k++){
			String text = emm1.getRandomText(100);
			printOut(text);
		}*/
	}

	private static void runMarkov(int seed) {
		// TODO Auto-generated method stub
		String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\romeo.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		//st = 
		//MarkovZero m0 = new MarkovZero();
		//MarkovOne m1 = new MarkovOne();
		//MarkovFour m4 = new MarkovFour();
		MarkovModel mm = new MarkovModel(5);
		//EfficientMarkovModel emm1 = new EfficientMarkovModel(seed);
		//m0.setRandom(seed);
		//m1.setRandom(seed);
		//m4.setRandom(seed);
		mm.setRandom(615);
		//emm1.setRandom(seed);
		//MarkovOne markov = new MarkovOne();
		//markov.setRandom(88);
		/*
		m0.setTraining(st);
		System.out.println("markov 0");
		for(int k=0; k < 3; k++){
			String text = m0.getRandomText(100);
			printOut(text);
		}
		m1.setTraining(st);
		System.out.println("markov 1");
		for(int k=0; k < 3; k++){
			String text = m0.getRandomText(100);
			printOut(text);
		}
		m4.setTraining(st);
		System.out.println("markov 4");
		for(int k=0; k < 3; k++){
			String text = m0.getRandomText(100);
			printOut(text);
		}
		*/
		//emm1.setTraining(st);
		
		System.out.println("markov model, seed:"+seed);
		//for(int k=0; k < 3; k++){
			String text = mm.getRandomText(615);
			printOut(text);
		//}
		//emm.printHM();
		//emm.pritSizeHM();
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
