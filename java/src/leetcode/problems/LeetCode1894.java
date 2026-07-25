package leetcode.problems;

import knowledge.mathematics.bigdecimal.impl.BigDecimalSub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 12/8/25 11:05
 */
public class LeetCode1894 {

    public boolean splitString(String s) {
        return backtrack(s, new ArrayList<>(), 0, null);
    }

    private boolean backtrack(String s, List<String> list, int i, String pre) {
        if (i == s.length() && list.size() > 1) {
            return true;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String num = s.substring(i, j);
            if (pre == null || Objects.equals(BigDecimalSub.subtract(pre, num), "1")) {
                list.add(num);
                if (backtrack(s, list, j, num)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

}
