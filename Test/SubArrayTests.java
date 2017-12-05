import com.geekbrains.TestingPackadge.TestingMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class SubArrayTests {
    TestingMethods testingMethods;
    private Integer[] resultArray = null;
    private Integer[] array = null;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,7},new Integer[] {1,2,4,4,2,3,4,1,7}},
                {new Integer[0],new Integer[] {4}},
                {new Integer[]{1},new Integer[] {4,1}},
        });
    }

    public SubArrayTests(Integer[] resultArray, Integer[] array) {
        this.resultArray = resultArray;
        this.array = array;
    }

    @Before
    public void init(){
        testingMethods = new TestingMethods();
    }

    @Test
    public void testSub1() {
        Assert.assertArrayEquals(resultArray,testingMethods.extractionOfArray(array));
    }
    @Test(expected = RuntimeException.class)
    public void testSub2() {
        testingMethods.extractionOfArray(new Integer[] {1,7});
    }
//    @Test
//    public void testSub3() {
//        Assert.assertArrayEquals(resultArray,testingMethods.extractionOfArray(array));
//    }
//    @Test
//    public void testSub4() {
//        Assert.assertArrayEquals(resultArray,testingMethods.extractionOfArray(array));
//    }
}
