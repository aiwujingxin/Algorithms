package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:42
 */
public class LeetCode870 {

    //https://leetcode.cn/problems/advantage-shuffle/solution/you-shi-xi-pai-by-capital-worker-jl94/
    //若num1中有大于num2的数字，我们选择最小的大于num2的数字和其配对。
    //若num1中没有大于num2的数字，则选择num1中最小的数字和其配对。
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            tset.add(x);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);
            if (cur == null) {
                cur = tset.ceiling(-1);
            }
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) {
                tset.remove(cur);
            }
        }
        return ans;
    }
}
