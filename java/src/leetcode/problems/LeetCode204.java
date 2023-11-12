package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:47
 */
public class LeetCode204 {


    public int countPrimes(int n) {

        boolean[] notP = new boolean[n];
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (!notP[i]) {
                res++;
                for (int j = 0; j * i < n; j++) {
                    notP[j * i] = true;
                }
            }
        }
        return res;
    }

    public int countPrimes_v2(int n) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
