package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-07-04 7:52 下午
 */
public class LeetCode96 {

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += numTrees(i) + numTrees(n - i - 1);
        }
        return res;
    }

    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
