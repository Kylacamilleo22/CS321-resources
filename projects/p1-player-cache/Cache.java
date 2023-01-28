import java.io.Serializable;
import java.util.LinkedList;

/*
 * Cache java stores data in a list and can be turned Serializable. 
 * Defines getObject, addObject, removesObject, clear, and toString methods. 
 */
public class Cache<T> implements Serializable {
    LinkedList<T> list = new LinkedList<T>();
    public int cacheSize;
    public int numRefs = 0;
    public int numHits = 0;
    public double numHitRat = 0.0;
 
    /*
     * Simple constructor for Cache.
     * @param cacheSize
     */
    public Cache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    /*
     * Scans the Cache and finds the object. 
     * If not in list, add object.
     * If Cache is full, remove last object in list
     * and add new object in front.
     * @param object
     */
    public T getObject(T object) {
        ++numRefs;
        if (list.contains(object)) {
            ++numHits;
            //addObject(object);
            return object;
        }
        else {
            return null;
        }
    }

    /*
     * Adds object in front of Cache.
     */
    public void addObject(T object) {
        if (cacheSize == list.size()) {
            list.removeLast();
            list.addFirst(object);
        }
    }

    /*
     * Simply removes object.
     */
    public void removeObject(T object) {
        list.remove(object);
    }

    /*
     * Clears Cache list.
     */
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        numHitRat = ((double) numHits / numRefs) * 100;
        String totalNumRefs = "The total number of reference:        ";
        String totalNumHits = "\nTotal number of cache hits:        "; 
        String cacheHitRatio = "\nCache hit ratio:        ";
        String cacheList = totalNumRefs + numRefs 
        + totalNumHits + numHits + cacheHitRatio
        + numHitRat + "%\n";
        
        return cacheList;
    }

}
