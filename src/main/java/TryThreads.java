/**
 * Created by vpetricek on 4/11/14.
 * Oh yeah
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class TryThreads {

    public static void main(String[] args) {
        Runner exp = new Runner();
        exp.run();

        // We will store the threads so that we can check if they are done
        List<Thread> threads = new ArrayList<Thread>();
        // We will create 5 threads
        for (int i = 0; i < 5; i++) {
            Runnable task = new Runner();
            Thread worker = new Thread(task);
            // We can set the name of the thread
            worker.setName(String.valueOf(i));
            // Start the thread, never call method run() direct
            worker.start();
            // Remember the thread for later usage
            threads.add(worker);
        }
        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads. ");
        } while (running > 0);

    }
}


/**
 * Created by vpetricek on 5/1/14.
 */
class Runner implements Runnable{
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
