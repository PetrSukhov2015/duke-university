
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package level3.wl;
import java.util.*;
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
    	 for (LogEntry l:recordsAtRange){
    		 if (!unicIP.contains(l.getIpAddress()) ){
    			 unicIP.add(l.getIpAddress());
    		 }
    	 }
    	 System.out.println(unicIP.size());
     }
     public void uniqueIPVisitsOnDay (String someday ){
    	 for (LogEntry l:records){
    		 //Date tmp = WebLogParser.parseDate(someday);
    		 //System.out.println(l.getAccessTime().toString());
    		 //System.out.println(l.getAccessTime().toString());
    		 if ( l.getAccessTime().toString().contains(someday) ){
    			 recordsAtRange.add(l);
    		 }
    		
    	 }
    	 //System.out.println(recordsAtRange.size());
     }

	public void countUniqueIPsInRange(int low, int high) {
		for ( LogEntry l: records){
			if ( low <= l.getStatusCode() && 
					l.getStatusCode() <= high ){
				recordsAtRange.add(l);
				//System.out.println(l.getStatusCode());
   		 	}
			
		}
		//System.out.println(recordsAtRange.size());
		
	}
     
}
