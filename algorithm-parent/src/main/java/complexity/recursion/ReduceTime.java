package complexity.recursion;

public class ReduceTime {
    public Long power(Integer a, Integer b) {
        return eval(a, b);
    }

    private Long eval(Integer a, Integer b) {
        if (b == 1) {
            return a.longValue();
        }
        else if ( b % 2 != 0) {
            return eval(a, b-1)*a;
        } else {
            return eval(a*a, b/2);
        }
    }
}
