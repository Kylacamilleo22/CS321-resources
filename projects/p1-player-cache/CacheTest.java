import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * This CacheTest reads a serialized data file of Player objects, 
 * and parses into player objects. 
 */
public class CacheTest { 
    
    /**
     * Reads in and deserialize the file, iterate through list, and 
     * add or remove to the list.
     * @param fileName
     * @param cacheSize
     * @return cache
     */
    @SuppressWarnings("unchecked")
    public static Cache<Player> runTest(String fileName, int cacheSize) {
        Cache<Player> cache = new Cache<Player>(cacheSize);        

        FileInputStream fileIn; 
        try {
            fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            ArrayList<Player>  list = (ArrayList<Player>) in.readObject();

            for(Player obj: list) {
                Player p = cache.getObject(obj);
                if (p == null) { 
                    cache.addObject(obj);
                } 
                else {
                    cache.removeObject(obj);
                    cache.addObject(obj);       
                }
            }
            in.close();
        } catch (IOException e) { 
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 

        return cache;
    } 
    
    /**
     * Calculates the elapsed time, and prints the correct format outputs of the cache list. 
     * @param args
     */
    public static void main(String[] args) {      
        Long currentTime = System.currentTimeMillis();
        
        int cacheSize = Integer.parseInt(args[0]);
        String fileName = args[1];

        Cache<Player> cache = runTest(fileName, cacheSize);

        Long elapsedTime = System.currentTimeMillis();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("LinkedList Cache with " + cacheSize + " entries has been created");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(cache.toString());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Time elapsed: " + ((double)elapsedTime - currentTime) + " milliseconds");
        System.out.println("----------------------------------------------------------------"); 
    }
} 

