package level5.rdb;

public class GenreFilter implements Filter {

	private String genre;
	public GenreFilter(String genre){
		this.genre=genre;
	}
	@Override
	public boolean satisfies(String id) {
		if (MovieDatabase.getGenres(id).toLowerCase().trim().contains(genre.toLowerCase().trim())){
			return true;
		}
		return false;
	}

}
