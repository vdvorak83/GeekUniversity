import com.geekbrains.TestingPackadge.TestingMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainsNumberTest {
    TestingMethods testingMethods;
    @Before
    public void init(){
        testingMethods = new TestingMethods();
    }
    @Test
    public void tetsTrue(){
        Assert.assertTrue(testingMethods.containsNumbers(new Integer[]{1,2,3,4,5,6,7,8},new Integer[]{1,4}));
    }

    @Test
    public void tetsFalse(){
        Assert.assertFalse(testingMethods.containsNumbers(new Integer[]{0,2,3,2,5,6,7,8},new Integer[]{1,4}));
    }
}
