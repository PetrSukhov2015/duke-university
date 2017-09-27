package level4.earthquake.task;

import java.util.ArrayList;

public class MatchAllFilter implements Filter{
	private ArrayList<Filter> filters = null;
	
	
	public MatchAllFilter() {
		filters = new ArrayList<Filter>();
		// TODO Auto-generated constructor stub
	}
	public void addFilter(Filter f){
		filters.add(f);
	}
	@Override
	public boolean satisfies(QuakeEntry qe) {
		for (Filter f: filters){
			if (false==f.satisfies(qe)){
				return false;
			}
		}
		return true;
	}
	@Override
	public String getName() {
		String fNames="";
		for (Filter f: filters){
			fNames+=f.getName()+" ";
		}
		return fNames;
	}

}
