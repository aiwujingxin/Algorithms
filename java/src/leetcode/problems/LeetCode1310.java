package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 18:10
 */
public class LeetCode1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] presum = new int[n + 1];
        presum[0] = 1;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = presum[queries[i][1] + 1] ^ presum[queries[i][0]];
        }
        return res;
    }
}
