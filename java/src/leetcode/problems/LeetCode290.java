package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 00:16
 */
public class LeetCode290 {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> rmap = new HashMap<>();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (map.get(pattern.charAt(i)) == null) {
                if (rmap.get(strs[i]) != null) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
                rmap.put(strs[i], pattern.charAt(i));
            } else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
