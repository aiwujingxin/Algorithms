package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:35
 * @see basic.datastructure.string.impl.RabinKarp
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                res.add(str);
            }
            set.add(str);
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences_rabinKarp(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
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
        int hash = 0; //滚动哈希
        int mul = 4; // 进制
        int pow = 1;
        for (int i = 0; i < 9; i++) { // len(模式串)-1
            pow = (pow * mul);
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            hash = mul * hash + nums[right];
            if (right - left + 1 == 10) {
                if (set.contains(hash)) {
                    res.add(s.substring(left, right + 1));
                }
                set.add(hash);
                hash = hash - nums[left] * pow; // 滑动窗口删除高位数字
                left++;
            }
            right++;
        }
        return new ArrayList<>(res);
    }
}
