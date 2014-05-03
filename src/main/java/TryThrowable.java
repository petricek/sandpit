import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by petricek on 5/1/14.
 */
public class TryThrowable {
    public static void main(String args[]) throws FileNotFoundException{

        try{
            FileInputStream file = new FileInputStream("xxx");
        }
        catch(Throwable t){
            t.printStackTrace();
        }

    }
}
