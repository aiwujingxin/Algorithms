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
        backtrack(res, s, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(List<String> res, String s, int index, List<String> list) {
        if (index == s.length() && list.size() == 4) {
            res.add(String.join(".", list));
            return;
        }
        for (int i = index + 1; i <= Math.min(index + 3, s.length()); i++) {
            String sub = s.substring(index, i);
            int num = Integer.parseInt(sub);
            if (sub.length() > 1 && s.charAt(index) == '0' || num > 255) continue;
            list.add(sub);
            backtrack(res, s, i, list);
            list.removeLast();
        }
    }
}
