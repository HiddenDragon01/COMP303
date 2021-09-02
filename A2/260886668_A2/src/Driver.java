import java.io.File;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Driver {

    public static void main(String[] args) {
        // Create files
        File x = new File("Bowser");
        File y = new File("Toad");
        File z = new File("Mario");
        File h = new File("Peach");
        File j = new File("Luigi");
        File k = new File("Waluigi");


        // Create movies, episodes, shows, watchlists, library
        Movie m = new Movie(x, "Numéro 1", "English", "Ravel");
        Movie m1 = new Movie(y, "Numéro 2", "Allemande", "Brahms");
        Movie m2 = new Movie(z, "Numéro 3", "English", "Mozart");
        Movie m3 = new Movie(h, "Numéro 4", "English", "Beethoven");
        Movie m4 = new Movie(j, "Numéro 5", "English", "Ravel");
        Movie m5 = new Movie(k, "Numéro 6", "Allemande", "Ravel");

        Episode e = new Episode(x,1);
        Episode e2 = new Episode(y,2);
        Episode e3 = new Episode(z,3);
        Episode e4 = new Episode(h,4);
        Episode e5 = new Episode(j,5);
        Episode e6 = new Episode(k,6);
        Episode e7 = new Episode(x,7);
        Episode e8 = new Episode(y,8);
        Episode e9 = new Episode(k,9);
        Episode e10 = new Episode(x,10);

        Show s = new Show();
        Show s1 = new Show();
        s.addEpisode(e);
        s.addEpisode(e2);
        s.addEpisode(e3);
        s.addEpisode(e4);
        s.addEpisode(e5);
        s.addEpisode(e6);
        s.addEpisode(e7);
        s.addEpisode(e8);
        s.addEpisode(e9);
        s.addEpisode(e10);

        Library l = new Library();
        l.addShow(s);
        l.addShow(s1);
        l.addMovie(m);
        l.addMovie(m1);
        l.addMovie(m2);
        l.addMovie(m3);
        l.addMovie(m4);
        l.addMovie(m5);

        WatchList w = new WatchList();
        w.setName("Regarder");
        w.addMovie(m);
        w.addMovie(m1);
        w.addEpisode(e);
        w.addEpisode(e2);

        System.out.println("Calling watch on a Movie, Episode, and TV show:");
        m.watch();
        e.watch();
        s.watch();

        System.out.println("Binging all movies in watchlist:");
        w.bingeAll();

        System.out.println("Binging a single movie in the watchlist:");
        w.bingeNumber(1);

        System.out.println("Binging all episodes in show:");
        s.bingeAll();

        System.out.println("Binging 3 episodes in the show:");
        s.bingeNumber(3);

        System.out.println("Setting m1 to be m's sequel and then printing m1's language");
        m.setSequel(m1);
        Movie mcopy = (Movie)m.getSequel();
        System.out.println(mcopy.getLanguage());

        System.out.println("Iterating through movies in watchlist and printing the language of each movie");

        for (Iterator<Movie> it = w.iterator(); it.hasNext();) {
            System.out.println(it.next().getLanguage());
        }

        // Create objects to use generate methods
        Library.gen2 innerObject = l.new gen2();
        Library.gen innerObject1 = l.new gen();

        // Create an English watchlist with Ravel and Beethoven studios

        Set<String> spec = new HashSet<String>();
        spec.add("Ravel");
        spec.add("Beethoven");
        WatchList gen2watch = innerObject1.generate(spec);


        // Randomly generate episodes from show at index 0 in Library
        WatchList genwatch = innerObject.generate(s);


    }
}
