package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 12/17/25 11:28
 */
public class LeetCode1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
                cnt++;
            } else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                cnt++;
            } else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
                cnt++;
            }
        }
        return cnt;
    }
}
