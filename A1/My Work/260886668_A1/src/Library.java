package COMP310;
import java.util.*;


public class Library {
	
	private List<Movie> aMovieList = new ArrayList<>();
	private List<WatchList> aWatchList = new ArrayList<>();
	
	public void addMovie(Movie pMovie) {
		Movie cloneMovie = new Movie (pMovie);
		this.aMovieList.add(cloneMovie);
	}
	
	public void addWatchList(WatchList pWatchList) {
		
		for (int i = 0; i < aWatchList.size(); i++) {
			
			if (pWatchList.getName() == aWatchList.get(i).getName()) {
				return;
			}	
		}
		
		WatchList cloneWatchList = new WatchList (pWatchList);
		this.aWatchList.add(cloneWatchList);
	}
	
	public Movie getMovie(int index) {
		Movie cloneMovie = new Movie (this.aMovieList.get(index));
		return cloneMovie;
	}
	
	public WatchList getWatchList(int index) {
		WatchList cloneWatch = new WatchList (this.aWatchList.get(index));
		return cloneWatch;
	}
	
}
