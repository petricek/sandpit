import java.util.HashSet;
/**
 * Created by petricek on 4/25/14.
 * oh yee
 */
public class TryHashSet {
    public static void main(String[] args)
    {
        HashSet<String> set = new HashSet<String>();

        for(Integer i = 0; i< 100; i++)
        {
            Integer rn = (int)(Math.random() * 100);

            set.add(rn.toString());
        }

        System.out.println(set.size());

    }

}
