import java.util.*;

/**
 * Represents a movie library, with individual movie titles and watch lists.
 */
public class Library {

    private Set<Movie> aMovies = new HashSet<>();
    private Set<WatchList> aWatchLists = new HashSet<>();
    private Set<Show> aShows = new HashSet<>();


    // Optional
    /**
     * Adds a movie to the library. Duplicate movies aren't added twice.
     *
     * @param pMovie
     *            the movie to add
     */
    public void addMovie(Movie pMovie) {
        aMovies.add(pMovie);
    }

    // Optional
    /**
     * Adds a watchlist to the library. All movies from the list are also added as individual movies to the library.
     *
     * @param pList
     *            the watchlist to add
     */
    public void addWatchList(WatchList pList) {
        aWatchLists.add(pList);
        for (Movie movie : pList.getMovies()) {
            addMovie(movie);
        }
    }

    // Optional
    /**
     * Adds a show to the library. Duplicate shows aren't added twice.
     *
     * @param pShow
     *            the show to add
     */

    // Adds show to show list
    public void addShow(Show pShow) {
        aShows.add(pShow);
    }

    // First generate WatchList method
    public class gen<T> implements generateWatchList<T>{

        // Generate English WatchList in Studios of Client's choice
        public WatchList generate(T Studios) {

            WatchList w = new WatchList();
            String l = "English";
            Set<String> s = (Set<String>) Studios;

            for (Movie m: aMovies) {

                if ((s.contains(m.getStudio())) && m.getLanguage().equals(l)) {
                    w.addMovie(m);
                }
            }

            return w;

        }



    }

    // Second generate WatchList method
    public class gen2<T> implements generateWatchList<T> {

        // Generate WatchList with 10 random episodes from the shower of the client's choice
        @Override
        public WatchList generate(T pShow) {

            WatchList w = new WatchList();
            Show s = (Show)pShow;

            int count = 0;

            for (Iterator<Episode> it = s.iterator(); it.hasNext();) {

                if (count == 10) {
                    break;
                }

                w.addEpisode(it.next());
                count++;

            }

            if (count != 10) {
                throw new IllegalArgumentException("Can't generate a watchlist with that show.");
            }

            return w;


        }



    }



}

