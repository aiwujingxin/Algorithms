package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 22:52
 */
public class LeetCode1104 {

    public static void main(String[] args) {
        System.out.println(new  LeetCode1104().pathInZigZagTree(12));
    }

    public List<Integer> pathInZigZagTree(int target) {
        List<Integer> res = new ArrayList<>();
        int depth = (int) (Math.log(target) / Math.log(2)) + 1;     // ln(target) / ln(2)

        // 每上一层，反转一次
        while (target > 1) {
            res.add(0, target);
            target = target / 2;
            depth--;
            // 上一层最右边和最左边的值
            int right = (int) (Math.pow(2, depth) - 1);
            int left = (int) (Math.pow(2, depth - 1));
            // 反转
            target = right - (target - left);
        }
        res.add(0, 1);      // 加入根节点
        return res;
    }
}
