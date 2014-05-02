/**
 * Created by petricek on 4/25/14.
 */

import java.util.HashMap;

public class TryHashMap {
    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(Integer i = 0; i< 100; i++)
        {
            map.put(i.toString(), i);
        }

        System.out.println(map.size());

    }
}

