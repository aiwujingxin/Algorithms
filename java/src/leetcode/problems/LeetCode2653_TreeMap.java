package leetcode.problems;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 7/26/26 12:08
 */
public class LeetCode2653_TreeMap {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];//存放返回结果
        Map<Integer, Integer> nmap = new TreeMap<>();// key 数字 ： value 个数
        for (int i = 0; i < nums.length; i++) { //遍历每一个数字
            if (!nmap.containsKey(nums[i])) {//集合中不包含这个数字
                nmap.put(nums[i], 1);
            } else {
                nmap.put(nums[i], nmap.get(nums[i]) + 1);//集合中包含这个数字,对其 value + 1
            }

            if (i >= k - 1) {
                int j = 0;
                for (int key : nmap.keySet()) {
                    j += nmap.get(key);
                    if (j >= x) {
                        result[i - k + 1] = Math.min(key, 0);
                        break;
                    }
                }
                if (nmap.get(nums[i - k + 1]) == 1) {//集合中包含 1 个这个数字
                    nmap.remove(nums[i - k + 1]);
                } else {
                    nmap.put(nums[i - k + 1], nmap.get(nums[i - k + 1]) - 1);//集合中包含多个这个数字,对其 value - 1
                }
            }
        }

        return result;
    }
}
