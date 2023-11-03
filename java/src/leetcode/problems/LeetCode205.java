package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:52
 */
public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map1 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (map.get(schar) == null) {
                if (map1.get(tchar) != null) {
                    return false;
                }
                map.put(schar, tchar);
                map1.put(tchar, schar);
            } else {
                if (map.get(schar) != tchar) {
                    return false;
                }
            }
        }
        return true;
    }
}
