package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 15:57
 */
public class LeetCode1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n];
        for (List<Integer> edge : edges) {
            inDegrees[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

