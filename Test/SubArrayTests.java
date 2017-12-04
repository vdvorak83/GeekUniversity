import com.geekbrains.TestingPackadge.TestingMethods;
import org.junit.Assert;
import org.junit.Test;

public class SubArrayTests {
    @Test
    public void testSub() {
        TestingMethods testingMethods = new TestingMethods();
        Assert.assertArrayEquals(new Integer[]{1,7},testingMethods.extractionOfArray(new Integer[] {1,2,4,4,2,3,4,1,7}));
    }
}
