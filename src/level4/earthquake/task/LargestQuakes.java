package level4.earthquake.task;
import java.util.*;
import java.util.ArrayList;

public class LargestQuakes {
	public void findLargestQuakes(){
		EarthQuakeParser parser = new EarthQuakeParser();
        
		String source = "D:\\duke\\level4\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        for (QuakeEntry qe: list){
        	System.out.println(qe);
        }
        System.out.println("read data for "+list.size()+" quakes");
        int indLagest = indexOfLargest(list);
        System.out.println("index of lagest: "+indLagest+ 
        		"\ninfo: "+list.get(indLagest));
        ArrayList<QuakeEntry> topMagList  = getLargest(list,5);
        System.out.println("read data for topMagList "+topMagList.size()+" quakes");
        
        for (QuakeEntry qe: topMagList){
        	System.out.println(qe);
        }
        
        
	}

	private ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> list, int num) {
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(list);
		ArrayList<QuakeEntry> lagMagList = new ArrayList<QuakeEntry>();
		
		int tmpInd=-1;
		for (int i=0; i< num; i++){
			for (QuakeEntry qe: copy){
				tmpInd=indexOfLargest(copy);
	        }
			lagMagList.add(copy.get(tmpInd));
			copy.remove(tmpInd);
			
		}
		return lagMagList;
	}

	private int indexOfLargest(ArrayList<QuakeEntry> list) {
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(list);
		int index=-1;
		double maxMag=0.0;
		for (int i=0; i<copy.size(); i++){
			double tmpMag= copy.get(i).getMagnitude();
			if ( maxMag< tmpMag){
				maxMag= tmpMag;
				index=i;
			}
		}
		return index;
	}
}
