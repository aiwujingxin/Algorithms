package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 18:10
 */
public class LeetCode1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] s = new int[n + 1];
        s[0] = 1;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] ^ arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = s[queries[i][1] + 1] ^ s[queries[i][0]];
        }
        return res;
    }
}
