package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 15:06
 */
public class LeetCode668 {

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i, n);
            count += temp;
        }
        return count;
    }
}
