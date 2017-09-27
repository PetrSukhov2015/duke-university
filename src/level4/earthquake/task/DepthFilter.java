package level4.earthquake.task;

public class DepthFilter implements Filter{
	private double minDepth=0.0;
	private double maxDepth=0.0;
	private final static String FILTER_NAME="DepthFilter";
	public DepthFilter(double min, double max) {		
		minDepth=min;
		maxDepth=max;
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		if ( (minDepth < qe.getDepth()) &&
				(qe.getDepth() < maxDepth) ){
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
