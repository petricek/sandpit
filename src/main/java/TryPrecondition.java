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

    public void run()
    {
        Runtime rt = Runtime.getRuntime();
        try {
            Process ps = rt.exec("sleep 3");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(ps.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(ps.getErrorStream()));



            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            int exitVal = ps.waitFor();

            System.out.println("Process exitValue: " + exitVal);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
