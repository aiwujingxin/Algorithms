package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 1/8/25 21:59
 */
public class LeetCode3365 {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (s.length() % k != 0 || t.length() % k != 0 || s.length() != t.length()) {
            return false;
        }
        int len = s.length() / k;
        HashMap<String, Integer> smap = split(s, len);
        HashMap<String, Integer> tmap = split(t, len);
        for (Map.Entry<String, Integer> entry : tmap.entrySet()) {
            if (!Objects.equals(smap.getOrDefault(entry.getKey(), 0), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, Integer> split(String s, int len) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += len) {
            String t = s.substring(i, i + len);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return map;
    }
}
