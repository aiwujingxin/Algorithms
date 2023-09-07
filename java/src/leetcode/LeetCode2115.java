package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 18:02
 */
public class LeetCode2115 {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        HashSet<String> recipeSet = new HashSet<>(Arrays.asList(recipes));
        List<String> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (recipeSet.contains(cur)) {
                res.add(cur);
            }
            if (graph.get(cur) == null) {
                continue;
            }
            for (String next : graph.get(cur)) {
                if (indegree.containsKey(next)) {
                    indegree.put(next, indegree.get(next) - 1);
                }
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return res;

    }
}
