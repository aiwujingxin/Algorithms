package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/19 00:08
 * @description 贝祖定理 ax + by = z
 */
public class LeetCode365 {

    public boolean canMeasureWater(int c1, int c2, int target) {
        if (c1 + c2 < target) {
            return false;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) {
                return true;
            }
            if (cur + c1 <= c1 + c2 && !visited.contains(cur + c1)) {
                queue.add(cur + c1);
                visited.add(cur + c1);
            }
            if (cur + c2 <= c1 + c2 && !visited.contains(cur + c2)) {
                queue.add(cur + c2);
                visited.add(cur + c2);
            }
            if (cur - c1 >= 0 && !visited.contains(cur - c1)) {
                queue.add(cur - c1);
                visited.add(cur - c1);
            }
            if (cur - c2 >= 0 && !visited.contains(cur - c2)) {
                queue.add(cur - c2);
                visited.add(cur - c2);
            }
        }
        return false;
    }

    public boolean canMeasureWater_math(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }
}
