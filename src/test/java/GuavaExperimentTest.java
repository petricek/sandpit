import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

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
        GuavaExperiment tester = new GuavaExperiment();

        Assert.assertEquals(tester.increment(),1);
        Assert.assertEquals(tester.increment(),2);
    }

    @Test
    public void testSetName()
    {
        GuavaExperiment tester = new GuavaExperiment();

        Assert.assertEquals(tester.setName("Hey"),null);
        Assert.assertEquals(tester.setName("Ho"),"Hey");
    }

    @Test
    public void testAddPositive()
    {
        GuavaExperiment tester = new GuavaExperiment();

        Assert.assertEquals(tester.addPositive(5),0);
        Assert.assertEquals(tester.addPositive(5),5);
        Assert.assertEquals(tester.addPositive(-5),5);
    }

}
