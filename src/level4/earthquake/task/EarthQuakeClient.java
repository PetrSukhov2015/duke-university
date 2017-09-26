package level4.earthquake.task;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe: quakeData){
        	if (qe.getMagnitude() > magMin){
        		answer.add(qe);
        	}
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe: quakeData){
        	if (qe.getLocation().distanceTo(from) < distMax){
        		answer.add(qe);
        	}
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedata.atom";
        String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        double minMag=5.0;
        ArrayList<QuakeEntry> shortList  = filterByMagnitude(list,minMag);
        for (QuakeEntry qe : shortList) {
            System.out.println(qe); 
         }
        System.out.println("read data for "+shortList.size()+" quakes");

    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> closeList = filterByDistanceFrom(list, 1000*1000,city);
        //for (QuakeEntry qe: closeList){
        	 for (int k=0; k< closeList.size(); k++) {
                 QuakeEntry entry = closeList.get(k);
                 double distanceInMeters = city.distanceTo(entry.getLocation());
                 System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
             }; 
        //}
        // This location is Bridgeport, CA
        // Location city =  new Location(38.17, -118.82);

        // TODO
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
        
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> list, 
    		double minDepth, double maxDepth){
    	
    	ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    	
    	for (QuakeEntry qe: list){
    		double dep=qe.getDepth();
    		if ( (minDepth < dep) && (dep < maxDepth) ){
    			answer.add(qe);
    		}
    	}
    	return answer;
    	
    }
    public void quakesOfDepth(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
    	String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedata.atom";
        
    	ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> depthList  = filterByDepth(list, -10000, -8000.0);
        for (QuakeEntry qe: depthList){
        	System.out.println(qe);
        }
        System.out.println(depthList.size());
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> list, 
    		String whereSearch, String phrase){
    	ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    	
    	for (QuakeEntry qe: list){
    		switch (whereSearch){
    			case "start":
    				if (qe.getInfo().startsWith(phrase)){
    					answer.add(qe);
    				}
    				break;
    			case "end":
    				if (qe.getInfo().endsWith(phrase)){
    					answer.add(qe);
    				}
    				break;
    			case "any":
    				if (qe.getInfo().contains(phrase)){
    					answer.add(qe);
    				}
    				break;
    			default:
    				break;
    				
    		}
    	}
    	return answer;
    }
    
    public void quakesByPhrase(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
    	String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedata.atom";
        
    	ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> phraseList  = filterByPhrase(list, "any", "Creek");
        for (QuakeEntry qe: phraseList){
        	System.out.println(qe);
        }
        System.out.println(phraseList.size());
    }
}
