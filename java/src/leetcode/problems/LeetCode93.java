package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 21:52
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, 0, 4, "");
        return res;
    }

    public void helper(String s, List<String> res, int index, int remain, String cur) {
        if (remain == 0) {
            if (index == s.length()) {
                res.add(cur);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            if (i != 1 && s.charAt(index) == '0') {
                break;
            }
            String temp = s.substring(index, index + i);
            int val = Integer.parseInt(temp);
            if (val <= 255) {
                helper(s, res, index + i, remain - 1, cur + temp + (remain == 1 ? "" : "."));
            }
        }
    }
}
