package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 11:16
 */

public class LeetCode1461 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1461().hasAllCodes("00110110", 2));
    }

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int num = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            num |= (s.charAt(i) - '0');
            num <<= 1;
        }
        num >>= 1;
        System.out.println(num);
        set.add(num);
        for (int i = k; i < s.length(); i++) {
            if ((num >> (k - 1) & 1) == 1) {
                num -= (int) Math.pow(2, k - 1);
            }
            num <<= 1;
            num |= (s.charAt(i) - '0');
            set.add(num);
        }
        System.out.println(set);
        return set.size() == (int) Math.pow(2, k);
    }
}
