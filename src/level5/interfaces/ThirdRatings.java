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

public class ThirdRatings {
	private ArrayList<Rater> myRaters;
	private static ArrayList<Movie> myMovies ;
	
	public static void main(String[] args){
		ThirdRatings tr = new ThirdRatings();
		ArrayList <Rating> myRating = tr.getAverageRatings(1);
		for (Rating r:myRating){
			System.out.println(getTitle( r.getItem() )+" "+r.getValue());
		}
    }
    public ThirdRatings() {
        this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings_short.csv");
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
		myMovies = FirstRatings.loadMovies("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmovies_short.csv"
				);
		//FirstRatings fr = new FirstRatings();
		
		
	}
	public ArrayList<Rating> getAverageRatings(int ratMin) {
		ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		//ratList=null;
		//HashMap<String, ArrayList<Double>> mapID = new HashMap<String, ArrayList<Double>>(); 
		ArrayList<String> ids = new ArrayList<String>();
		
		for (Rater rater:myRaters){
			
			//ArrayList<Rating> ratList1 = rater.getMyRatings();
			for (Rating r: rater.getMyRatings()){
					//System.out.print(r.getItem()+" "+r.getValue() +"\n");
				//if not in tmp list then add
				if ( !ids.contains(r.getItem()) ){
					ids.add(r.getItem());
					double tmp = this.getAverageByID(r.getItem(), ratMin);
					//System.out.println(r.getItem()+" "+tmp );
					Rating theRating = new Rating(r.getItem(), tmp);
					//System.out.println(theRating);
					
					ratList.add(theRating);
					//System.out.println(ratList);
					
					
				}
			}

		}
		
		return ratList;
		
	}
	public double getAverageByID(String id, int rat) {
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
	
	

    
}
