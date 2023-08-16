package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/15 22:32
 */
public class LeetCode1105 {

    //https://leetcode.cn/problems/filling-bookcase-shelves/solution/java-dong-tai-gui-hua-jie-fa-by-dan-wei-te7vz/
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        //dp[i]表示以第i-1本书（从第0本算起）结尾的前i本书叠成的最小高度
        int[] dp = new int[n + 1];

        dp[1] = books[0][1];

        for (int i = 2; i <= n; i++) {
            dp[i] = books[i - 1][1] + dp[i - 1];
            int w = books[i - 1][0], h = books[i - 1][1];
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                if (w > shelf_width) {
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }
        return dp[n];
    }
}
