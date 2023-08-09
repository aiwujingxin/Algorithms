package leetcode.lists.classic;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-12-05 2:13 下午
 */
public class Number0104 {

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // 如果当前字符是偶数个，从哈希表中删除
            if (map.getOrDefault(c, 0) % 2 == 1) {
                map.remove(c);
            }
            // 如果当前字符是奇数个，保存到哈希表中
            else {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        // 数量是奇数的字符的个数 > 1就不是回文串，否则是回文串
        return map.size() <= 1;
    }
}
