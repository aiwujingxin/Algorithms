package leetcode.problems;

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
        int l = 1;
        int r = max;
        while (l < r) {
            int time = 0;
            int mid = (l + r) / 2;
            for (int p : piles) {
                time += (p + mid - 1) / mid;
            }
            if (time > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
