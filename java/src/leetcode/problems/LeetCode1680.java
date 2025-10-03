package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/25 18:14
 * @link <a href="https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/solutions/3783264/duo-chong-jie-fa-kuai-su-mi-wei-yun-suan-pf6t/"></a>
 */
public class LeetCode1680 {

    int mod = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
//            res = (res << Integer.toBinaryString(i).length() | i) % mod;
            res = (res << Integer.SIZE - Integer.numberOfLeadingZeros(i) | i) % mod;
        }
        return (int) res;
    }
}
