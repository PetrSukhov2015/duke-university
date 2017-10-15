package level4.text.interfaces;

import java.util.ArrayList;
import java.util.Random;

public interface IMarkovModel {
	
	public void setTraining(String s);
	public String getRandomText(int i);
	public void setRandom(int j);
	//public ArrayList<String> getFollows();
}
