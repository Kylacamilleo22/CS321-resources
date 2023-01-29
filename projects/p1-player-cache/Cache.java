import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * The Cache class stores data in a list and can be turned Serializable. 
 * Defines getObject, addObject, removesObject, clear, and toString methods. 
 */
public class Cache<T> implements Serializable {
    LinkedList<T> list = new LinkedList<T>();
    public int cacheSize;
    public int numRefs = 0;
    public int numHits = 0;
    public double numHitRat = 0.0;
 
    /**
     * Simple constructor for Cache.
     * Sets the size of cache.
     * @param cacheSize
     */
    public Cache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    /**
     * Scans the Cache and finds the object. 
     * If not in list, return null
     * If in list, increment numHits and return object.
     * @param object
     * @return object
     */
    public T getObject(T object) {
        ++numRefs;
        if (list.contains(object)) {
            ++numHits;
            return object;
        }
        else {
            return null;
        }
    }

    /**
     * Adds object in front of Cache.
     * @param object
     */
    public void addObject(T object) {
        if (cacheSize == list.size()) {
            list.removeLast();
        }
        list.addFirst(object);       
    }

    /**
     * Simply removes object.
     * @param object
     */
    public void removeObject(T object) {
        list.remove(object);
    }

    /**
     * Clears Cache list.
     */
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        numHitRat = ((double) numHits / numRefs) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String totalNumRefs = "Total number of references:           ";
        String totalNumHits = "\nTotal number of cache hits:           "; 
        String cacheHitRatio = "\nCache hit ratio:                      ";
        String cacheList = totalNumRefs + numRefs 
        + totalNumHits + numHits + cacheHitRatio
        + df.format(numHitRat) + "%\n";
        
        return cacheList;
    }

}
