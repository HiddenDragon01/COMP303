import java.io.File;
import java.util.*;

public class Episode implements Watch, Sequence {

    // Added field about Sequels and Prequels to use in Sequence methods, the user is NOT required
    // to set these fields
    Episode Prequel;
    Episode Sequel;

    private final File aPath;
    private Map<String, String> aTags = new HashMap<>();
    // Sequence Number to identify episode
    private int aSeqNumber;


    // Initialize Episode with file path and sequence number
    public Episode (File fPath, int pSeqNumber) {
        aPath = fPath;
        aSeqNumber = pSeqNumber;
    }

    /**
     * Sets the value of a custom tag.
     *
     * @param pKey
     *            the key used to retrieve the tag.
     * @param pValue
     *            the value of the tag to insert. Use null to remove the key.
     */
    public void setTag(String pKey, String pValue) {
        if (pValue == null) {
            aTags.remove(pKey);
        }
        else {
            aTags.put(pKey, pValue);
        }
    }

    /**
     * Retrieves the value of a custom tag.
     *
     * @param pKey
     *            the tag key, as it was inserted
     * @return the associated value
     */
    public String getTag(String pKey) {
        return aTags.get(pKey);
    }

    // Returns the sequence number of the episode

    public int getSeqNumber() {
        return aSeqNumber;
    }

    // Allows the user to watch the episode
    @Override
    public void watch() {
        System.out.println("You just watched an episode!");
    }


    // Implement methods for Sequence Interface

    @Override
    public Object getSequel() {
        assert Sequel != null;
        return Sequel;
    }

    @Override
    public Object getPrequel() {
        assert Prequel != null;
        return Prequel;
    }

    @Override
    public void setPrequel(Object pPrequel) {
        Episode newPrequel = (Episode)pPrequel;
        assert newPrequel != null;
        Prequel = newPrequel;
    }

    @Override
    public void setSequel(Object pSequel) {
        Episode newSequel = (Episode)pSequel;
        assert newSequel != null;
        Sequel = newSequel;
    }
}
