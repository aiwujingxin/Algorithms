package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 18:02
 */
public class LeetCode2115 {

    HashSet<String> recipeSet;
    HashSet<String> supplieSet;
    HashMap<String, Boolean> cache;
    HashMap<String, List<String>> recipeMap;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        recipeSet = new HashSet<>();
        supplieSet = new HashSet<>();
        cache = new HashMap<>();
        recipeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            recipeSet.add(recipes[i]);
            recipeMap.put(recipes[i], ingredients.get(i));
        }
        Collections.addAll(supplieSet, supplies);
        List<String> list = new ArrayList<>();

        for (String recipe : recipes) {
            if (check(recipe, new HashSet<>())) {
                list.add(recipe);
            }
        }
        return list;
    }

    public boolean check(String recipe, HashSet<String> vs) {
        if (cache.get(recipe) != null) {
            return cache.get(recipe);
        }
        for (String ingre : recipeMap.get(recipe)) {
            // 1. recipe
            if (recipeSet.contains(ingre)) {
                if (cache.get(ingre) != null) {
                    if (cache.get(ingre) == false) {
                        return false;
                    }
                } else {
                    if (vs.contains(ingre)) {
                        return false;
                    }
                    vs.add(ingre);
                    boolean res = check(ingre, vs);
                    cache.put(ingre, res);
                    if (!res) {
                        cache.put(recipe, res);
                        return false;
                    }
                }
            } else { // 2. supplie
                if (!supplieSet.contains(ingre)) {
                    return false;
                }
            }
        }
        return true;
    }
}
