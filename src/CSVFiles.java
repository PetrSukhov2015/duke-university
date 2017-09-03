
import edu.duke.*;

import java.io.File;

import org.apache.commons.csv.*;
public class CSVFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//tester();
		//testColdestHourInFile();
		//testFileWithColdestTemperature();
		//testLowestHumidityInFile();
		//testLowestHumidityInManyFiles();
		//testAverageTemperatureInFile();
		//testAverageTemperatureWithHighHumidityInFile();
	}

	private static void testAverageTemperatureWithHighHumidityInFile() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		double avgTemp = averageTemperatureWithHighHumidityInFile(parser,80);
		if (0!=avgTemp){		System.out.println("Average temperature in file is: "+avgTemp );}
		else {System.out.println("No temperatures with that humidity" );}
		
	}

	private static double averageTemperatureWithHighHumidityInFile(CSVParser parser, double humLevel) {
		double res=0.0;
		double temp= 0.0;
		double tempHum=0.0;
		double num=0.0;
		for (CSVRecord rec:parser){
			if ( !("N/A".equals(rec.get("Humidity"))) && 
					(humLevel <= Double.parseDouble(rec.get("Humidity"))) ){
				
				temp = Double.parseDouble(rec.get("TemperatureF"));
				if ( -9999 != temp){res+=temp;num++;}
			}
			
		}
		return res/num;
		
	}

	private static void testAverageTemperatureInFile() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		double avgTemp = averageTemperatureInFile(parser);
		System.out.println("Average temperature in file is: "+avgTemp );
		
		
	}

	private static double averageTemperatureInFile(CSVParser parser) {
		double res=0.0;
		double temp= 0.0;
		double num=0.0;
		for (CSVRecord rec:parser){
			temp = Double.parseDouble(rec.get("TemperatureF"));
			if ( -9999 != temp){res+=temp;num++;}
		}
		return res/num;
		
	}

	private static void testLowestHumidityInManyFiles() {
		CSVRecord csv = lowestHumidityInManyFiles();
		System.out.println("the lowest humid in files was: "+csv.get("Humidity")+" at "+csv.get("DateUTC") );
		
		
	}

	private static CSVRecord lowestHumidityInManyFiles() {
		CSVRecord lowestHum = null;
		String fileName = null;
		DirectoryResource dr = new DirectoryResource();
		for (File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser();
			CSVRecord temp = lowestHumidityInFile(parser);
			
			lowestHum = findLowestHumOfTwoRecords(temp,lowestHum);
			
		}
		return lowestHum;
	}

	private static void testLowestHumidityInFile() {
		// TODO Auto-generated method stub
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		System.out.println("the lowest humid was: "+csv.get("Humidity")+" at "+csv.get("DateUTC") );
		
	}

	private static CSVRecord lowestHumidityInFile(CSVParser parser) {		
		CSVRecord lowHumRecordInFile = null;		
		for (CSVRecord rec:parser){		
			lowHumRecordInFile = findLowestHumOfTwoRecords(rec,lowHumRecordInFile);
		}
		return lowHumRecordInFile;
	}

	private static CSVRecord findLowestHumOfTwoRecords(CSVRecord rec, CSVRecord lowHumRecordInFile) {
		if (null == lowHumRecordInFile){return rec;}
		else{
			if (!("N/A".equals(rec.get("Humidity")))){
				double lowest = Double.parseDouble(lowHumRecordInFile.get("Humidity"));
				double re = Double.parseDouble(rec.get("Humidity"));
			
				if (lowest>re){lowHumRecordInFile=rec;}
			}
			
			
		}
		return lowHumRecordInFile;
		
	}

	private static void testFileWithColdestTemperature() {
		String coldestDay = fileWithColdestTemperature();
		System.out.println("the coldest day is: "+coldestDay);
		
	}

	private static String fileWithColdestTemperature() {
		// TODO Auto-generated method stub
		CSVRecord coldestRecordInFile = null;
		
		String fileName=null;
		String fileAbsPath=null;
		
		DirectoryResource dr = new DirectoryResource();
		
		for (File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord tempRec = coldestHourInFile(fr.getCSVParser());
			fileName=f.getName();
			fileAbsPath=f.getAbsolutePath();
			
			coldestRecordInFile= findColdestTempOfTwoRecords(tempRec,coldestRecordInFile);
			if (coldestRecordInFile != tempRec){
				fileName=f.getName();
				fileAbsPath=f.getAbsolutePath();
			}
			
		}
		
		System.out.println("coldesrt temp"+coldestRecordInFile.get("DateUTC")+" "+coldestRecordInFile.get("TemperatureF"));
		FileResource fr = new FileResource(fileAbsPath);
		CSVParser parser = fr.getCSVParser();
		
		for (CSVRecord record: parser){
			System.out.println(record.get("DateUTC")+" "+record.get("TemperatureF"));
			
		}
		return fileName;
	}

	private static void testColdestHourInFile() {
		// TODO Auto-generated method stub
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord coldestHour = coldestHourInFile(parser);
		System.out.println(coldestHour.get("TemperatureF")+" "+coldestHour.get("DateUTC"));
	}

	private static CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord coldestTemp=null;
		for (CSVRecord record: parser){
			coldestTemp=findColdestTempOfTwoRecords(record,coldestTemp);
		}
		return coldestTemp;
	}

	private static CSVRecord findColdestTempOfTwoRecords(CSVRecord record, CSVRecord coldestTemp) {
		if (null == coldestTemp){return record;}
		else{
			double coldest = Double.parseDouble(coldestTemp.get("TemperatureF"));
			double rec = Double.parseDouble(record.get("TemperatureF"));
			
			if (-9999!=rec && coldest>rec){coldestTemp=record;}
		}
		return coldestTemp;
	}

	private static void tester() {
		// TODO Auto-generated method stub
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
		//country info
		String country = "Nauru";//"Germany"
		String info = countryInfo(parser,"Nauru");
		System.out.println("info about country: "+info);
		
		//2 items
		parser = fr.getCSVParser();
		//listExportersTwoProducts(parser,"tee","coffee");
		String theItemA="cotton";//"fish";//gold
		String theItemB="flowers";//"nuts";//diamond
		
		listExportersTwoProducts(parser,theItemA,theItemB);
		//System.out.println(multyExportCountry);
		
		//1 item
		parser = fr.getCSVParser();
		int itemNum = numberOfExporters(parser,"cocoa");
		System.out.println("numberOfExporter: "+itemNum);
		
		//value
		parser = fr.getCSVParser();
		String value= "$999,999,999,999";//"$400,000,000"
		bigExporters(parser,value);
	}

	private static void bigExporters(CSVParser parser, String myValue) {
		for (CSVRecord record :parser){
			String value = record.get("Value (dollars)");
			if (value.length()> myValue.length() ){
				System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
			}
		}
		
	}

	private static int numberOfExporters(CSVParser parser, String item) {
		int res=0;
		for (CSVRecord record :parser){
			String exports = record.get("Exports");
			if (exports.contains(item) ){
				res++;
			}
		}
		return res;
	}

	private static void listExportersTwoProducts(CSVParser parser, String itemA, String itemB) {
		for (CSVRecord record :parser){
			String exports = record.get("Exports");
			if (exports.contains(itemA) && exports.contains(itemB)){
				System.out.println("we export two items:" + record.get("Country"));//+" "+record.get("Exports")+" "+record.get("Value (dollars)");
			}
		}
		//return "NOT FOUND";
		
	}

	private static String countryInfo(CSVParser parser, String country) {
		for (CSVRecord record :parser){
			String myCountry = record.get("Country");
			if (myCountry.contains(country)){
				return record.get("Country")+" "+record.get("Exports")+" "+record.get("Value (dollars)");
			}
		}
		return "NOT FOUND";
	}
	
}
