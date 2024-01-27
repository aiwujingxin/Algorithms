package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 18:37
 */
public class LeetCode3006 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        if (!s.contains(a) || !s.contains(b)) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int aIndex = s.indexOf(a, i);
            if (aIndex == -1) {
                continue;
            }
            if (set.contains(aIndex)) {
                continue;
            }
            set.add(aIndex);
            int bIndex = s.indexOf(b, aIndex - k);
            if (bIndex == -1) {
                continue;
            }
            if (Math.abs(bIndex - aIndex) <= k) {
                res.add(aIndex);
            }
        }
        return res;
    }
}
