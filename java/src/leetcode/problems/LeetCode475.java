package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 13:42
 */
public class LeetCode475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(houses, heaters, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length, m = heaters.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            while (i < n && (houses[i] <= heaters[j] + x && houses[i] >= heaters[j] - x)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
