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
}
