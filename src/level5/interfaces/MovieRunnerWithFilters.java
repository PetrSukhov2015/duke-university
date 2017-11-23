package level5.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MovieRunnerWithFilters {
	public static void main(String[] args){
		MovieRunnerWithFilters mrf = new MovieRunnerWithFilters();
		mrf.printAverageRatings();
	}
	public void printAverageRatings(){
		ThirdRatings sr = new ThirdRatings ();
		//movies = sr.getMyMovies();
		//raters = sr.getMyRaters();
		//System.out.println("movies num "+sr.getMovieSize());
		System.out.println("rat num "+sr.getRaterSize());
		ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
		System.out.println("movies num "+ movies.size());
		//System.out.println(sr.getAverageByID("0068646", 5) );
		//sr.getAverageRatings(5);
		//System.out.println(sr.getAverageRatings(3));
		
		ArrayList<Rating> ratList = sr.getAverageRatings(1);
		Collections.sort(ratList);//sorting Comparable
		//ratList.sort();
		//System.out.println(SecondRatings.theNum);
		for (Rating r:ratList){
			
			System.out.println(sr.getTitle(r.getItem())+" "+r.getValue());
			
		}
		//System.out.println( sr.getTitle("0068646") );
		
	}
}
