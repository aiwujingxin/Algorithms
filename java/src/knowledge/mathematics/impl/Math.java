package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 1/11/25 11:13
 */
public class Math {

    private long gcd(long a, long b) {
        while (a != 0) {
            long tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
}
