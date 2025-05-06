package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:04
 */
public class LeetCode372 {

    public int superPow(int a, int[] b) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < b.length; i++) {
            res = myPow(res, 10) * myPow(a, b[i]) % 1337;
        }
        return res;
    }

    public int myPow(int x, int n) {
        int res = 1;
        x %= 1337;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % 1337;
            }
            x = (x * x) % 1337;
            n >>= 1;
        }
        return res;
    }
}
