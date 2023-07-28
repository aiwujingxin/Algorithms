package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 15:57
 */
public class LeetCode1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> endSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}

