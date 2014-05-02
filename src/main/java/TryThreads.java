/**
 * Created by vpetricek on 4/11/14.
 * Oh yeah
 */
import java.util.ArrayList;
import java.util.List;


public class TryThreads {

    public static void main(String[] args) {
        GuavaExperiment exp = new GuavaExperiment();
        exp.run();

        // We will store the threads so that we can check if they are done
        List<Thread> threads = new ArrayList<Thread>();
        // We will create 5 threads
        for (int i = 0; i < 5; i++) {
            Runnable task = new GuavaExperiment();
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
