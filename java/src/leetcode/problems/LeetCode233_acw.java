package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2024/9/16 2:38
 * @description 数位dp acwing模版
 * @link <a href="https://www.acwing.com/solution/content/53389/"></a>
 */
public class LeetCode233_acw {

    final int N = 10;
    int[][][] f = new int[N + 1][10][10];

    public int countDigitOne(int n) {
        if (n <= 0) return 0; //边界条件
        init();
        return dp(n, 1);
    }

    void init() {
        // 初始化
        for (int i = 0; i <= 9; ++i) {
            f[1][i][i] = 1;
        }
        for (int i = 2; i <= N; ++i) { // 枚举位数
            for (int j = 0; j <= 9; ++j) { // 枚举最高位
                for (int u = 0; u <= 9; ++u) {  // 计算数字 u 出现的次数
                    if (u == j) {
                        f[i][j][u] += (int) Math.pow(10, i - 1);
                    }
                    for (int k = 0; k <= 9; ++k) {
                        f[i][j][u] += f[i - 1][k][u];
                    }
                }
            }
        }
    }

    int dp(int n, int u) {
        if (n == 0) {
            return u != 0 ? 0 : 1;
        }

        // 存储数字 n 的每一位数字
        List<Integer> nums = new ArrayList<>();

        while (n != 0) {
            nums.add(n % 10);
            n /= 10;
        }

        int res = 0;
        int last = 0;  // 前面位数出现的 u 的个数

        for (int i = nums.size() - 1; i >= 0; i--) {  // 从最高位开始枚举
            int x = nums.get(i);

            // 统计后面 u 的个数
            // 计算最高位填 0 ~ x - 1 的情况
            // 记得最高位特判前导 0 的情况,需要从 1 开始（关键）
            for (int j = (i == nums.size() - 1 ? 1 : 0); j < x; ++j) {
                res += f[i + 1][j][u];
            }

            // 统计前面 u 的个数
            res += last * x * (int) Math.pow(10, i);

            // 进入右分支
            if (x == u) {
                last++;
            }

            // 枚举到最后一个数字了 ，结果再加上最后一个数字含有的 u 的数量,即为 last
            if (i == 0) {
                res += last;
            }
        }

        // 所有 0~n-1 位数的方案数量,例如 000123 是不合法的,而 123 确实合法的
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 1; j <= 9; j++) {
                res += f[i][j][u];
            }
        }

        return res;
    }
}