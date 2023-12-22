package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 10:55
 */
public class LeetCode593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Long> set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p4));
        set.add(distance(p2, p3));
        set.add(distance(p3, p4));
        return !set.contains(0L) && set.size() == 2;
    }

    private long distance(int[] p1, int[] p2) {
        return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
    }
}
