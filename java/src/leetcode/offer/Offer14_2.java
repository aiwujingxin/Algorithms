package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 15:38
 */
public class Offer14_2 {

    // 将绳子以相等的长度等分为多段，得到的乘积最大。
    // 尽可能将绳子以长度 3 等分为多段时，乘积最大。
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, mod = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % mod;
            }
            x = (x * x) % mod;
        }
        if (b == 0) {
            return (int) (rem * 3 % mod);
        }
        if (b == 1) {
            return (int) (rem * 4 % mod);
        }
        return (int) (rem * 6 % mod);
    }
}
