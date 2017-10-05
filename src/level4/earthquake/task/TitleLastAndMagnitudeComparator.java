package level4.earthquake.task;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator <QuakeEntry>{

	@Override
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {
		String qe1Info = qe1.getInfo();
		String qe1lWord = qe1Info.substring(qe1Info.lastIndexOf(" ")+1);
		String qe2Info = qe2.getInfo();
		String qe2lWord = qe2Info.substring(qe2Info.lastIndexOf(" ")+1);
		//System.out.println(qe1lWord);
		//System.out.println(qe1Ingo);
		int res = qe1lWord.compareTo(qe2lWord);
		if (0==res){
			return Double.compare(qe1.getMagnitude(), qe2.getMagnitude() );
		}
		return res;
	}
	
}
