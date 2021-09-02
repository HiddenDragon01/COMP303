import java.util.*;

public class Show implements Watch, Binge {

    // Added field about Sequels and Prequels to use in Sequence methods

    Show Prequel;
    Show Sequel;

    // Set of episodes in a show

    private Set<Episode> aEpisodes = new HashSet<>();

    // Optional
    /**
     * Adds an episode to the set. Duplicate episodes aren't added twice.
     *
     * @param pEpisode
     *            the episode to add
     */

    public void addEpisode(Episode pEpisode) {
        aEpisodes.add(pEpisode);
    }

    // Watch a show
    @Override
    public void watch() {

        System.out.println("You just watched a show!");
    }

    // Let the client binge all the movies

    @Override
    public void bingeAll() {

        for (Episode e: aEpisodes) {
            e.watch();
        }

        int size = aEpisodes.size();
        System.out.println("You just binge-watched " + size + " episodes!!");
    }

    // Lets the client binge a certain number of movies

    public void bingeNumber(int amount) {
        int size = aEpisodes.size();
        if (amount > size) {
            System.out.println("You only have " + size +" episodes to binge!");
            return;
        }

        int stop = 0;

        for (Episode e: aEpisodes) {
            if (stop == amount) {
                break;
            }
            e.watch();
            stop++;
        }

        System.out.println("You just binge-watched " + amount + " episodes!!");
    }

    // Allows user to iterate through bingeable episodes
    @Override
    public Iterator<Episode> iterator() {
        return aEpisodes.iterator();
    }



}
