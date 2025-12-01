package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 11/17/25 12:53
 */
public class LeetCode3447 {

    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            if (!numMap.containsKey(elements[i])) {
                numMap.put(elements[i], i);
            }
        }
        int max = 0;
        for (int group : groups) {
            max = Math.max(group, max);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int value = entry.getKey();
            int index = entry.getValue();
            for (int i = 0; i * value <= max; i++) {
                map.put(i * value, Math.min(map.getOrDefault(i * value, Integer.MAX_VALUE), index));
            }
        }
        for (int i = 0; i < groups.length; i++) {
            ans[i] = map.getOrDefault(groups[i], -1);
        }
        return ans;
    }

}
