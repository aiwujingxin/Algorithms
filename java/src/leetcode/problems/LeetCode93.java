package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:42
 */
public class LeetCode93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int i, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (i == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        for (int len = 1; len <= 3 && i + len <= s.length(); len++) {
            String seg = s.substring(i, i + len);
            if (seg.length() > 1 && seg.startsWith("0") || Integer.parseInt(seg) > 255) {
                continue;
            }
            list.add(seg);
            backtrack(s, i + len, list, res);
            list.remove(list.size() - 1);
        }
    }
}
