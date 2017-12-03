package level5.interfaces;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.Map.Entry;

import level5.interfaces.Movie;
import level5.interfaces.Rater;
import level5.interfaces.Rating;
import level5.interfaces.Filter;
import level5.interfaces.MovieDatabase;
import level5.interfaces.RaterDatabase;
import level5.interfaces.TrueFilter;

public class ThirdRatings {
	private static ArrayList<Rater> myRaters;
	private static ArrayList<Movie> myMovies ;
	
	public static void main(String[] args){
		ThirdRatings tr = new ThirdRatings();
		ArrayList <Rating> myRating = tr.getAverageRatings(35);
		for (Rating r:myRating){
			//System.out.println(getTitle( r.getItem() )+" "+r.getValue());
		}
		//getAverageRatingsByFilter(35,new TrueFilter());
		//printAverageRatingsByYear (20,2000);
		
		
    }


	public ThirdRatings() {
        this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv");
        		//"rating.csv");
    	// default constructor
    	//this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv", 
    	//		"D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv");
    	//String ratedMovie= "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv";
        //String ratingMovie = "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv";
    	//this("ratedmoviesfull.csv", "ratings.csv");
        
    }

	public ThirdRatings(String ratingsfile) {
		// TODO Auto-generated constructor stub
		myRaters = FirstRatings.loadRaters(ratingsfile);
		myMovies = FirstRatings.loadMovies("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv"
				);
		//FirstRatings fr = new FirstRatings();
		
		
	}
	public ArrayList<Rating> getAverageRatings(int ratMinNum) {
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // map for ratings
		for (Rater rater:myRaters){
			for (Rating r: rater.getMyRatings()){
				if ( !myMap.containsKey(r.getItem()) ){
					myMap.put( r.getItem(), 1 );
				}else{
					myMap.put( r.getItem(), myMap.get(r.getItem())+1 );
				}
			}
		}
		int num=0;
		for (Entry<String, Integer> map: myMap.entrySet()){
			if (ratMinNum <= map.getValue()){
				num++;
				System.out.println(getTitle(map.getKey() )+" "+ map.getValue());
			}
		}
		System.out.println(num);
			

		return ratList;
		
	}
	public static double  getAverageByID(String id, int rat) {
		// TODO Auto-generated method stub
		double avg=0.0;
		int num=0;
		for (Rater r: myRaters){
			if (r.hasRating(id) &&
					rat<=r.getRating(id)		){
				avg+=r.getRating(id);
				num++;
			}
			
			
			
		}
		//if (num>12){
			//System.out.println(this.getTitle(id));
			//theNum++;
			//System.out.println(this.getTitle(id)+" "+num);
		//}
		
		return avg/num;
		//return avg;
	}
	public static String getTitle(String id){
		for (Movie m: myMovies){
			if (id.equals(m.getID())){
				return m.getTitle();
			}
		}
		return "";
	}
	public int getMovieSize(){
		return myMovies.size();
	}
	public int getRaterSize(){
		return myRaters.size();
	}

	
	public static ArrayList <Rating> getAverageRatingsByFilter2 (int minimalRaters, Filter filterCriteria){
		ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);		
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // map for ratings
		for (Rater rater:myRaters){
			for (Rating r: rater.getMyRatings()){
				if ( !myMap.containsKey(r.getItem()) ){
					myMap.put( r.getItem(), 1 );
				}else{
					myMap.put( r.getItem(), myMap.get(r.getItem())+1 );
				}
			}
		}
		//Collections.sort(list);
		int num =0;
		for (String movie: movies){
			for (Entry<String, Integer> map: myMap.entrySet()){
				if (minimalRaters <= map.getValue() &&
						movie.equals(map.getKey())){
					num++;
					System.out.println(getTitle(map.getKey() )+" "+ map.getValue());
				}
			}
		}
		System.out.println(num+"       ;");
		return ratList;
		
	}
	public static ArrayList <Rating> getAverageRatingsByFilter (int minimalRaters, Filter filterCriteria){
		ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);		
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // map for ratings
		for (Rater rater:myRaters){
			for (Rating r: rater.getMyRatings()){
				if ( !myMap.containsKey(r.getItem()) ){
					myMap.put( r.getItem(), 1 );
				}else{
					myMap.put( r.getItem(), myMap.get(r.getItem())+1 );
				}
			}
		}
		//Collections.sort(list);
		int num =0;
		for (String movie: movies){
			for (Entry<String, Integer> map: myMap.entrySet()){
				if (minimalRaters <= map.getValue() &&
						movie.equals(map.getKey())){
					num++;
					System.out.println(getTitle(map.getKey() )+" "+ map.getValue());
				}
			}
		}
		System.out.println(num+"       ;");
		return ratList;
		
	}
	
	public double dotProduct(Rater me, Rater r) {
		double DotProduct = 0, Product = 0;
		double meRatings = 0, rRatings = 0;
		ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
		
		 //System.out.println("Movies = " + myMovies.size());

		for (String ID : myMovies) {
			// System.out.println("CHCECKING FOR MOVIE ID = "+ ID);
			//System.out.println(ID);
			
			r.hasRating(ID);
			//me.test();
			if (me.hasRating(ID) == true && r.hasRating(ID) == true){
				meRatings = me.getRating(ID);
				// System.out.println("meRatings for " + ID + " = " +
				// meRatings);
				rRatings = r.getRating(ID);
				// System.out.println("rRatings for " + ID + " = " + rRatings);
				if (meRatings != -1 && rRatings != -1) {
					Product = (meRatings - 5) * (rRatings - 5);
					// System.out.println("product = " + Product);
					DotProduct = DotProduct + Product;
					// System.out.println("Dotproduct = " + DotProduct);
				}
			}
		}
		return DotProduct;
	}

	public ArrayList<Rating> getSimilarities(String ID) {
		ArrayList<Rating> list = new ArrayList<Rating>();
		for (Rater r : RaterDatabase.getRaters()) {

			if (!(r.getID().equals(ID)))

			{
				Rater me = RaterDatabase.getRater(ID);
				Double dotProduct = dotProduct(me, r);
				//System.out.println(dotProduct);
				if (dotProduct >= 0) {
					list.add(new Rating(r.getID(), dotProduct));
				}
			}

		}
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}
	
	public ArrayList<Rating> getSimilarRating(String id, int numOfSimilarRaters, int MinRaters) {
		ArrayList<Rating> list = getSimilarities(id);
		ArrayList<Rating> MoviesList = new ArrayList<Rating>();
		ArrayList<String> myMovies1 = MovieDatabase.filterBy(new YearAfterFilter(1975));
		ArrayList<String> myMovies2 = MovieDatabase.filterBy(new MinutesFilter(70,200));
		ArrayList<String> myMovies = new ArrayList<String>();
		for (String m1:myMovies1){
			for (String m2:myMovies2){
				if (m1.equals(m2)){
					myMovies.add(m1);
				}
			}
		}
		
		// double WeightedTotal =0,AVG =0 ;
		for (int i = 0; i < myMovies.size(); i++) {
			double WeightedTotal = 0.0;// AVG =0 ;
			double TotalRaters = 0.0;
			for (int k = 0; k < numOfSimilarRaters; k++) {
				String CurrRaterID = list.get(k).getItem();

				Rater CurrRater = RaterDatabase.getRater(CurrRaterID);

				if (CurrRater.hasRating(myMovies.get(i)) == true) {
					TotalRaters++;

					WeightedTotal = WeightedTotal + (list.get(k).getValue()) * (CurrRater.getRating(myMovies.get(i)));

				}
			}
			if (TotalRaters >= MinRaters) {
				/// --------------------------------!
				double AVG = WeightedTotal / TotalRaters;

				MoviesList.add(new Rating(myMovies.get(i), AVG));

			}
		}
		Collections.sort(MoviesList, Collections.reverseOrder());
		return MoviesList;

	}

    
}
