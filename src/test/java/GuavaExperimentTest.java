import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
//import voldemort.client.ClientConfig;
//import voldemort.client.SocketStoreClientFactory;
//import voldemort.client.StoreClient;
//import voldemort.client.StoreClientFactory;
//import voldemort.versioning.Versioned;

import com.google.common.base.Preconditions;
import com.example.tutorial;


/**
 * Created by vpetricek on 4/11/14.
 * Some practice tests
 */
public class GuavaExperimentTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIncrement()
    {
        TryPrecondition tester = new TryPrecondition();

        Assert.assertEquals(tester.increment(),1);
        Assert.assertEquals(tester.increment(),2);
    }

    @Test
    public void testSetName()
    {
        TryPrecondition tester = new TryPrecondition();

        Assert.assertEquals(tester.setName("Hey"),null);
        Assert.assertEquals(tester.setName("Ho"),"Hey");
    }

    @Test
    public void testAddPositive() {
        TryPrecondition tester = new TryPrecondition();

        Assert.assertEquals(tester.addPositive(5), 0);
        Assert.assertEquals(tester.addPositive(5), 5);
        //Assert.assertEquals(tester.addPositive(-5),5);
    }

    @Test
    public void testRun()
    {
        Runner tester = new Runner();

        tester.run();
    }

//    @Test
//    public void testVoldy()
//    {
//        String bootstrapUrl = "tcp://localhost:6666";
//        StoreClientFactory factory = new SocketStoreClientFactory(new ClientConfig().setBootstrapUrls(bootstrapUrl));
//
//        // create a client that executes operations on a single store
//        StoreClient client = factory.getStoreClient("test");
//
//        // do some random pointless operations
//        Versioned<String> value = client.get("hey");
//        client.put("some_key", "wohoo");
//
////        Assert.assertEquals(tester.addPositive(-5),5);
//    }

}
