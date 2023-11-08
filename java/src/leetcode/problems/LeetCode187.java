package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:35
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new LinkedList<>();
        }
        // 将DNA序列变成数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int hash = 0;
        int pow = (int) Math.pow(4, 9);// 删除高位时用
        int left = 0, right = 0;
        while (right < nums.length) {
            hash = 4 * hash + nums[right];// 4进制，每次让先前的的数字乘以进制，加上低位的数字
            if (right - left + 1 == 10) {
                if (set.contains(hash)) {
                    res.add(s.substring(left, right + 1));
                }
                set.add(hash);
                // 滑动窗口删除高位数字
                hash = hash - nums[left] * pow;
                left++;
            }
            right++;
        }
        return new ArrayList<>(res);
    }
}
