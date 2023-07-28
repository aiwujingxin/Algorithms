package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/13 18:33
 */
public class LeetCode1552 {

    public int maxDistance(int[] position, int m) {
        if (position == null || position.length == 0) {
            return 0;
        }
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, position, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
