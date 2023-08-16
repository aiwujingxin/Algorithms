package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 16:59
 */
public class LeetCode1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < calories.length) {
            sum += calories[right];
            if (right - left + 1 == k) {
                if (sum < lower) {
                    ans--;
                } else if (sum > upper) {
                    ans++;
                }
                sum -= calories[left++];
            }
            right++;
        }
        return ans;
    }
}
