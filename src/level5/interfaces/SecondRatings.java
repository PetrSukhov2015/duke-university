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

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<PlainRater> myRaters;
    public ArrayList<Movie> getMyMovies() {
		return myMovies;
	}
	public void setMyMovies(ArrayList<Movie> myMovies) {
		this.myMovies = myMovies;
	}
	public ArrayList<PlainRater> getMyRaters() {
		return myRaters;
	}
	public void setMyRaters(ArrayList<PlainRater> myRaters) {
		this.myRaters = myRaters;
	}
	public static void main(String[] args){
    	SecondRatings sr = new SecondRatings();
    	//System.out.println("i am here");
    }
    public SecondRatings() {
        // default constructor
    	this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv", 
    			"D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv");
    	//String ratedMovie= "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv";
        //String ratingMovie = "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv";
    	//this("ratedmoviesfull.csv", "ratings.csv");
        
    }

	public SecondRatings(String moviefile, String ratingsfile) {
		// TODO Auto-generated constructor stub
		FirstRatings fr = new FirstRatings();
		myMovies = fr.loadMovies(moviefile);
		//myRaters = fr.loadRaters(ratingsfile);
		
	}
	public static int theNum=0;
	public double getAverageByID(String id, int rat) {
		// TODO Auto-generated method stub
		double avg=0.0;
		int num=0;
		for (PlainRater r: myRaters){
			if (r.hasRating(id) &&
					rat<=r.getRating(id)		){
				avg+=r.getRating(id);
				num++;
			}
			
			
			
		}
		if (num>12){
			//System.out.println(this.getTitle(id));
			//theNum++;
			System.out.println(this.getTitle(id)+" "+num);
		}
		
		return avg/num;
		//return avg;
	}
	
	
	public ArrayList<Rating> getAverageRatings(int ratMin) {
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		//ratList=null;
		//HashMap<String, ArrayList<Double>> mapID = new HashMap<String, ArrayList<Double>>(); 
		ArrayList<String> ids = new ArrayList<String>();
		
		for (PlainRater rater:myRaters){
			
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
			/*
			for (Entry<String, ArrayList<Double>> id:mapID.entrySet()){
				ArrayList<Double> tmpVal = id.getValue();
				double avg=0.0;
				for(Double val:tmpVal){
					
				}
				System.out.println(id.getKey()+" "+id.getValue().size());
			}
				//System.out.println(getAverageByID(r.getItem(), ratMin));
			
				/*	
				 * }
				ArrayList<String> tmpIdRat = new ArrayList<String>();
				if (!tmpIdRat.contains(r.getItem())){
					tmpIdRat.add(r.getItem());
					
					Rating finalRating = new Rating(r.getItem(),
						getAverageByID(r.getItem(), ratMin)
						);
					
					ratList.add(finalRating);
					
				}
				
				
				ratList.add(new Rating(r.getItem(), 
						getAverageByID(r.getItem(), ratMin))
						);
						*/
			//
			
			
			
		
		}
		//return ratList;
		return ratList;
		
	}
	
	public int getMovieSize(){
		return myMovies.size();
	}
	public int getRaterSize(){
		return myRaters.size();
	}
	public String getTitle(String id){
		for (Movie m: myMovies){
			if (id.equals(m.getID())){
				return m.getTitle();
			}
		}
		return "";
	}
    
}
