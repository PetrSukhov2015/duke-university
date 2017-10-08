package level4.text;

import java.util.ArrayList;

import edu.duke.FileResource;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testGetFollows();
		testGetFollowsWithFile();
	}
	private static void testGetFollowsWithFile() {
		// TODO Auto-generated method stub
		String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\melville.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour mo = new MarkovFour();
		mo.setTraining(st);
		ArrayList<String> r = mo.getFollows("th");
		System.out.println(r.size());
	}
	public static void testGetFollows(){
		String file= "D:\\duke\\level4\\text\\RandomTextStarterProgram\\data\\confucius.txt";
		FileResource fr = new FileResource(file);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		
		MarkovOne mo = new MarkovOne();
		//mo.setTraining("this is a test yes this is a test.");
		mo.setTraining(st);
		ArrayList<String> r=mo.getFollows("t");
		//for (String s:r){
		//	System.out.println(s);
		//}
		System.out.println(r.size());
	}
}
