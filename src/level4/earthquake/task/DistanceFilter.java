package level4.earthquake.task;

public class DistanceFilter implements Filter{
	private Location loc =null;
	private int maxDist=0;
	private final static String FILTER_NAME="DistanceFilter";
	
	public DistanceFilter(Location l, int dist) {
		loc=l;
		maxDist=dist;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		if ( qe.getLocation().distanceTo(loc) <= maxDist){
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
