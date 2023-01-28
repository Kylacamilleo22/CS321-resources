import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.LinkedList;

public class CacheTest {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {      

        Long currentTime = System.currentTimeMillis();
        
        String fileName = args[1];
        int cacheSize = Integer.parseInt(args[0]);
        Cache<Player> cache = new Cache<Player>(cacheSize);        

        FileInputStream fileIn; 
        try {
            fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            ArrayList<Player>  list = (ArrayList<Player>) in.readObject();
            //System.out.println(list.toString());
 
            for(Player obj: list) {
                ++cache.numRefs;
                Player p = cache.getObject(obj);
                if (p == null) {
                    cache.addObject(obj);
                } 
                else {
                    ++cache.numHits;
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
