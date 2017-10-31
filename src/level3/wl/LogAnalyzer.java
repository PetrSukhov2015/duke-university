
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
     
     public LogAnalyzer() {
    	 records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         
    	 FileResource fr = new FileResource(filename);
    	 for (String line: fr.lines()){
    		 
    		 records.add(new LogEntry(line));
    	 }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
