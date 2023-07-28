package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-08-27 12:31 上午
 */
public class LeetCode241 {


    public List<Integer> diffWaysToCompute(String input) {
        //校验
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 拆成左右子问题
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                //遍历形成结果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
