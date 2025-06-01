package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 00:24
 * @description 对称性构造
 */
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        // 初始格雷码序列只有一个元素：0
        res.add(0);
        // 逐位生成格雷码，从第0位到第n-1位
        for (int i = 0; i < n; i++) {
            // 当前位对应的数值，例如i=0时为1，i=1时为2，依此类推
            int add = 1 << i;
            int size = res.size();

            // 逆序遍历当前已有的格雷码序列，将每个元素加上当前位的值，
            // 这样只改变一位，符合格雷码定义
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + add);
            }
        }
        return res;
    }
}
