import java.io.Serializable;
import java.util.LinkedList;

/*
 * Cache java stores data in a list and can be turned Serializable. 
 * Defines getObject, addObject, removesObject, clear, and toString methods. 
 */
public class Cache<T> implements Serializable {
    LinkedList<T> list = new LinkedList<T>();
    int cacheSize; //T or int?
    int numRefs = 0;
    int numHits = 0;
    double numHitRat = 0.0;
 
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
     *  @param object
     */
    public T getObject(T object) {
        T returnObj = object;
        for (T obj: list) {
            if (obj.equals(object)) {
                addObject(object);
                return obj;
            } else if (cacheSize == list.size()) {
                list.removeLast();
                addObject(object);
                return obj; 
            } else {
                addObject(object);
                return obj;
            }         
        }
        return returnObj;
    }

    /*
     * Adds object in front of Cache.
     */
    public void addObject(T object) {
        list.addFirst(object);
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
        String cacheList = "The total number of reference " + numRefs 
        + " Total number of cache hits: " + numHits + " Cache hit ratio: " 
        + numHitRat + "%";

        return cacheList;
    }
    
}