package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 11/12/25 11:01
 */
public class LeetCode1011 {

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        int l = max;
        int r = max * 2;
        while (l < r) {
            int mid = l + r >> 1;
            int need = check(weights, mid);
            if (need > days) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int check(int[] weights, int cap) {
        int day = 0;
        int index = 0;
        int n = weights.length;
        while (index < n) {
            int t = 0;
            while (index < n && t + weights[index] <= cap) {
                t += weights[index];
                index++;
            }
            day++;
        }
        return day;
    }
}
