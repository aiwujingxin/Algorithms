package leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 11:56
 */
public class LeetCode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) != '(') {
                sb.append(s.charAt(index));
                index++;
            } else if (s.charAt(index) == '(') {
                int t = index + 1;
                while (t < s.length() && s.charAt(t) != ')') {
                    t++;
                }
                String r = s.substring(index + 1, t);
                sb.append(map.getOrDefault(r, "?"));
                index = t + 1;
            }
        }
        return sb.toString();
    }
}
