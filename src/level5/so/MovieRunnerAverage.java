package level5.so;

import java.util.ArrayList;

public class MovieRunnerAverage {
	private ArrayList<Movie> movies ;
	private ArrayList<Rater> raters;
	public static void main(String[] args){
		MovieRunnerAverage mra = new MovieRunnerAverage();
		mra.printAverageRatings();
		
		//System.out.println(mra.getAverageByID("0068646", 3) );
		//ArrayList<Rating> averageRatings = mra.getAverageRatings(3);
	}



	private ArrayList<Rating> getAverageRatings(int rat) {
		ArrayList<Rating> ratList = null;
		//for (Rater rat:raters){
			//for (Rating r:rat.getRating())
		//}
		return ratList;
		
	}



	public double getAverageByID(String id, int rat) {
		// TODO Auto-generated method stub
		double avg=0.0;
		int num=0;
		for (Rater r: raters){
			if (r.hasRating(id) &&
					rat<=r.getRating(id)		){
				avg+=r.getRating(id);
				num++;
			}
			
		}
		
		return avg/num;
	}

	public void printAverageRatings(){
		SecondRatings sr = new SecondRatings ();
		movies = sr.getMyMovies();
		raters = sr.getMyRaters();
		System.out.println("movies num "+sr.getMovieSize());
		System.out.println("rat num "+sr.getRaterSize());
		//System.out.println(sr.getAverageByID("0068646", 5) );
		//sr.getAverageRatings(5);
		//System.out.println(sr.getAverageRatings(3));
		
		ArrayList<Rating> ratList = sr.getAverageRatings(3);
		for (Rating r:ratList){
			System.out.println(r.getItem()+" "+r.getValue());
		}
		
		
	}

	
}
