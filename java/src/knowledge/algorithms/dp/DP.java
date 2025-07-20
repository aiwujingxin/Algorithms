package knowledge.algorithms.dp;

/**
 * @author wujingxinit@outlook.com
 * @description 动态规划：利用最优子结构和重叠子问题，将问题划分为状态集合，
 * 构建状态转移方程，在依赖图的逆拓扑序中自底向上求解全局最优解。
 * @see knowledge.algorithms.dp.linerdp     线性DP：在一维结构上通过前缀状态递推当前位置的最优解
 * @see knowledge.algorithms.dp.backpack    背包DP：在容量约束下通过物品选择转移构建最优组合
 * @see knowledge.algorithms.dp.intervaldp  区间DP：枚举区间划分点，合并子区间递推整体区间最优解
 * @see knowledge.algorithms.dp.treedp      树形DP：在树上自底向上传递状态，合并子树构造整棵树最优解
 * @see knowledge.algorithms.dp.compressdp  状压DP：使用位运算压缩状态集合，在指数状态空间中高效转移
 * @see knowledge.algorithms.dp.digitdp     数位DP：逐位构建状态，结合前缀限制和数值统计进行转移
 * @see knowledge.algorithms.dp.optimizedp  优化DP：利用单调性、凸性等数学结构优化状态转移效率
 */
public interface DP {
}
