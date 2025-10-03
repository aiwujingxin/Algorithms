package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:52
 */
public class LeetCode2170 {

    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        int n = nums.length;

        // 统计偶数位和奇数位频率
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenFreq.put(nums[i], evenFreq.getOrDefault(nums[i], 0) + 1);
            } else {
                oddFreq.put(nums[i], oddFreq.getOrDefault(nums[i], 0) + 1);
            }
        }

        // 获取频率最高和第二高的数字及其次数
        int[] evenTop = getTopTwo(evenFreq);
        int[] oddTop = getTopTwo(oddFreq);

        // 情况1：偶数位最高 != 奇数位最高 → 不冲突
        if (evenTop[0] != oddTop[0]) {
            return n - (evenTop[1] + oddTop[1]);
        }

        // 情况2：偶数位最高频数字 == 奇数位最高频数字 → 会导致相邻元素相同，不允许
        // 需要考虑使用第二高频数字来避免冲突

        // 方案1：偶数位保持最高频数字，奇数位选择第二高频数字
        // evenTop[1] -> 偶数位最高频数字出现次数
        // oddTop[2]  -> 奇数位第二高频数字出现次数
        // 修改次数 = 总长度 n - 保持不变的次数
        int option1 = n - (evenTop[1] + oddTop[2]);

        // 方案2：奇数位保持最高频数字，偶数位选择第二高频数字
        // oddTop[1]  -> 奇数位最高频数字出现次数
        // evenTop[2] -> 偶数位第二高频数字出现次数
        // 修改次数 = 总长度 n - 保持不变的次数
        int option2 = n - (evenTop[2] + oddTop[1]);

        // 最终取两种方案中修改次数最少的那个
        return Math.min(option1, option2);
    }

    // 返回数组：{最高频数字, 最高频次数, 第二高频次数}
    private int[] getTopTwo(Map<Integer, Integer> freq) {
        int top1Count = 0, top2Count = 0;
        int top1Num = -1;
        for (int num : freq.keySet()) {
            int count = freq.get(num);
            if (count > top1Count) {
                top2Count = top1Count;
                top1Count = count;
                top1Num = num;
            } else if (count > top2Count) {
                top2Count = count;
            }
        }
        return new int[]{top1Num, top1Count, top2Count};
    }
}
