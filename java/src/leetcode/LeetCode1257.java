package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 16:49
 */

public class LeetCode1257 {


    HashMap<String, Set<String>> map = new HashMap<>();

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        if (regions == null || regions.isEmpty()) {
            return "";
        }

        Set<String> roots = new HashSet<>();
        for (List<String> list : regions) {
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    map.putIfAbsent(list.get(j), new HashSet<>());
                    roots.add(list.get(j));
                } else {
                    map.get(list.get(0)).add(list.get(j));
                }
            }

        }
        return dfs("", roots, region1, region2);
    }

    private String dfs(String p, Set<String> children, String region1, String region2) {

        if (children == null || children.isEmpty()) {
            return null;
        }
        if (children.contains(region1) || children.contains(region2)) {
            return p;
        }
        for (String s : children) {
            String res = dfs(s, map.get(s), region1, region2);
            if (res != null) {
                return s;
            }
        }
        return null;
    }
}
