package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 11/18/25 14:41
 */
public class LeetCode2048 {

    int ans = Integer.MAX_VALUE;
    int n;
    int[] total = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int maxCount = 7;

    public int nextBeautifulNumber(int n) {
        this.n = n;
        backtrack(0, new int[10], 0);
        return ans;
    }

    private void backtrack(int sum, int[] freq, int dCount) {
        if (sum > n && check(freq)) {
            ans = Math.min(sum, ans);
        }
        for (int i = 1; i < freq.length; i++) {
            if (maxCount - dCount < total[i] - freq[i]) {
                continue;
            }
            int newSum = sum;
            int newDCount = dCount;
            for (int k = 0; k < total[i] - freq[i]; k++) {
                newSum = newSum * 10 + i;
                newDCount = newDCount + k + 1;
                freq[i] += k + 1;
                backtrack(newSum, freq, newDCount);
                freq[i] -= k + 1;
            }
        }
    }

    private boolean check(int[] freq) {
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] != 0 && i != freq[i]) {
                return false;
            }
        }
        return true;
    }
}
