package level4.earthquake.task;

public interface Filter {
	public  boolean satisfies(QuakeEntry qe); 
	public String getName();
}
