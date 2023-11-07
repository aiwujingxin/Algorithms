package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-08-27 12:31 上午
 */
public class LeetCode241 {

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 拆成左右子问题
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                //遍历形成结果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}
