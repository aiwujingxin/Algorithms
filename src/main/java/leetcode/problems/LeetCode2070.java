package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/7 17:28
 */
public class LeetCode2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        // 1. 按照item[0]升序,同样的item[0],按照item[1]降序
        Arrays.sort(items, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        // 2. 将items数组中的item[1]更新为最大值(相当于动态规划)
        int maxBeauty = 0;
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            item[1] = maxBeauty;
        }
        // 3. 对每个query进行二分查找, 找出其最大美丽值
        for (int i = 0; i < queries.length; i++) {
            int index = bsearch_2(items, queries[i]);
            if (items[index][0] < queries[i]) {
                ans[i] = items[index][1];
            }
        }
        return ans;
    }

    public int bsearch_2(int[][] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid][1] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
