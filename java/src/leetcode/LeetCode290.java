package leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author jingxinwu
 * @date 2021-12-26 8:36 PM
 */
public class LeetCode290 {

    public static void main(String[] args) {
        System.out.println(new LeetCode290().wordPattern("jquery",
                "jquery"));
    }

    public boolean wordPattern(String pattern, String s) {

        if (pattern == null && s == null) {
            return true;
        }

        if (pattern == null) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, String> map1 = new HashMap<>();

        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < strs.length; i++) {
            map1.put(strs[i], strs[i]);
        }
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), strs[i]);
        }
        if (map.size() != map1.size()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            if (!Objects.equals(map.get(pattern.charAt(i)), strs[i])) {
                return false;
            }
        }
        return true;
    }
}
