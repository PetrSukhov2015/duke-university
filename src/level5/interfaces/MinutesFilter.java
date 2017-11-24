package level5.interfaces;

public class MinutesFilter implements Filter {
	private int minM;
	private int maxM;
	MinutesFilter(int minM, int maxM){
		this.minM=minM;
		this.maxM = maxM;
	}
	@Override
	public boolean satisfies(String id) {
		int curM = MovieDatabase.getMinutes(id);
		if (minM <=curM &&
				curM <= maxM){
			return true;
		}
		return false;
	}
	

}
