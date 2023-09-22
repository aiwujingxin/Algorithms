package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/5 18:25
 */
public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int len = cardPoints.length - k;
        int right = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int total = 0;
        for (int cardPoint : cardPoints) {
            total += cardPoint;
        }
        while (right < cardPoints.length) {
            sum += cardPoints[right];
            while (right - left + 1 > len) {
                sum -= cardPoints[left];
                left++;
            }
            if (right - left + 1 == len) {
                ans = Math.min(ans, sum);
            }
            right++;
        }
        return total - ans;
    }
}
