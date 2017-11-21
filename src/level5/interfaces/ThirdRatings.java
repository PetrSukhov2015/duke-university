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
	private ArrayList<PlainRater> myRaters;
	public static void main(String[] args){
    	SecondRatings sr = new SecondRatings();
    	//System.out.println("i am here");
    }
    public ThirdRatings() {
        this("rating.csv");
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
		//FirstRatings fr = new FirstRatings();
		
		
	}

	
	

    
}
