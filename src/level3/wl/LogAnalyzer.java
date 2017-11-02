
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package level3.wl;
import java.util.*;
import java.util.Map.Entry;

import edu.duke.*;
import edu.duke.*;
public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     //private ArrayList<LogEntry> recordsAtDay = new ArrayList<LogEntry>();
     private ArrayList<LogEntry> recordsAtRange = new ArrayList<LogEntry>();
     public ArrayList<String> unicIP = new ArrayList<String>();
     public LogAnalyzer() {
    	 records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         
    	 FileResource fr = new FileResource(filename);
    	 for (String line: fr.lines()){
    		 
    		 records.add(WebLogParser.parseEntry(line));
    	 }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public void countUniqueIPs (){
    	 for (LogEntry l:records){
    		 if (!unicIP.contains(l.getIpAddress()) ){
    			 unicIP.add(l.getIpAddress());
    			 //System.out.println(l.getAccessTime().toString());
    		 }
    	 }
    	 System.out.println(unicIP.size());
     }
     public void uniqueIPVisitsOnDay (String someday ){
    	 ArrayList<String> ips= new ArrayList<String>(); 
    	 for (LogEntry l:records){
    		 //Date tmp = WebLogParser.parseDate(someday);
    		 //System.out.println(l.getAccessTime().toString());
    		 //System.out.println(l.getAccessTime().toString());
    		 if ( l.getAccessTime().toString().contains(someday) ){
    			 //System.out.println(l.getIpAddress());
    			 if (!ips.contains( l.getIpAddress())){
    				 //recordsAtRange.add(l);
    				 ips.add(l.getIpAddress());
    			 }
    			 
    			 
    		 }
    		
    	 }
    	 System.out.println(ips.size());
    	 //System.out.println(recordsAtRange.size());
     }

	public void countUniqueIPsInRange(int low, int high) {
		ArrayList<String> ips= new ArrayList<String>(); 
		for ( LogEntry l: records){
			if ( low <= l.getStatusCode() && 
					l.getStatusCode() <= high ){
				if (!ips.contains( l.getIpAddress())){
   				 //recordsAtRange.add(l);
   				 ips.add(l.getIpAddress());
   			 }
				//System.out.println(l.getStatusCode());
   		 	}
			
		}
		//System.out.println(recordsAtRange.size());
		 System.out.println(ips.size());
	}

	public HashMap<String, Integer> countVisitsPerIP() {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for ( LogEntry l: records){
			if ( !map.containsKey(l.getIpAddress()) ){
				map.put(l.getIpAddress(), 1);
			}else{
				map.put(l.getIpAddress(), map.get(l.getIpAddress())+1);
			}
		}
		return map;
		
	}

	public int mostNumberVisitsByIP(HashMap<String, Integer> m) {
		// TODO Auto-generated method stub
		int maxV=-1;
		for (Entry<String, Integer> e: m.entrySet()){
			if ( maxV < e.getValue() ){
				maxV = e.getValue();
			}
		}
		return maxV;
		
	}

	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> m) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		int maxV=-1;
		for (Entry<String, Integer> e: m.entrySet()){
			if ( maxV < e.getValue() ){
				maxV = e.getValue();
			}
		}
		for (Entry<String, Integer> e: m.entrySet()){
			if ( maxV == e.getValue() ){
				list.add(e.getKey());
			}
		}
		return list;
	}

	public HashMap<String, ArrayList<String>> iPsForDays() {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
		for ( LogEntry l: records){
			String key=l.getAccessTime().toString();
			ArrayList<String> ips = new ArrayList<String>();
			if (!m.containsKey(key) ){
				ips.add(l.getIpAddress());
				m.put(key, ips);
			}else{
				ips=m.get(key);
				ips.add(l.getIpAddress());
				m.put(key, ips);
			}
		}
		return m;
	}

	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
		String day="";
		int maxIP=-1;
		for (Entry<String, ArrayList<String>> e: map.entrySet()){
			int tmpVal= e.getValue().size();
			if (maxIP<tmpVal){
				maxIP=tmpVal;
				day=e.getKey();
			}
		}
		return day;
	}

	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String myDay) {
		ArrayList<String> ips = new ArrayList<String>();
		int maxV=-1;
		for (Entry<String, ArrayList<String>> e: map.entrySet()){
			String key= e.getKey();
			
			if (key.contains(myDay)){
				if (maxV < e.getValue().size()){
					maxV= e.getValue().size();
				}
				for (String i: e.getValue()){
					if (! ips.contains(i)){
						ips.add(i);
					}
				}
				
			}
		}
		
		// TODO Auto-generated method stub
		return ips;
	}
     
}
