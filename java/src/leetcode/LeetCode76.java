package leetcode;

import java.util.HashMap;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/22 16:34
 */
public class LeetCode76 {

    //youtube: https://www.youtube.com/watch?v=63i802XLgOM

    //性质: 首尾是T中的字符
    //记录： T每一个字符的数量： Map or Array
    //      已经找到的字符的数量

    //https://leetcode.com/problems/minimum-window-substring/discuss/26811/Share-my-neat-java-solution

    public String minWindow(String s, String t) {

        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        //init
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 左边界
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            // 找到相同的字符
            if (map.containsKey(s.charAt(right))) {
                //计数count
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {// 只有真正找到，count才++
                    count++;
                }

                while (count == t.length()) {
                    //更新
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    // 左指针向右移动，去除多余匹配的字符，
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) { //对count产生的影响
                            count--; // 不是有效的substring了，退出这次while
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}
