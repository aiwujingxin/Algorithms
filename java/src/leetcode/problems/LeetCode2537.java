package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/6 22:41
 */
public class LeetCode2537 {

    public static void main(String[] args) {
        System.out.println(new LeetCode2537().countGood(new int[]{1, 1, 1, 1, 1}, 10));
        System.out.println(new LeetCode2537().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }

    public long countGood(int[] nums, int k) {
        // 记录窗口内的元素对应个数
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int left = 0;
        int right = 0;
        int pairs = 0;
        long ans = 0;
        // 枚举右边界
        while (right < nums.length) {
            // 更新pairs （若之前有x个num，则pairs+=x）
            pairs += cnt.getOrDefault(nums[right], 0);
            cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            // 缩小左边界
            // 有一种夹逼定理的感觉
            while (pairs - (cnt.get(nums[left]) - 1) >= k) {
                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                pairs -= cnt.get(nums[left]);
                left += 1;
            }
            // 更新ans
            if (pairs >= k) {
                ans += left + 1;
            }
            right++;
        }
        return ans;
    }
}
