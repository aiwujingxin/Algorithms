package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 21:20
 */
public class LeetCode241 {

    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("+-*".indexOf(c) >= 0) {
                for (int l : diffWaysToCompute(s.substring(0, i))) {
                    for (int r : diffWaysToCompute(s.substring(i + 1))) {
                        res.add(c == '+' ? l + r : c == '-' ? l - r : l * r);
                    }
                }
            }
        }
        return res.isEmpty() ? List.of(Integer.valueOf(s)) : res;
    }
}
