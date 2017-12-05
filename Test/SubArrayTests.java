import com.geekbrains.TestingPackadge.TestingMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubArrayTests {
    TestingMethods testingMethods;

    @Before
    public void init(){
        testingMethods = new TestingMethods();
    }

    @Test
    public void testSub1() {
        Assert.assertArrayEquals(new Integer[]{1,7},testingMethods.extractionOfArray(new Integer[] {1,2,4,4,2,3,4,1,7}));
    }
    @Test(expected = RuntimeException.class)
    public void testSub2() {
        testingMethods.extractionOfArray(new Integer[] {1,7});
    }
    @Test
    public void testSub3() {
        Assert.assertArrayEquals(new Integer[]{},testingMethods.extractionOfArray(new Integer[] {4}));
    }
    @Test
    public void testSub4() {
        Assert.assertArrayEquals(new Integer[]{1},testingMethods.extractionOfArray(new Integer[] {4,1}));
    }
}
