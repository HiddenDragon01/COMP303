package COMP310;
import java.util.*;

public class WatchList {

	private List<Movie> aList = new ArrayList<>();
	private String aName;
	
	
	public WatchList (String pName) {
		this.aName = pName;
	}
	
	public WatchList (WatchList w) {
		this.aList = w.getWatchList();
		this.aName = w.getName();
	}
	
	
	public String getName() {
		return this.aName;
	}
	
	public List<Movie> getWatchList() {
		return Collections.unmodifiableList(aList);
	}
	
	public Movie getMovie(int index) {
		
		Movie Item = this.aList.get(index);
		Movie cloneMovie = new Movie (Item);
		return cloneMovie;
		
	}
	
	public void setName (String pName) {
		this.aName = pName;
	}
	
	public void removeFirst() {
		aList.remove(0);
	}
	
	public HashSet<String> StudiosAndLanguages() {
		HashSet<String> hash = new HashSet<>();
		for (int i = 0; i < this.aList.size(); i++) {
			hash.add(aList.get(i).getReqStudio());
			hash.add(aList.get(i).getReqLanguage());
		}
		return hash;
	}
	
	public void addMovie (Movie pMovie) {
		Movie cloneMovie = new Movie (pMovie);
		this.aList.add(cloneMovie);
	}
	
	
	public int numValid() {
		int count = 0;
		for (int i = 0; i < this.aList.size(); i++) {
			if (this.aList.get(i).isValid()) {
				count++;
			}
		}
		return count;
	}
}
