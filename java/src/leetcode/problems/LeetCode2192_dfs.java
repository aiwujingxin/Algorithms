package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:23
 */
public class LeetCode2192_dfs {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //用于存储结点间的关系--->一个节点和他的祖先结点
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }
        //这里当然可以直接用List<List<Integer>>并作为结果
        //但是在findParent递归中，判断元素是否在集合中时，set是O(1)，而list是O(n)
        List<Set<Integer>> lists = new ArrayList<>();
        //初始化
        for (int i = 0; i < n; i++) {
            lists.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            findParent(i, lists.get(i), map);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).addAll(lists.get(i));
            Collections.sort(ans.get(i));
        }
        return ans;
    }

    private void findParent(int idx, Set<Integer> list, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(idx)) {

            return;
        }
        for (Integer it : map.get(idx)) {
            if (list.contains(it)) {
                continue;
            }
            list.add(it);
            findParent(it, list, map);
        }
    }
}
