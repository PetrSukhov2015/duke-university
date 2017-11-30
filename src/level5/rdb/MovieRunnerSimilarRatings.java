package level5.rdb;

import java.util.ArrayList;

import level5.rdb.Rating;

public class MovieRunnerSimilarRatings {

	public static void main(String[] args) {
		MovieRunnerSimilarRatings m = new MovieRunnerSimilarRatings();
		m.printAverageRatings();
		m.printAverageRatingsByYear(5,2000);
		m.printAverageRatingsByYearAfterAndGenre ();

	}
	private void printAverageRatingsByYear(int r,int y) {
		FourthRatings fr = new FourthRatings ();
		ArrayList<Rating> fList= fr.getAverageRatingsByFilter ( r,new YearAfterFilter(y) );
		System.out.println("found "+fList.size()+" movies");
		for (Rating rat: fList){
			System.out.print(fr.getTitle(rat.getItem())+" "+rat.getValue() +"\n");
		}
		
	}
	private void printAverageRatingsByYearAfterAndGenre() {
		// TODO Auto-generated method stub
		
	}
	public void printAverageRatings(){
		FourthRatings fr = new FourthRatings ();
		ArrayList<Rating> ratList = fr.getAverageRatings(1);
		//System.out.println(SecondRatings.theNum);
		//for (Rating r:ratList){
			
			//System.out.println(sr.getTitle(r.getItem())+" "+r.getValue());
			
		//}
		//System.out.println( sr.getTitle("0068646") );
		
	}

}
