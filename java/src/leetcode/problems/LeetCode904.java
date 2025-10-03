package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/13 22:46
 */
public class LeetCode904 {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.merge(fruits[right], 1, Integer::sum);
            while (map.size() > 2) {
                map.merge(fruits[left], -1, Integer::sum);
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
