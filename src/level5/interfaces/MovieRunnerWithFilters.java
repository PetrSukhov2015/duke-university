package level5.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//import level5.interfaces.FourthRatings;
import level5.interfaces.Rating;

public class MovieRunnerWithFilters {
	public static void main(String[] args){
		MovieRunnerWithFilters mrf = new MovieRunnerWithFilters();
		//mrf.printAverageRatings(35);
		//mrf.printAverageRatingsByYear (20,2000);
		//mrf.printAverageRatingsByDirectors (4,"Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
		//mrf.printAverageRatingsByMinutes (5,105,135);
		//mrf.printAverageRatingsByGenre(20, "Comedy");
		mrf.printSimilarRating();
	}

	private void printSimilarRating() {
		ThirdRatings tr = new ThirdRatings ();
		ArrayList<Rating> ms = tr.getSimilarRating("314", 10, 5);
		for (Rating r:ms){
			System.out.println(tr.getTitle(r.getItem())+" "+r.getValue() );
		}
		//System.out.println(ms.get(0).getItem());
		
	}

	private void printAverageRatingsByGenre(int r, String genre) {
		ThirdRatings tr = new ThirdRatings ();
		ArrayList<Rating> fList= tr.getAverageRatingsByFilter ( r,new GenreFilter(genre) );
		
		
	}

	private static void printAverageRatingsByMinutes(int r, int min, int max) {
		ThirdRatings tr = new ThirdRatings ();
		ArrayList<Rating> fList= tr.getAverageRatingsByFilter ( r,new MinutesFilter(min, max) );
		System.out.println("found "+fList.size()+" movies");
		for (Rating rat: fList){
			//System.out.print(getTitle(rat.getItem())+" "+rat.getValue() +" "+MovieDatabase.getMinutes(rat.getItem())+" minuts \n");
		}
		
	}
	private static void printAverageRatingsByYear(int r,int y) {
		ThirdRatings tr = new ThirdRatings ();
		ArrayList<Rating> fList= tr.getAverageRatingsByFilter ( r,new YearAfterFilter(y) );
		System.out.println("found "+fList.size()+" movies");
		for (Rating rat: fList){
			System.out.print(tr.getTitle(rat.getItem())+" "+rat.getValue() +"\n");
		}
		
	}
	private void printAverageRatingsByDirectors(int r, String dirs) {
		ThirdRatings tr = new ThirdRatings ();
		//ArrayList<String> movies = MovieDatabase.filterBy(new DirectorsFilter (dirs));
		
		ArrayList<Rating> list = tr.getAverageRatingsByFilter (r,new DirectorsFilter (dirs));
		System.out.println(list.size());
    	for (Rating rat: list){
			//System.out.println(ThirdRatings.getTitle(rat.getItem())+" "+rat.getValue() +" "+MovieDatabase.getDirector(rat.getItem()));
		}
		//printAverageRatingsByDirectors (4,"Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
	}
	

	public void printAverageRatings(int rat){
		ThirdRatings tr = new ThirdRatings ();
		ArrayList<Rating> ratList = tr.getAverageRatings(rat);
		Collections.sort(ratList);//sorting Comparable
		for (Rating r:ratList){			
			//System.out.println(tr.getTitle(r.getItem())+" "+r.getValue());			
		}
		//System.out.println( sr.getTitle("0068646") );
		
	}
}
