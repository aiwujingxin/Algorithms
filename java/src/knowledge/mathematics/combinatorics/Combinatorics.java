package knowledge.mathematics.combinatorics;

import knowledge.mathematics.combinatorics.impl.CatalanNumber;
import knowledge.mathematics.combinatorics.impl.PascalsTriangle;
import knowledge.mathematics.combinatorics.impl.StirlingNumbers;
import knowledge.mathematics.combinatorics.util.CombinatoricsUtil;
import leetcode.problems.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:16
 * @description 组合数学精选模板与题型导航
 * <解题识别>
 * 1. 题目问“有多少种方案”而非最优值，优先寻找排列、组合、划分或递推结构。
 * 2. 对象不同且顺序重要用排列 P；顺序不重要用组合 C；对象相同转隔板或生成函数。
 * 3. 存在“至少一个不满足”时，优先考虑补集或容斥，而不是直接分类枚举。
 * 4. 一个元素对多个答案产生贡献时，反向计算它被多少结构包含。
 * <核心工具>
 * @see CombinatoricsUtil 精确组合数、质数模组合数、错排与卡塔兰数
 * @see knowledge.mathematics.combinatorics.impl.LucasTheorem 卢卡斯定理 (求解大组合数取模)
 * @see knowledge.mathematics.combinatorics.impl.ExLucas 扩展卢卡斯 (合数模组合数)
 * @see knowledge.mathematics.combinatorics.impl.StarsAndBars 隔板法 (方程非负/正整数解计数)
 * @see PascalsTriangle   杨辉三角、二项式系数与组合数全表
 * @see CatalanNumber     卡塔兰数递推 (含取模版本)
 * @see StirlingNumbers   第二类斯特林数 (含取模全表)
 * @see knowledge.mathematics.combinatorics.impl.FirstKindStirling 第一类斯特林数
 * @see knowledge.mathematics.combinatorics.impl.BellNumber 贝尔数 (集合划分总数)
 * @see knowledge.mathematics.combinatorics.impl.EulerianNumber 欧拉数 (排列升高位计数)
 * @see knowledge.mathematics.combinatorics.impl.Multinomial 多项式系数 (可重排列)
 * @see knowledge.mathematics.combinatorics.impl.IntegerPartition 整数拆分
 * @see knowledge.mathematics.combinatorics.impl.InclusionExclusion 容斥原理通用模板
 * @see knowledge.mathematics.combinatorics.impl.BurnsidePolya Burnside 引理 / Polya 计数
 * (难度标记: E=Easy  M=Medium  H=Hard)
 * <I. 排列 / 组合 / 子集枚举>
 * 排列关注顺序，组合只关注选择；含重复元素时必须“排序 + 同层去重”。
 * @see LeetCode46      全排列
 * @see LeetCode47      全排列 II（含重复元素）
 * @see LeetCode60      第k个排列
 * @see LeetCode77      组合
 * @see LeetCode78      子集
 * @see LeetCode90      子集 II（含重复元素）
 * @see LeetCode357     计数数字序列（无重复）
 * @see LeetCode1359    有效的快递序列数目
 * <II. 多重集组合 / 重复选择>
 * 同一候选可重复选择时递归仍停留当前下标；每个候选只能选一次时进入下一下标。
 * @see LeetCode39      组合总和
 * @see LeetCode40      组合总和 II
 * <III. 集合划分 / Stirling 数 / Bell 数>
 * 第二类 Stirling 数 S(n,k) 表示 n 个不同元素划分成 k 个非空无标号集合。
 * 递推:第 n 个元素单独成组 S(n-1,k-1)，或进入已有 k 组 k*S(n-1,k)。
 * 对所有 k 求和即 Bell 数 B(n)=Σ S(n,k)，表示划分成任意个集合的总方案。
 * @see StirlingNumbers
 * @see knowledge.mathematics.combinatorics.impl.BellNumber
 * @see LeetCode526     美丽排列
 * @see LeetCode894     所有可能的满二叉树
 * <IV. 约束计数 / 动态规划>
 * 当局部选择影响后续可选集合时，状态需记录位置、剩余量或已用集合。
 * @see LeetCode996     方形数组数量
 * @see LeetCode1155    骰子点数总和的数量
 * <V. 卡塔兰数>
 * 识别信号:合法括号、不同 BST、凸多边形三角剖分、不越过对角线的网格路径。
 * 公式:Cn=C(2n,n)/(n+1)；递推:Cn=Σ Ci*C(n-1-i)。
 * @see LeetCode96      不同的二叉搜索树
 * @see LeetCode22      括号生成
 * <VI. 杨辉三角 / 二项式定理>
 * C(n,k)=C(n-1,k-1)+C(n-1,k)，既是递推，也是二维计数 DP 的原型。
 * @see LeetCode118     杨辉三角
 * @see LeetCode119     杨辉三角 II
 * <VII. 容斥 / 补集>
 * |A∪B|=|A|+|B|-|A∩B|；多个事件按交集阶数交替加减。
 * 实战时先写清全集 U 与违规事件 Ai，避免符号和“至少/恰好”口径错误。
 * 通用做法:枚举 2^m 个子集，按 popcount 奇偶决定符号累加交集大小。
 * @see knowledge.mathematics.combinatorics.impl.InclusionExclusion
 * <VIII. 贡献计数>
 * 反向提问“元素 i 出现在多少个答案中”。普通子数组包含次数为 (i+1)*(n-i)；
 * 唯一贡献则由前后最近相同位置界定边界。
 * @see LeetCode2063    所有子字符串中的元音
 * @see LeetCode1180    统计只含单一字母的子串
 * @see LeetCode828     统计子串中的唯一字符
 * @see LeetCode1915    最美子字符串的数目
 * @see LeetCode2348    全 0 子数组的数目
 * <IX. 连续段计数>
 * 长度为 len 的连续段包含 len*(len+1)/2 个子数组；扫描断点后分段累加。
 * <X. 整数拆分 / 多项式系数>
 * 整数拆分 p(n) 计数把 n 写成无序正整数之和的方案，可用完全背包或五边形数定理 O(n√n)。
 * 多项式系数 n!/(k1!k2!...) 是可重集全排列去重，也是把 n 个物品按标号分组的方案数。
 * @see knowledge.mathematics.combinatorics.impl.IntegerPartition
 * @see knowledge.mathematics.combinatorics.impl.Multinomial
 * <XI. 等价类计数 (Burnside / Polya)>
 * 群作用下本质不同的方案数 = 各置换不动点数的平均值；旋转 k 位的循环数为 gcd(n,k)。
 * 识别信号:项圈/手镯染色、正多边形在旋转反射下等价、循环同构去重。
 * @see knowledge.mathematics.combinatorics.impl.BurnsidePolya
 */

public interface Combinatorics {

    /**
     * 计算每个位置作为同值元素“唯一代表”时的加权贡献。
     * 元素 nums[i] 可向左扩展 i-prev[i] 种，向右扩展 next[i]-i 种。
     */
    default long contributionTemplate(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Map<Integer, Integer> lastIndex = new HashMap<>();

        // 计算 prev
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            prev[i] = lastIndex.getOrDefault(x, -1);
            lastIndex.put(x, i);
        }

        lastIndex.clear();
        // 计算 next
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            next[i] = lastIndex.getOrDefault(x, n);
            lastIndex.put(x, i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (i - prev[i]) * (next[i] - i);
        }
        return ans;
    }
}
