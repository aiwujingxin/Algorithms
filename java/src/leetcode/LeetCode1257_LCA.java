package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 17:11
 * @see LeetCode160_v2
 */
public class LeetCode1257_LCA {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        // u -> fa
        Map<String, String> faMap = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                faMap.put(region.get(i), region.get(0));
            }
        }
        // LCA
        String p1 = region1;
        String p2 = region2;
        while (!p1.equals(p2)) {
            p1 = faMap.getOrDefault(p1, region2);
            p2 = faMap.getOrDefault(p2, region1);
        }
        return p1;
    }
}
