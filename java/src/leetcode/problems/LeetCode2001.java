package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 23:14
 */
public class LeetCode2001 {

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (int[] rec : rectangles) {
            double ratio = rec[0] * 1.0 / rec[1];
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }
        long sum = 0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            sum += (long) entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return sum;
    }
}
