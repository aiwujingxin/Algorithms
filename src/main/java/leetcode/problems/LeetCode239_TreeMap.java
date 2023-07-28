package leetcode.problems;

import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/6 23:58
 */

//https://leetcode.com/problems/sliding-window-maximum/solutions/965062/java-solution-using-treemap-and-sliding-window/
public class LeetCode239_TreeMap {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int[] result = new int[size - k + 1];
        int start = 0;
        int end = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (end < size) {
            treeMap.put(nums[end], treeMap.getOrDefault(nums[end], 0) + 1);
            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {

                result[start] = treeMap.lastKey();
                treeMap.put(nums[start], treeMap.getOrDefault(nums[start], 0) - 1);
                if (treeMap.get(nums[start]) == 0) {
                    treeMap.remove(nums[start]);
                }
                start++;
                end++;
            }
        }
        return result;
    }
}
