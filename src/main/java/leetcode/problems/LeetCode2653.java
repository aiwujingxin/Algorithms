package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/4 00:37
 */

public class LeetCode2653 {

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];//存放返回结果
        Map<Integer, Integer> nmap = new TreeMap<>();// key 数字 ： value 个数
        for (int i = 0; i < nums.length; i++) { //遍历每一个数字
            nmap.put(nums[i], nmap.getOrDefault(nums[i], 0) + 1);//集合中包含这个数字,对其 value + 1
            if (i >= k - 1) {
                int j = 0;
                for (int key : nmap.keySet()) {
                    j += nmap.get(key);
                    if (j >= x) {
                        result[i - k + 1] = Math.min(key, 0);
                        break;
                    }
                }
                nmap.put(nums[i - k + 1], nmap.get(nums[i - k + 1]) - 1);//集合中包含多个这个数字,对其 value - 1
                if (nmap.get(nums[i - k + 1]) == 0) {//集合中包含 1 个这个数字
                    nmap.remove(nums[i - k + 1]);
                }
            }
        }

        return result;
    }
}
