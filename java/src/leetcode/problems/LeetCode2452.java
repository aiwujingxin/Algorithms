package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 15:32
 */
public class LeetCode2452 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String q : queries) {
            if (check(q, dictionary)) {
                res.add(q);
            }
        }
        return res;
    }

    private boolean check(String q, String[] dictionary) {
        for (String d : dictionary) {
            if (q.length() != d.length()) {
                continue;
            }
            int diff = 0;
            for (int j = 0; j < q.length(); j++) {
                diff += (d.charAt(j) != q.charAt(j) ? 1 : 0);
            }
            if (diff <= 2) {
                return true;
            }
        }
        return false;
    }
}
