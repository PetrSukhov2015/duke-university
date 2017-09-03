import edu.duke.*;
public class FindAllGene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		testFindStopCodon();
	}
	
	public static int findStopCodon(String dna, int startInd, String stopCodon) {
		int currInd = dna.indexOf(stopCodon, startInd + 3);
		while (-1 != currInd ){ 
			if (-1 != startInd) {
				if (0 == (currInd - startInd) % 3) {
					return currInd;
				}else {
					currInd = dna.indexOf(stopCodon, currInd + 1);
				}
			}
		}
		// return dna.length();
		return -1;
	}

	public static String findGene(String dna, int ind) {
		int index = dna.indexOf("ATG",ind);
		if (-1==index){return "";}
		
		int indTaa = findStopCodon(dna, index, "TAA");
		int indTga = findStopCodon(dna, index, "TGA");
		int indTag = findStopCodon(dna, index, "TAG");
		
		int endInd = findMinInd(indTaa,indTga,indTag);
		if (-1==endInd){return "";}
		return dna.substring(index, endInd + 3);
	}

	private static int findMinInd(int taaIndex, int tgaIndex, int tagIndex) {
		int minIndex=0;
		if (taaIndex == -1 ||
	            (tgaIndex != -1 && tgaIndex < taaIndex)) {
	            minIndex = tgaIndex;
	        }
	        else {
	            minIndex = taaIndex;
	        }
	        if (minIndex == -1 ||
	            (tagIndex != -1 && tagIndex < minIndex)) {
	            minIndex = tagIndex;
	        }
		return minIndex;
	}

	public static StorageResource findAllGene(String dna) {
		StorageResource sr = new StorageResource();
		int ind = 0;
		int count =0;
		String curGene = "";
		while (true) {
			curGene = findGene(dna, ind);
			if (curGene.isEmpty()) {
				System.out.println("geneNum: "+count);
				break;
			}
			count++;
			sr.add(curGene);
			System.out.println(curGene);
			ind = dna.indexOf(curGene, ind ) ;
			ind = ind + curGene.length();
		}
		return sr;
	}
//testing method
	public static void testFindStopCodon() {
		
		int res = findStopCodon("AATGAAATTTGGGTAA", 1, "TAA");
		System.out.println(res);
		int r = findMinInd(1,2,3);
					// 1V V 2V V 3V V
		StorageResource genes = findAllGene("OATGFFFTAAATGSSSTAGATGTTTTGAEND");
		for (String gene: genes.data()){
			System.out.println(gene);
		}
		howMany("AA", "ATAAAA");
		//findAbc("abcd");
		//findAbc("abcdabc");
		findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
		findAbc("abcabcabcabca");
		
		System.out.println(cgRatio("ATCCCATGHHG"));
		countCTG("AATGCTGCTGGCTCTGTAA");
		
		StorageResource theSr= new StorageResource();
		theSr.add("ATC");
		theSr.add("AATGCTGCTGGCTCTGTAA");
		theSr.add("AATGCTGCTGGC");
		theSr.add("AAAAA");
		//processGenes(theSr);
		
		FileResource fr = new FileResource("D://duke//level2//GRch38dnapart2.fa");
		
		//FileResource fr = new FileResource("D://duke//level2//brca1line.fa");
		String dna = fr.asString().toUpperCase();
		//System.out.println(dna);
		System.out.println("!!!"+countCTG(dna));
		processGenes(findAllGene(dna));
		printUrl();
		cgRatio("CCC");
		cgRatio("CAA");
		cgRatio("CCA");
		cgRatio("GGG");
		cgRatio("CGA");
		//findAbc("abcbbbabcdddabc");

		//findAbc("aaaaabc");

		//findAbc("yabcyabc");

		//findAbc("woiehabchi");
	}

	private static void howMany(String stringa, String stringb) {
		int ind =0;
		int count =0;
		
		while (-1!=ind){
			ind=stringb.indexOf(stringa,ind);
			
			if (-1!=ind){
				count++;
				ind=ind+stringa.length();
			}
		}
		System.out.println(count);
		
	}
	public static void findAbc(String input) {
	    int index = input.indexOf("abc");
	    while (true) {
	        if (index == -1 || index >= input.length() - 3) {
	            break;
	        }
	        System.out.println(index);

	        //System.out.println(index+4);
	        String found = input.substring(index+1, index+4);
	        

	        
	        System.out.println(found);
	        index = input.indexOf("abc", index+3);
	    }
	}
	
	public static double cgRatio(String dna){
		double res=0;
		double len = dna.length();
		int index=0;
		while ( (-1 != (dna.indexOf("C",index))) ||
				(-1 != (dna.indexOf("G",index))) ){
			//check
			if ( (-1 == (dna.indexOf("C",index))) ||
				 (-1 != (dna.indexOf("G",index)) && dna.indexOf("G",index)<(dna.indexOf("C",index))) ){
					 index = dna.indexOf("G",index);
			}else{index=dna.indexOf("C",index);}
			if (-1==index){break;}
			res++;
			index++;
			
		}
		System.out.println(res/len);
		return res/len;
		
	}
	public static int countCTG(String dna){
		int ind=0;
		int res=0;
		while (true){
			ind=dna.indexOf("CTG",ind);
			if (-1==ind){break;}
			res++;
			ind+=3;
			
		}
		//System.out.println("res:"+res);
		return res;
	}
	
	public static void processGenes(StorageResource dna){
		System.out.println("-----------");
		int count9=0;
		int countCg=0;
		int longest=0;
		int countCtg=0;
		String longestG="";
		for (String gene: dna.data()){
			if (60< gene.length()){count9++;System.out.println("len9:"+gene);}
			if (0.35<cgRatio(gene)){countCg++;System.out.println("cgRat:"+gene);}
			if (longest<gene.length()){longest=gene.length(); longestG=gene;}
			
			countCtg+=countCTG(gene);
		}
		System.out.println("count of len9:"+count9);
		System.out.println("count of countCgRatio:"+countCg);
		System.out.println("longestG:"+longestG+" long:"+longest);
		System.out.println("countCtg:"+countCtg);
	}
	
	 public static void printUrl(){
	        URLResource webpage =   new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
	        for (String aline : webpage.lines()) {
	        	if (-1 !=aline.toLowerCase().indexOf("youtube")){
	            System.out.println(aline);}
	        }
	    }
}
	


