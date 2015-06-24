package complexity.recursion;

import org.junit.Test;

/**
 * Created by Charlie on 6/23/2015.
 */
public class ReduceTimeTest {
    @Test
    public void testPower() {
        ReduceTime rt = new ReduceTime();
        assert 2L == rt.power(2, 1);
        assert 4L == rt.power(2, 2);
        assert 8L == rt.power(2, 3);
        assert 16L == rt.power(2, 4);
        assert 32L == rt.power(2, 5);
        assert 64L == rt.power(2, 6);
        assert 128L == rt.power(2, 7);
        assert 256L == rt.power(2, 8);
        assert 512L == rt.power(2, 9);
        assert 1024L == rt.power(2, 10);
    }
}
