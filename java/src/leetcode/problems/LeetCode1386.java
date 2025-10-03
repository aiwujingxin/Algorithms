package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/16/25 15:36
 */
public class LeetCode1386 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : reservedSeats) {
            map.put(r[0], map.getOrDefault(r[0], 0) | (1 << r[1]));
        }
        int cnt = 0;
        for (int mask : map.values()) {
            boolean left = (mask & 0b111100) == 0;      // 座位 2–5
            boolean mid = (mask & 0b11110000) == 0;     // 座位 4–7
            boolean right = (mask & 0b1111000000) == 0; // 座位 6–9
            if (left && right) {
                cnt += 2;
            } else if (left || mid || right) {
                cnt += 1;
            }
        }
        return cnt + (n - map.size()) * 2;
    }
}
