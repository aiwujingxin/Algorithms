package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 22:07
 */
public class LeetCode2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for (String w : words) {
            char[] chars = w.toCharArray();
            char t = chars[0];
            chars[0] = chars[1];
            chars[1] = t;
            if (set.contains(new String(chars))) {
                cnt++;
            }
            set.add(w);
        }
        return cnt;
    }
}
