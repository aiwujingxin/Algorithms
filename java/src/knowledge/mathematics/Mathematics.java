package knowledge.mathematics;

import knowledge.mathematics.algebra.Algebra;
import knowledge.mathematics.bigdecimal.BigDecimal;
import knowledge.mathematics.combinatorics.Combinatorics;
import knowledge.mathematics.geometry.Geometry;
import knowledge.mathematics.probability.Probability;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 数学算法全景索引与六维深度解析
 * <缘起>
 * 在算法竞赛与工业级基础设施中，数学不仅是性能优化的极致武器（如将 O(N) 降维打击到 O(1)），
 * 更是解决大规模离散问题的理论基石。从底层的密码学（数论）到高层的大数据统计（概率），
 * 算法中的数学模块构成了解决复杂工程挑战的底层原语。
 * <工业级实现>
 * - 溢出防御: 采用倍增法、安全模运算（safeAdd/safeMul）与 {@code Math.multiplyExact} 严格防御 64 位整数溢出。
 * - 内存连续性与缓存亲和: 筛法（如欧拉筛）采用扁平的一维数组维护，保证连续内存访问，最大化 L1 Cache 命中率。
 * - O(1) 高频查询: 封装基于质数模数的阶乘逆元预处理类，通过 O(N) 的初始化实现 O(1) 的海量组合数查询。
 * - 高精度降级: 针对超出 64 位整型的场景，封装基于链表与数组的高精度大数模拟（BigDecimal）。
 * <本质权衡>
 * - 时空置换: (如欧拉筛、阶乘预处理) 牺牲 O(N) 的内存与预处理时间，换取 O(1) 的极速单次高频查询。
 * - 精度与性能: 在计算几何中，能用整数乘法（如叉积判定转向、比较距离平方）则坚决拒绝浮点开方与除法，彻底根除 {@code EPSILON} 精度抖动带来的边界误判。
 * <落地实战>
 * @see Algebra       代数与数论导航 (GCD、扩展欧几里得、快速幂、筛法、同余定理)
 * @see Combinatorics 组合数学导航 (排列组合、斯特林数、卡塔兰数、容斥原理)
 * @see Probability   概率与期望导航 (条件概率、概率DP、期望方程、拒绝采样)
 * @see Geometry      计算几何导航 (叉积转向、线段相交、多边形面积、扫描线)
 * @see BigDecimal    高精度运算导航 (大整数加减乘除底层实现)
 * @see MathUtil      基础数学工具箱 (日常高频复用的静态数学计算函数)
 * <融会贯通>
 * - 数论 × 组合: 求组合数时遇到大模数，需利用费马小定理或扩展欧几里得求乘法逆元，突破除法无法直接取模的壁垒。
 * - 几何 × 数据结构: 求解矩形覆盖面积时，将二维几何坐标离散化，结合扫描线与线段树，将空间维度降维为代数区间的动态维护。
 * - 期望 × 图论: 迷宫中的随机游走问题，常通过构建状态转移图，并应用高斯消元解线性方程组求出全局状态期望。
 */
public interface Mathematics {
}
