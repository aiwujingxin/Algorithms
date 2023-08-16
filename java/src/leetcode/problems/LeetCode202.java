package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 14:38
 */
public class LeetCode202 {

    //study
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                int digit = n % 10;
                temp += digit * digit;
                n /= 10;
            }
            if (!set.add(temp)) {
                return false;
            }
            n = temp;
        }
        return true;
    }
}
