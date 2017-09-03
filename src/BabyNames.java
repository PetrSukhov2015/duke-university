import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class BabyNames {

	public static void main(String[] args) {
		testTotalBirths();
		//testGetRank();
		//testGetName();
		//testWhatIsNameInYear();
		//testYearOfHighestRank();
		//testGetAverageRank();
		//testGetTotalBirthsRankedHigher();
	}

	private static void testGetTotalBirthsRankedHigher() {
		int sumHR= getTotalBirthsRankedHigher(1990,"error","M");
		System.out.println(sumHR);
	}

	private static int getTotalBirthsRankedHigher(int y, String name, String gen) {
		// TODO Auto-generated method stub
		int sumR=-1;
		boolean nameExist=false;
		
		//FileResource fr = new FileResource("D://duke//level2//us_babynames_small//testing//yob"+y+"short.csv");
		
		FileResource fr = new FileResource("D://duke//level2//us_babynames//us_babynames_by_year//yob"+y+".csv");
		//"D://duke//level2//us_babynames_small//testing//yob"+y+"short.csv");
		for (CSVRecord rec:fr.getCSVParser(false)){
			if ( gen.equals(rec.get(1))	 ){
				
				if ( name.equals(rec.get(0))	 ){ nameExist=true;		break;}			//return sumR;				}
				if (-1==sumR){sumR=0;}
				sumR+=Integer.parseInt(rec.get(2));	
		
			}
			
		}
		if (!nameExist){System.out.println("name doesnot exist so result would be the sum of all gender names highter");}
		return sumR;
	}

	private static void testGetAverageRank() {
		double avgRank = getAverageRank("Error","M");//"Mason","M");
		if (0==avgRank){System.out.println("no name in files");}
		else {		System.out.println("avarege rank "+avgRank);}
		
	}

	private static double getAverageRank(String name, String gend) {
		double sumR = 0.0;
		double numR=0.0;
		DirectoryResource dr = new DirectoryResource();
		for (File f:dr.selectedFiles()){
			int year = getYearFromFile(f);			
			int tempRank= getRank(year,name,gend);
			if (-1!=tempRank){sumR+=tempRank; numR++;}
			
		}
				// TODO Auto-generated method stub
		if (0==sumR){return 0;}
		return sumR/numR;
	}

	private static void testYearOfHighestRank() {
		int hRankYear = yearOfHighestRank("Mich","M");
		if (0==hRankYear){System.out.println("no names in files");		}
		else {System.out.println(hRankYear);}
	}

	private static int yearOfHighestRank(String name, String gend) {
		int res =0;
		int rank=-1;
		int rankY=0;
		DirectoryResource dr = new DirectoryResource();
		for (File f:dr.selectedFiles()){
			int year = getYearFromFile(f);			
			int tempRank = getRank(year,name,gend);
			
			if (-1==tempRank||rank>tempRank){rank=tempRank;rankY=year;}
			
		}
		//System.out.println(rank);
		if (-1==rank){rankY=0;}
		return rankY;
	}

	private static int getYearFromFile(File f) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(f.getName());
		m.find();
		return Integer.parseInt(m.group());
	}

	private static void testWhatIsNameInYear() {
		whatIsNameInYear("Error",1974,2014,"M");
		
	}

	private static void whatIsNameInYear(String name, int y, int nY, String gend) {
		int rank = getRank(y,name,gend);
		if ( -1 != rank){
			String newName = getName(nY,rank,gend);
			System.out.println(name+"born in "+y+" would be "+newName+" in "+nY);
		}else{System.out.println("NO NAME");}
		
	}

	private static void testGetName() {
		String name = getName(1980,450,"F");
		System.out.println("name:"+name);
		
	}

	private static String getName(int y, int rank, String gen) {
		FileResource fr = new FileResource("D://duke//level2//us_babynames//us_babynames_by_year//yob"+y+".csv");
		//"D://duke//level2//us_babynames_small//testing//yob"+y+"short.csv");
		int tempRank=0;
		for (CSVRecord rec:fr.getCSVParser(false)){
			if ( gen.equals(rec.get(1))	 ){
				tempRank+=1;
				if (rank==tempRank){
					return rec.get(0);
				}
			}
		}
		return "NO NAME";
	}

	private static void testGetRank() {
		int rank = getRank(1971,"Error","M");
		System.out.println("rank:"+rank);
	}

	private static int getRank(int y, String name, String gen) {
		int res=-1;
		int rank=0;
		FileResource fr = new FileResource("D://duke//level2//us_babynames//us_babynames_by_year//yob"+y+".csv");
				//"D://duke//level2//us_babynames_small//testing//yob"+y+"short.csv");
		for (CSVRecord rec:fr.getCSVParser(false)){
			if ( gen.equals(rec.get(1))	 ){
				rank+=1;
				if ( name.equals(rec.get(0))	 )
					return rank;
				
			}
		}
		return res;
		
	}

	private static void testTotalBirths() {
		FileResource fr = new FileResource();//"D://duke//level2//us_babynames_small//testing//yob2012short.csv");
		//totalBirths(fr);
		totalOrders(fr);
		
	}

	private static void totalOrders(FileResource fr) {
		CSVParser parser = fr.getCSVParser(false);
		int foodN=0;
		int drinkN=0;
		for (CSVRecord rec: parser){
			int tempN =Integer.parseInt(rec.get(2));
			//totalN+=tempN;
			if ( "D".equals(rec.get(1)) ){drinkN+=tempN;}
			if ( "F".equals(rec.get(1)) ){foodN+=tempN;}
			System.out.println("Name: "+rec.get(0)+"; "+"total: "+rec.get(2));
		}
		System.out.println("food num:\n"+"drinkN: "+drinkN+"; "+"foodN: "+foodN+";");
		
	}

	private static void totalBirths1(FileResource fr) {
		CSVParser parser = fr.getCSVParser(false);
		
		int totalN=0;
		
		int boysN=0;
		int girlsN=0;
		for (CSVRecord rec: parser){
			int tempN =Integer.parseInt(rec.get(2));
			totalN+=tempN;
			if ( "M".equals(rec.get(1)) ){boysN+=tempN;}
			if ( "F".equals(rec.get(1)) ){girlsN+=tempN;}
			System.out.println("Name: "+rec.get(0)+"; "+"total: "+rec.get(2));
		}
		System.out.println("totalN: "+totalN+"; "+"boysN: "+boysN+"; "+"girlsN: "+girlsN+";");
		
	}
	public static void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int boysNameNum=0;
		int girlsNameNum=0;
		
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				boysNameNum++;
				totalBoys += numBorn;
			}
			else {
				girlsNameNum++;
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
		System.out.println("boysNameNum = " + boysNameNum);
		System.out.println("girlsNameNum = " + girlsNameNum);
	}

}
