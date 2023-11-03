package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:37
 */
public class LeetCode202 {


    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = getN(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getN(int n) {
        int res = 0;
        int exp = 10;
        while (n > 0) {
            int t = n % exp;
            n = n / exp;
            res += t * t;
        }
        return res;
    }
}
