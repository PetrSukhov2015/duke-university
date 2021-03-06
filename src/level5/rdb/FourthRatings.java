package level5.rdb;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.Map.Entry;

import level5.rdb.Movie;
import level5.rdb.Rater;
import level5.rdb.Rating;

public class FourthRatings {
	private static ArrayList<Rater> myRaters;
	private static ArrayList<Movie> myMovies ;
	
	public static void main(String[] args){
		FourthRatings fr = new FourthRatings();
		//ArrayList <Rating> myRating = fr.getAverageRatings(33);
		//System.out.println(fr.getAverageByID("0068646",0) );
		//for (Rating r:myRating){
			//System.out.println(getTitle( r.getItem() )+" "+r.getValue());
		//}
		getAverageRatingsByFilter(35,new TrueFilter());
		//printAverageRatingsByYear (20,2000);
		
		
    }


	public FourthRatings() {
        this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv");

        
    }

	public FourthRatings(String ratingsfile) {
		// TODO Auto-generated constructor stub
		RaterDatabase.initialize(ratingsfile);
		myRaters = RaterDatabase.getRaters();//FirstRatings.loadRaters(ratingsfile);
		String moviefile = "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv";
		MovieDatabase.initialize(moviefile);
		myMovies = MovieDatabase.getMovies();
		//FirstRatings fr = new FirstRatings();
		
		
	}
	public ArrayList<Rating> getAverageRatings(int ratMinNum) {
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // map for ratings
		System.out.println(myRaters.size());
		for (Rater rater:myRaters){
			for (Rating r: rater.getMyRatings().values()){
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
			//if (r.hasRating(id) &&
			//		rat<=r.getRating(id)		){
				avg+=r.getRating(id);
				num++;
			//}
			
			
			
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

	
	public static ArrayList <Rating> getAverageRatingsByFilter (int minimalRaters, Filter filterCriteria){
		ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);		
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // map for ratings
		for (Rater rater:myRaters){
			for (Rating r: rater.getMyRatings().values()){
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
	
	private static void dotProduct(Rater  me, Rater r){
		ArrayList<Rating> dotProduct = new ArrayList<Rating>();
		ArrayList<Rating> ratings = (ArrayList<Rating>) me.getMyRatings().values();
		for (Rating rat:ratings){
			rat.getValue();
		}
	}
	private ArrayList <Rating> getSimilarities(String  id){
		dotProduct();
		
	}
	

    
}
