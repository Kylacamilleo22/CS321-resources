import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CacheTest {
    
    public static void main(String[] args) {
        
        //Player player = new Player(mo, 2);

        try {
            FileOutputStream fileout = new FileOutputStream("list.serial");
            ObjectOutputStream out = new ObjectOutputStream(fileout);

            //out.writeObject(player);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
