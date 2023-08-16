package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/11 16:44
 */
public class LeetCode666 {

    Map<Integer, Integer> map;// 记录深度位置和值的哈希表
    int allSum = 0;//记录总路径和

    public int pathSum(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) { // 把depthPos 和 value 放进哈希表
            map.put(num / 10, num % 10);
        }
        traverse(nums[0] / 10, 0); // 从根节点开始遍历求和
        return allSum;
    }

    void traverse(int i, int sum) {
        if (!map.containsKey(i)) {
            return;
        }
        sum += map.get(i);
        int depth = i / 10;
        int pos = i % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = (depth + 1) * 10 + 2 * pos;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            allSum += sum;
            return;
        }
        traverse(left, sum);
        traverse(right, sum);
    }
}
