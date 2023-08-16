package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 17:41
 */
public class LeetCode683_sd {

    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        // build
        int[] day = new int[n];
        for (int i = 0; i < n; i++) {
            day[bulbs[i] - 1] = i;
        }
        int left = 0, right = left + k + 1; // 花盆的位置
        int res = Integer.MAX_VALUE;

        while (right < n) {
            int max = Math.max(day[left], day[right]); // 与两个边界中开花最晚的比较
            boolean can = true;
            for (int i = left + 1; i < right; i++) {
                if (day[i] < max) {
                    left = i;
                    right = left + k + 1;
                    can = false;
                    break;
                }
            }
            if (can) {
                res = Math.min(res, max + 1);
                left = right;
                right += k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
