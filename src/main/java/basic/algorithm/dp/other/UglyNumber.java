package basic.algorithm.dp.other;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 20:56
 */
public interface UglyNumber {

    //https://leetcode.cn/problems/ugly-number/
    boolean isUgly(int n);

    //https://leetcode.cn/problems/ugly-number-ii/
    int nthUglyNumber(int n, int a, int b, int c);

    //https://leetcode.cn/problems/ugly-number-iii/
    int nthUglyNumber(int n);

    //https://leetcode.cn/problems/super-ugly-number/
    int nthSuperUglyNumber(int n, int[] primes);
}
