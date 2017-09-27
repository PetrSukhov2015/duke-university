package level4.earthquake.task;

public class MagnitudeFilter implements Filter{
	private double minMag=0.0;
	private double maxMag=0.0;
	private final static String FILTER_NAME="DepthFilter";
	
	public MagnitudeFilter(double min, double max){
		minMag=min;
		maxMag=max;
	}
	public boolean satisfies(QuakeEntry qe){
		if ( (minMag <= qe.getMagnitude()) &&
				(qe.getMagnitude() <= maxMag) ){
				return true;
		}
		return false;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return FILTER_NAME;
	}
}
