package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 11/23/25 23:33
 */
public class LeetCode1417 {

    public String reformat(String s) {
        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                a.add(c);
            } else {
                b.add(c);
            }
        }
        if (Math.abs(a.size() - b.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean f;
        f = a.size() >= b.size();
        while (i < a.size() || j < b.size()) {
            if (f) {
                if (i < a.size()) {
                    sb.append(a.get(i));
                    i++;
                }
                f = false;
            } else {
                if (j < b.size()) {
                    sb.append(b.get(j));
                    j++;
                }
                f = true;
            }
        }
        return sb.toString();
    }
}
