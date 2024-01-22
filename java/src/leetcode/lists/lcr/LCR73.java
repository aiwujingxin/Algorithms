package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 18:21
 */
public class LCR73 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (getTime(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getTime(int[] piles, int num) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += piles[i] % num == 0 ? piles[i] / num : piles[i] / num + 1;
        }
        return time;
    }
}
