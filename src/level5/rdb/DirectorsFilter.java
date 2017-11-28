package level5.rdb;

public class DirectorsFilter implements Filter{

	private String directors;
	public DirectorsFilter(String directors ){
		this.directors =directors ;
	}
	@Override
	public boolean satisfies(String id) {
		String [] dirs = directors.split(",");
		for (String dir: dirs){
			dir=dir.trim();
			if ( MovieDatabase.getDirector(id).contains(dir) ){
				return true;
			}
		}
		
		
		return false;
	}

}
