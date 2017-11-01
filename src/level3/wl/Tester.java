
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package level3.wl;
import java.util.*;

public class Tester{
	public static void main(String[] args){
		//testLogEntry();
		//testLogAnalyzer();
		testUniqueIP();
		
	}
    private static void testUniqueIP() {
    	LogAnalyzer la = new LogAnalyzer();
        la.readFile("D://duke//level3//_webLog//WebLogProgram//weblog1_log");
        //
        la.countUniqueIPsInRange(300,399);
        //la.uniqueIPVisitsOnDay("Mar 17");
		la.countUniqueIPs();
	}
	public static void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public static void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D://duke//level3//_webLog//WebLogProgram//short-test_log");
        la.printAll();
        
    }
}
