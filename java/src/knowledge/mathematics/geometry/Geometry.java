package knowledge.mathematics.geometry;

import knowledge.mathematics.geometry.util.ComputationalGeometry;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 10:51
 * @description 计算几何与矩阵几何精选模板及题型导航
 * <解题识别>
 * 1. 点在直线哪一侧、三点是否共线 → 叉积，不要使用斜率。
 * 2. 线段是否相交 → 方向判定 + 跨立实验 + 共线端点特判。
 * 3. 多边形面积 → 鞋带公式；整数坐标先保留二倍面积。
 * 4. 大量矩形覆盖面积 → 扫描线 + 离散化 + 线段树。
 * 5. 网格中的矩形/正方形 → 前缀和、单调栈或 DP，通常不是连续几何。
 * <数值纪律>
 * - 整数判定优先 long 叉积；坐标乘积仍可能溢出，必须核对范围。
 * - 浮点相等使用 |a-b|≤EPS，不直接写 a==b。
 * - 比较距离优先比较平方，避免无意义的 sqrt。
 * @see ComputationalGeometry 计算几何基础工具类 (含直线交点、点到线段距离、Pick 定理)
 * @see knowledge.mathematics.geometry.impl.ConvexHull 凸包算法 (Andrew's Monotone Chain)
 * @see knowledge.mathematics.geometry.impl.RotatingCalipers 旋转卡壳 (最远点对)
 * @see knowledge.mathematics.geometry.impl.MinimumEnclosingCircle 最小外接圆 (Welzl算法)
 * @see knowledge.mathematics.geometry.impl.PointInPolygon 点在多边形内部判断 (射线法)
 * @see knowledge.mathematics.geometry.impl.ConvexPolygonContains 凸多边形 O(log n) 点定位
 * @see knowledge.mathematics.geometry.impl.ClosestPair 最近点对 (分治)
 * @see knowledge.mathematics.geometry.impl.CircleOperations 圆-线 / 圆-圆 交点
 * @see knowledge.mathematics.geometry.impl.HalfPlaneIntersection 半平面交
 * (难度标记: E=Easy  M=Medium  H=Hard)
 * <I. 点 / 向量 / 直线>
 * cross(a,b,c) 的符号表示转向；共线点分组时方向向量应先除以 gcd 规范化。
 * @see LeetCode149 [H] 直线上最多的点数
 * <II. 线段 / 矩形端点>
 * 轴对齐矩形交集宽=max(0,min(r1,r2)-max(l1,l2))，高同理。
 * 任意正方形可用六个两两距离满足“四边相等、两对角线相等”判定。
 * @see LeetCode223  [M] 矩形面积
 * @see LeetCode593  [M] 有效的正方形
 * @see LeetCode3047 [M] 求交集区域内的最大正方形面积
 * <III. 三角形 / 多边形面积>
 * 三角形二倍面积等于叉积绝对值；多边形用相邻顶点叉积求和。
 * @see LeetCode812 [E] 最大三角形面积
 * <IV. 圆 / 距离>
 * 圆内判定比较 dx²+dy² 与 r²；计数覆盖常枚举格点或圆心。
 * 圆-线、圆-圆交点用联立方程 + 判别式，注意相切与分离的 EPS 判定。
 * @see LeetCode2249 [M] 统计圆内格点数目
 * @see knowledge.mathematics.geometry.impl.CircleOperations
 * <V. 柱状图 / 矩阵几何>
 * 这些题的“几何”来自连续区域，核心数据结构通常是单调栈或 DP。
 * @see LeetCode84   [H] 柱状图中最大的矩形
 * @see LeetCode85   [H] 最大矩形
 * @see LeetCode221  [M] 最大正方形
 * @see LeetCode1504 [M] 统计全 1 子矩形
 * @see LeetCode1277 [M] 统计全为 1 的正方形子矩阵
 * @see LeetCode764  [M] 最大加号标志
 * <VI. 容器 / 接雨水>
 * 一维可用双指针或单调栈；二维按最低边界优先扩张，本质是瓶颈最短路。
 * @see LeetCode11  [M] 盛最多水的容器
 * @see LeetCode42  [H] 接雨水
 * @see LeetCode407 [H] 接雨水 II
 * <VII. 二维前缀和>
 * 矩形和由四个前缀块容斥得到；固定上下边界可降维成一维子数组问题。
 * @see LeetCode304 [M] 二维区域和检索 - 矩阵不可变
 * @see LeetCode363 [H] 矩形区域不超过 K 的最大数值和
 * @see LeetCode939 [M] 最小面积矩形
 * <VIII. 扫描线>
 * 将二维覆盖按 x 方向切成事件，维护 y 轴当前覆盖长度；面积=覆盖长度*Δx。
 * 多重覆盖不能只用布尔值，需维护覆盖次数与区间有效长度。
 * @see LeetCode218  [H] 天际线问题
 * @see LeetCode391  [H] 完美矩形
 * @see LeetCode850  [H] 矩形面积 II
 * @see LeetCode3454 [H] 分割正方形 II
 * <IX. 最近点对 / 半平面交>
 * 最近点对分治后只需检查跨中线宽 2d 竖带内按 y 排序的相邻常数个点，得 O(n log n)。
 * 半平面交把每个约束写成有向直线，极角排序后双端队列增量维护，得到凸可行域。
 * @see knowledge.mathematics.geometry.impl.ClosestPair
 * @see knowledge.mathematics.geometry.impl.HalfPlaneIntersection
 * <X. 格点 / Pick 定理>
 * 顶点为整点的简单多边形，内部格点 I = A - B/2 + 1，其中边界格点 B 为各边端点差 gcd 之和。
 * @see knowledge.mathematics.geometry.util.ComputationalGeometry
 */
public interface Geometry {
}
