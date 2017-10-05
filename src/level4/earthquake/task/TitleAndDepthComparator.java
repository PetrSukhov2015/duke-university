package level4.earthquake.task;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator <QuakeEntry>{

	@Override
	public int compare(QuakeEntry qe1, QuakeEntry qe2) {
		// TODO Auto-generated method stub
		int res = qe1.getInfo().compareTo(qe2.getInfo());
		if (res == 0){
			return Double.compare(qe1.getDepth(), qe2.getDepth());
		}
		return res;
	}
	

}
