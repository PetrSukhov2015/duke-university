package level4.earthquake.task;

import java.util.ArrayList;
import java.util.Collections;

public class DifferentSorters {
	public void sortWithCompareTo(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "D:\\duke\\level4\\EarthquakeSortStarterProgram\\data\\earthQuakeDataWeekDec6sample2.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        //for (int i=0; i< 601; i++){
        //	System.out.println(list.get(i));
        //}
        int quakeNumber = 600;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
        
	}

	public void sortByTitleAndDepth() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "D:\\duke\\level4\\EarthquakeSortStarterProgram\\data\\earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleAndDepthComparator());
        //for (int i=0; i< 14; i++){
        //	System.out.println(list.get(i));
        //}
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
        
        
	}
	
	public void sortByLastWordInTitleThenByMagnitude(){
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "D:\\duke\\level4\\EarthquakeSortStarterProgram\\data\\earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        //for (int i=0; i< 14; i++){
        //	System.out.println(list.get(i));
        //}
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
		
	}
	
}
