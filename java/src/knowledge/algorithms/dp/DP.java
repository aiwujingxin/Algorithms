package knowledge.algorithms.dp;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 01:45
 * @description 动态规划 动态规划是一种基于最优子结构和重叠子问题，通过构造状态转移关系、自底向上求解问题最优解的算法思想。
 * <概念>
 * 核心思想: 基于规模的算法，动态寻找分割点,产生重叠子问题
 * 原理:    最优重叠子问题
 * 本质:    用一个属性(最优解)表示一种方案的集合, 进而考虑集合之间的依赖关系
 * 依赖关系: 逆拓扑排序
 * <分类>
 * @see knowledge.algorithms.dp.linerdp     线性DP
 * @see knowledge.algorithms.dp.backpack    背包DP
 * @see knowledge.algorithms.dp.intervaldp  区间DP
 * @see knowledge.algorithms.dp.treedp      树形DP
 * @see knowledge.algorithms.dp.compressdp  状压DP
 * @see knowledge.algorithms.dp.digitdp     数位DP
 * @see knowledge.algorithms.dp.gamedp      博弈DP
 * @see knowledge.algorithms.dp.optimizedp  优化DP
 */
public interface DP {
}
