import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Created by petricek on 4/29/14.
 */

public class TryJackson {

    public static void main(String args[])
    {
        HashSet<Integer> set = new LinkedHashSet<Integer>();
        for (int item : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {
            System.out.println("item is: " + item);
            set.add(item);
        }

        HashMap<Integer,String> map = new LinkedHashMap();
        for (int item : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {
            System.out.println("item is: " + item);
            map.put(item,"Seven");
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(mapper.writeValueAsString(set));
            System.out.println(mapper.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
