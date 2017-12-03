package level5.interfaces;

import edu.duke.*;
import level5.interfaces.Movie;
import level5.interfaces.Rater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import org.apache.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class FirstRatings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testLoadMovies ();
		testLoadRaters();

	}
	private static void testLoadRaters() {
		ArrayList<Rater> ratList = loadRaters("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings_short.csv");
		//System.out.println(findParRate(ratList,2));
		//System.out.println(findMaxRat(ratList));
		//System.out.println(ratList.size());
		System.out.println(unicMovies(ratList));
		
	}
	private static int unicMovies(ArrayList<Rater> ratList) {
		// TODO Auto-generated method stub
		int res=0;
		for (Rater rat: ratList){
			//for (Rating r:rat.getItemsRated()){
				
			{}
		}
		return res;
	}
	private static int findMaxRat(ArrayList<PlainRater> ratList) {
		// TODO Auto-generated method stub
		int res=0;
		for (PlainRater r: ratList){
			if (res< r.numRatings()){
				res= r.numRatings();
			}
			
			if (314==r.numRatings()){
				System.out.println(r.getID());
			}
		}
		
		return res;
	}
	private static int findParRate(ArrayList<Rater> ratList,int id) {
		int res=0;
		for (Rater r: ratList){
			if (id == Integer.parseInt(r.getID())){
				res= r.numRatings();
			}
		}
		return res;
		
	}
	public static ArrayList<Rater> loadRaters(String filename) {
		ArrayList<Rater> ratList = new ArrayList<Rater>();
		FileResource fr = new FileResource(filename);		
		CSVParser parser = fr.getCSVParser(true);
		ArrayList<String> listOfId = new ArrayList<String>();
		
		
		for (CSVRecord csvRecord : parser) {
			if (listOfId.contains(csvRecord.get(0)) ){
				for (Rater rater: ratList){
					//System.out.println(rater.getID());
					if (rater.getID().equals(csvRecord.get(0)) ){
						
						rater.addRating(csvRecord.get(1),
								Double.parseDouble(csvRecord.get(2)) );
					}
				}
			}else{
				listOfId.add(csvRecord.get(0));
				Rater r = new PlainRater(csvRecord.get(0));
				r.addRating(csvRecord.get(1),
						Double.parseDouble(csvRecord.get(2)) );
				ratList.add(r);
			}		
		
			
			
			
			
		}
		
		return ratList;
		
	}
	private static void testLoadMovies() {
		HashMap<String, Integer> directorsMap = new HashMap<String, Integer>();
		ArrayList<Movie> mov = loadMovies("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv");
		System.out.println("array size "+ mov.size());
		int comedyGen =0;
		int gt150min = 0;
		int rater=0;
		for (Movie m: mov){
			if ( m.getGenres().contains("Comedy") ){
				comedyGen++;
			}
			if ( 150 < m.getMinutes() ){
				gt150min++;
			}
			String tmpDirectors = m.getDirector();
			String[] directors = tmpDirectors.split(",");
			for (String director: directors){
				//System.out.println(director);
				director=director.trim();
				if (!directorsMap.containsKey(director)){
					directorsMap.put(director, 1);
				}else{					
					directorsMap.put(director, directorsMap.get(director)+1);
				}
			}
			//System.out.println(m.getDirector());
			/*
			System.out.println(
					"id: "+m.getID()+"; "+
					"title: "+m.getTitle()+"; "+
					"year: "+m.getYear()+"; "+
					"country: "+m.getCountry()+"; "+
					"genre: "+m.getGenres()+"; "+
					"director: "+m.getDirector()+"; "+
					"minutes: "+m.getMinutes()+"; "+
					"poster: "+m.getPoster()+"; "
					);*/
		}
		System.out.println("comedyGen "+comedyGen);
		System.out.println("gt150min "+gt150min);
		findDirector(directorsMap);
		
	}
	private static void findDirector(HashMap<String, Integer> map) {
		int maxMovies=0;
		ArrayList<String> maxMoviesDirectors = new ArrayList<String>();
		
		//find max movies num
		for (Entry<String, Integer> entry: map.entrySet()){
			if (maxMovies < entry.getValue()){
				maxMovies = entry.getValue();
			}			
		}
		//find directories
		for (Entry<String, Integer> entry: map.entrySet()){
			if (maxMovies == entry.getValue()){
				maxMoviesDirectors.add(entry.getKey());
			}			
		}
		System.out.println("max num of movies: "+maxMovies);
		for (String d:maxMoviesDirectors){
			System.out.println(d);
		}
		
	}
	public static ArrayList<Movie> loadMovies (String filename){
		ArrayList<Movie> movList = new ArrayList<Movie>();
		FileResource fr = new FileResource(filename);		
		CSVParser parser = fr.getCSVParser(true);
		for (CSVRecord csvRecord : parser) {
			//System.out.println();
			//for (int k=0; k<csvRecord.size(); k++){
		    //System.out.print(csvRecord.get(k) + " ");}
			//System.out.println("test");
			Movie mov = new Movie(
					csvRecord.get(0).toString(),
					csvRecord.get(1).toString(),
					csvRecord.get(2).toString(),
					csvRecord.get(4).toString(),
					csvRecord.get(5).toString(),
					csvRecord.get(3).toString(),
					csvRecord.get(7).toString(),
					//Integer.parseInt(csvRecord.get(7).toString() )
					Integer.parseInt(csvRecord.get(6).toString() )
					);
			 movList.add(mov);
		}
		
		
		return movList ;		
	}
	
	

}
