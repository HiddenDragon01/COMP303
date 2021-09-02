import java.util.*;

/**
 * Represents a sequence of movies to watch in FIFO order.
 */
public class WatchList implements Binge {

    private final List<Movie> aList = new LinkedList<>();
    private final List<Episode> aEpisodeList = new LinkedList<>();
    private String aName;


    public String getName() {
        return aName;
    }

    /**
     * Changes the name of this watchlist.
     *
     * @param pName
     *            the new name
     */
    public void setName(String pName) {
        aName = pName;
    }

    /**
     * Adds a movie at the end of this watchlist.
     *
     * @param pMovie
     *            the movie to add
     */
    public void addMovie(Movie pMovie) {
        aList.add(pMovie);
    }


    /**
     * Adds an episode at the end of this episode watchlist.
     *
     * @param pEpisode
     *            the episode to add
     */
    public void addEpisode(Episode pEpisode) {
        aEpisodeList.add(pEpisode);
    }

    /**
     * Retrieves and removes the next movie to watch from this watchlist. Movies are retrieved in FIFO order.
     */
    public Movie removeNext() {
        return aList.remove(0);
    }

    /**
     * Retrieves the list of movies (valid and invalid) in this watchlist.
     *
     * @return an unmodifiable list of movies, backed by this watchlist
     */
    public List<Movie> getMovies() {
        return Collections.unmodifiableList(aList);
    }

    /**
     * Counts and returns the number of valid movies in this watchlist.
     *
     * @return the number of valid movies
     */
    public int getNumberMovies() {
        int count = 0;
        for (Movie movie : aList) {
            if (movie.isValid()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retrieves the list of all publishing studios, without duplicates, but including studios of invalid movies.
     *
     * @return a set of studios
     */
    public Set<String> getStudios() {
        Set<String> studios = new HashSet<>();
        for (Movie movie : aList) {
            studios.add(movie.getStudio());
        }
        return studios;
    }

    /**
     * Retrieves the list of all languages, without duplicates, but including languages of invalid movies.
     *
     * @return a set of languages
     */
    public Set<String> getLanguages() {
        Set<String> languages = new HashSet<>();
        for (Movie movie : aList) {
            languages.add(movie.getLanguage());
        }
        return languages;
    }
    // Allows the client to binge all movies in WatchList
    @Override
    public void bingeAll() {

        for (Movie m: aList) {
            m.watch();
        }


        int size = aList.size();
        System.out.println("You just binge-watched " + size + " movies!!");
    }
    // Allows the client to binge a certain number of movies in the WatchList
    public void bingeNumber(int amount) {
        int size = aList.size();
        if (amount > size) {
            System.out.println("You only have " + size + " movies to binge!");
            return;
        }

        int stop = 0;

        for (Movie m: aList) {

            if (stop == amount) {
                break;
            }
            m.watch();
            stop++;
        }

        System.out.println("You just binge-watched " + amount + " movies!!");
    }

    // Allows user to iterate through bingeable movies
    @Override
    public Iterator<Movie> iterator() {
        return aList.iterator();
    }
}

