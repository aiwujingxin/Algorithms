package knowledge.mathematics.algebra;

import knowledge.algorithms.search.problems.EightPuzzle_astar;
import knowledge.mathematics.MathUtil;
import knowledge.mathematics.algebra.impl.Sieve;
import knowledge.mathematics.algebra.problems.*;
import knowledge.mathematics.algebra.util.NumberTheory;
import knowledge.mathematics.bigdecimal.BigDecimal;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/21 22:06
 * @description 数论 / 代数精选模板与题型导航
 * <解题识别>
 * 1. 结果极大但只关心余数 → 模运算、快速幂、逆元。
 * 2. 出现整除、周期、公共尺度 → GCD/LCM、质因数分解、欧拉函数。
 * 3. 方程要求整数解 → 扩展欧几里得、贝祖定理、线性同余。
 * 4. 多个余数约束同时成立 → 中国剩余定理。
 * 5. 查询区间质数或大量质数 → 埃氏筛、线性筛、分段筛。
 * <核心工具>
 * @see MathUtil        GCD、快速幂、逆元、矩阵快速幂与安全模运算
 * @see NumberTheory    分解质因数、因子、欧拉函数、线性同余与 CRT
 * @see knowledge.mathematics.algebra.impl.EXCRT 扩展中国剩余定理 (处理模数不互质)
 * @see knowledge.mathematics.algebra.impl.BSGS 大步小步算法 (求解高次同余)
 * @see knowledge.mathematics.algebra.impl.ExBSGS 扩展大步小步 (模数与底数不互质)
 * @see knowledge.mathematics.algebra.impl.MobiusInversion 莫比乌斯反演
 * @see knowledge.mathematics.algebra.impl.GaussElimination 高斯消元法
 * @see knowledge.mathematics.algebra.impl.MillerRabin Miller-Rabin 素性测试
 * @see knowledge.mathematics.algebra.impl.PollardRho Pollard-Rho 大数分解
 * @see knowledge.mathematics.algebra.impl.QuadraticResidue 二次剩余 (Tonelli-Shanks / 勒让德-雅可比符号)
 * @see knowledge.mathematics.algebra.impl.Matrix 矩阵模板 (快速幂 / 行列式 / 秩 / 逆)
 * @see knowledge.mathematics.algebra.impl.LinearBasis 异或线性基
 * @see knowledge.mathematics.algebra.impl.NTT 快速数论变换 (多项式卷积)
 * @see Sieve           埃氏筛、线性筛、分段筛与最小质因子筛
 * @see BigDecimal      高精度四则运算导航
 * (难度标记: E=Easy  M=Medium  H=Hard)
 * <I. 整除 / GCD / LCM>
 * 本质:gcd 是两个整数公共“基本尺度”的最大值；辗转相除不断保持公因子集合不变。
 * 模板:gcd(a,b)=gcd(b,a mod b)，lcm=a/gcd(a,b)*b，先除后乘降低溢出风险。
 * @see LeetCode2447 [M] 最大公因数等于 K 的子数组数目
 * <II. 质数 / 因子 / 算术函数>
 * 单次 primality/factorization 用 O(sqrt(n))；上界内批量查询用筛法；大区间用分段筛。
 * @see LeetCode204  [M] 计数质数
 * @see LeetCode762  [E] 二进制表示中质数个计算置位
 * @see LeetCode2521 [M] 数组乘积中的不同质因数数目
 * @see LeetCode2507 [E] 使用质因数之和替换后可以取到的最小值
 * @see LeetCode3233 [M] 统计不是特殊数字的数字数量
 * @see HDU1262          哥德巴赫分解
 * @see HDU2710          最大质因子
 * @see HDU3792          孪生素数计数
 * @see HDU3826          质因数分解
 * @see POJ2689          区间筛
 * <III. 模运算 / 快速幂>
 * 原则:加减乘后立即取模；除法不能直接整除，必须乘模逆元。
 * 快速幂按指数二进制拆分，把 O(exponent) 降为 O(log exponent)。
 * @see LeetCode50   [M] Pow(x,n)
 * @see LeetCode372  [M] 超级次方
 * @see HDU1061          Rightmost Digit
 * <IV. 扩展欧几里得 / 贝祖定理 / 同余>
 * ax+by=g 有整数解当且仅当 gcd(a,b)|g；a 在模 m 下可逆当且仅当 gcd(a,m)=1。
 * 前缀余数相等意味着中间区间和整除 mod，是同余题最常见的数组化表达。
 * @see LeetCode365 [M] 水壶问题
 * @see LeetCode523 [M] 连续的子数组和
 * @see LeetCode974 [M] 和可被 K 整除的子数组
 * <V. 阶乘 / 尾零 / 单调计数>
 * n! 尾零由因子 5 的总指数决定；反向求 n 常用答案单调性 + 二分。
 * @see LeetCode172 [M] 阶乘后的零
 * @see LeetCode793 [H] 阶乘函数后 K 个零
 * <VI. 数位 / 周期 / 构造数学>
 * 将十进制按位权分段，或寻找状态在有限集合中的循环节。
 * @see LeetCode202 [E] 快乐数
 * @see LeetCode400 [M] 第 N 位数字
 * @see LeetCode829 [H] 连续整数求和
 * @see LeetCode319 [M] 灯泡开关
 * <VII. 约瑟夫环 / 排列编码>
 * 约瑟夫递推:f(1)=0，f(n)=(f(n-1)+k) mod n。
 * 康托展开把排列映射为字典序排名，逆展开则按阶乘进制逐位选择。
 * @see LeetCode390        消除游戏
 * @see LeetCode1823 [M]   找出游戏的获胜者
 * @see LeetCode60   [H]   排列序列
 * @see EightPuzzle_astar  排列状态编码
 * <VIII. 随机化>
 * 水塘抽样使第 i 个元素以 1/i 概率替换答案，从未知长度流中等概率抽样。
 * 前缀权重 + 随机数 + 二分可实现按权抽样。
 * @see LeetCode384 [M] 打乱数组
 * @see LeetCode398 [M] 随机数索引
 * @see LeetCode382 [M] 链表随机节点
 * @see LeetCode528 [M] 按权重随机选择
 * <IX. 矩阵快速幂 / 线性递推>
 * 常系数线性递推 f(n)=Σ c_i·f(n-i) 可写成状态向量的矩阵乘法，用矩阵快速幂 O(k^3 log n) 求第 n 项。
 * 邻接矩阵的 k 次幂给出长度恰为 k 的路径数，是计数 DP 的加速原型。
 * @see LeetCode509  [E] 斐波那契数
 * @see LeetCode70   [E] 爬楼梯
 * @see LeetCode1137 [E] 第 N 个泰波那契数
 * @see LeetCode935  [M] 骑士拨号器 (转移矩阵幂)
 * @see LeetCode1220 [H] 统计元音字母序列的数目
 * <X. 线性基 / 异或空间>
 * 把一组数压成至多 63 个线性无关基向量，即可 O(1) 回答异或最值、可表出性与本质不同异或值个数(2^rank)。
 * 前缀异或 + 线性基是处理“子数组/子集异或”类问题的通用降维手段。
 * @see LeetCode421  [M] 数组中两个数的最大异或值
 * @see LeetCode2588 [M] 统计美丽子数组数目
 */
public interface Algebra {
}
