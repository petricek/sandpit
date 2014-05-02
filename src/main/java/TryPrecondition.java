/**
 * Created by vpetricek on 4/11/14.
 * Practice class
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.google.common.base.Preconditions.checkArgument;


public class TryPrecondition {
    private int count;
    private String str;
    public int increment()
    {
        return ++count;
    }
    public String setName(String name)
    {
        String oldname = this.str;
        this.str = name;
        return oldname;
    }

    public int addPositive(int num)
    {
        checkArgument(num >= 0, "Argument was %s but expected nonnegative", num);

        int oldcount = count;
        count += num;
        return oldcount;
    }


}
