
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package level4.earthquake.task.sort;
import level4.earthquake.task.*;

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    public int getLargestDepth(ArrayList<QuakeEntry> list, int from){
    	int max=from;
    	for (int i=from+1; i<list.size(); i++){
    		if (list.get(i).getDepth()> list.get(max).getDepth() ){
    			max=i;
    		}
    	}
    	return max;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> list){
    	for (int i=0; i < 50; i++){
    		int maxInd = getLargestDepth(list,i);
    		QuakeEntry qi = list.get(i);
    		QuakeEntry qmax = list.get(maxInd);
    		list.set(i, qmax);
    		list.set(maxInd, qi);
    		
    		/*
    		QuakeEntry qi = list.get(i);
            QuakeEntry qmin = list.get(maxInd);
            list.set(i,qmin);
            list.set(maxInd,qi);*/
    	}
    	
    }
    public void onePassBubbleSort (ArrayList<QuakeEntry> list, int numSorted){
    	for (int i=0; i< numSorted; i++){
    		for (int j=0; j<list.size()-1; j++){
    			QuakeEntry qj1 = list.get(j);
                QuakeEntry qj2 = list.get(j+1);
                if ( qj1.getMagnitude()>qj2.getMagnitude() ){
                	list.set(j,qj2);
                	list.set(j+1, qj1);
                }
    		}
    		
    		System.out.println("data after pass: "+i);
			
    		//for (QuakeEntry qe:list){
    		//	System.out.println(qe);
    		//}
    		if (checkInSortedOrder(list)){
    			break;    		
    		}
    	}
    }
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> list){
    	onePassBubbleSort(list, list.size()-1);
    	//checkInSortedOrder(list);
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> list){
    	for (int i=0; i< list.size()-1; i++){
    		QuakeEntry qi1 = list.get(i);
    		QuakeEntry qi2 = list.get(i+1);
    		
    		if ( qi1.getMagnitude() > qi2.getMagnitude() ){
    			return false;
    		}
    	}
    	return true;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> list){
    	onePassBubbleSort(list,list.size()-1);
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
    	for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if (checkInSortedOrder(in)){
            	break;
            }
            System.out.println("times: "+i);
        }
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "data/nov20quakedata.atom";
        //String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
        
        
        //String source = "D:\\duke\\level4\\EarthquakeSortStarterProgram\\data\\earthQuakeDataDec6sample1.atom";
        String source = "D:\\duke\\level4\\EarthquakeSortStarterProgram\\data\\earthQuakeDataWeekDec6sample1.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithCheck(list);
        //sortByMagnitudeWithBubbleSortWithCheck(list);
        System.out.println("final");
        int i=0;
        //for (QuakeEntry qe: list) { 
        //    System.out.println("num: "+ i + ";" +qe);
        //    i++;
        //} 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
}
