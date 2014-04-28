import java.util.ArrayList;
import java.util.List;

/**
 * Created by petricek on 4/26/14.
 */


public class TryList {

    public static void main(String agrgs[])
    {
        List<Integer> list = new ArrayList<Integer>();

        for(Integer i = 0; i< 100 ; i++)
        {
            list.add(i);
        }
        System.out.println(list.size());
    }
}
