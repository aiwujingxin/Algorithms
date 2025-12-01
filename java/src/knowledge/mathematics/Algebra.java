package knowledge.mathematics;

import knowledge.mathematics.impl.MathUtil;
import leetcode.problems.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/21 22:06
 * @description 数论
 * <基础>
 * @see MathUtil
 * <同余定理> (preSum[i]−preSum[j]) mod k==0 ⟺ (preSum[i] mod k) == (preSum[j] mod k)
 * @see LeetCode523
 * @see LeetCode974
 * <gcd>
 * @see LeetCode2447
 * <水塘抽样>
 * https://github.com/jiajunhua/labuladong-fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/%E6%B0%B4%E5%A1%98%E6%8A%BD%E6%A0%B7.md
 * @see LeetCode384
 * @see LeetCode398
 * @see LeetCode382
 * <概率与采样>
 * @see LeetCode528
 * @see LeetCode497
 * <代数运算>
 * @see LeetCode371     加
 * @see LeetCode166     除
 * @see LeetCode29      除
 * @see LeetCode50      幂
 * @see LeetCode372     幂
 * <方程>
 * @see LeetCode829     连续整数求和
 * <质数与因数>
 * @see LeetCode204
 * @see LeetCode762
 * @see LeetCode2521
 * @see LeetCode459
 * @see LeetCode2507
 * @see LeetCode254     因数
 * <平方数>
 * @see LeetCode319
 * <阶乘>
 * @see LeetCode172
 * @see LeetCode793
 * <约瑟夫环> <a href="https://godweiyang.com/2020/03/19/leetcode-interview-62/">...</a>
 * @see LeetCode390
 * @see LeetCode1823
 * <其他>
 * @see LeetCode400     第 N 位数字
 * @see LeetCode60      排列序列
 * @see LeetCode319     灯泡开关
 * @see LeetCode365     水壶问题
 */
public interface Algebra {

    /**
     * 求一个数的所有因子 遍历到sqrt(n)
     */
    static List<Integer> findFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        factors.sort(Integer::compareTo);
        return factors;
    }
}
