package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 15:57
 */
public class LeetCode1297_sd {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        //统计子串出现的个数
        Map<String, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int left = 0, right = 0;
        //统计窗口中不同字母的数目
        int tmp = 0;
        //记录窗口中字母的个数
        int[] count = new int[128];
        while (right < n) {
            count[c[right]]++;
            //当下面条件成立时，则说明窗口中多了一个不同的字母
            if (count[c[right]] == 1) {
                tmp++;
            }
            right++;
            int len = right - left;
            while (tmp > maxLetters || len > minSize) {
                count[c[left]]--;
                //当窗口左移的过程中，一个字母减为0，则说明窗口中少了一个不同的字母
                if (count[c[left]] == 0) {
                    tmp--;
                }
                left++;
                //如果没有这句，会陷入死循环，len会一直大于minSize
                len--;
            }
            //当不同字母的数目小于等于maxLetters
            if (tmp <= maxLetters) {
                if (len == minSize) {
                    String str = s.substring(left, right);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }

            }
        }
        //统计字串最大出现的次数
        int ans = 0;
        for (String key : map.keySet()) {
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }
}
