package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 14:48
 */
public class LeetCode1780 {

    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n >= 3) {
            int t = 3;
            while (n - t * t >= 0) {
                t = t * t;
            }
            if (set.contains(t)) {
                return false;
            }
            set.add(t);
            n -= t;
        }
        return n == 0 || n == 1;
    }
}
