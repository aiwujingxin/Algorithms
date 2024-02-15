package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/8 12:01
 */
public class LeetCode1442 {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        pre[0] = 1;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (pre[i] == (pre[k + 1])) {
                    res++;
                }
            }
        }
        return res;
    }
}
