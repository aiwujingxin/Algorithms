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

    private void backtrack(String s, int index, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (index == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String t = s.substring(index, index + len);
            if (t.length() > 1 && t.startsWith("0") || Integer.parseInt(t) > 255) continue;
            list.add(t);
            backtrack(s, index + len, list, res);
            list.remove(list.size() - 1);
        }
    }
}
