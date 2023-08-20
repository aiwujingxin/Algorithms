package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/13 18:20
 */
public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int max = 0;
        for (int p : piles) {
            max = Math.max(p, max);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int time = 0;
            int mid = (left + right) / 2;
            for (int p : piles) {
                time += (p + mid - 1) / mid;
            }
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
