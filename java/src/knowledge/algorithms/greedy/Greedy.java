package knowledge.algorithms.greedy;

import knowledge.algorithms.greedy.problems.*;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/21 22:55
 * @description 贪心
 * 1. 观察问题结构：分析是否存在「局部最优决策可推导全局最优」的性质，判断贪心是否可行。
 * 2. 设计贪心策略：确定每一步的选择规则（如最小/最大、从左/右、配对、划分等）。
 * 3. 验证策略正确性：可通过交换论证法、数学证明或反例排除，确保贪心策略不会漏掉最优解。
 * 一句话概括：贪心就是在每一步选择局部最优，用最简单直接的方式逼近全局最优，但必须验证这种局部选择不会破坏整体最优。
 * <基础>
 * @see MaxActivity     活动选择（最大）不重叠
 * @see MinCover        区间覆盖（最少）覆盖
 * @see GreedyLoading   最优装载问题
 * <最值策略>
 * <抽象策略>
 * @see LeetCode1899    合并若干三元组以形成目标三元组
 * <堆>
 * @see LeetCode2182    构造限制重复的字符串
 * @see LeetCode1962    移除石子使总数最小
 * @see LeetCode767     移除石子使总数最小
 * @see LeetCode2497    图中最大星和
 * @see LeetCode2233    K次增加后的最大乘积
 * @see LeetCode2406    将区间分为最少组数
 * <排序>
 * @see LeetCode2567    修改两个元素的最小分数
 * @see LeetCode1402    做菜顺序
 * <区间问题>
 * @see LeetCode435     无重叠区间
 * @see LeetCode452     用最少数量的箭引爆气球
 * @see LeetCode646     最长数对链
 * @see LeetCode2406    将区间分为最少组数
 * @see LeetCode253     会议室 II
 * @see LeetCode2580    统计将重叠区间合并成组的方案数
 * @see LeetCode1288    删除被覆盖区间
 * @see LeetCode2054    两个最好的不重叠活动
 * @see LeetCode1705    吃苹果的最大数目
 * @see LeetCode1353    最多可以参加的会议数目
 * @see LeetCode2589    完成所有任务的最少时间
 * @see LeetCode757
 * <跳跃游戏>
 * @see LeetCode55      跳跃游戏
 * @see LeetCode45      跳跃游戏 II
 * @see LeetCode134     加油站
 * @see LeetCode1024    视频拼接
 * @see LeetCode2584    分割数组使乘积互质
 * LeetCode1326
 * <分配问题>
 * @see LeetCode455     分发饼干
 * @see LeetCode135     分发糖果
 * @see LeetCode870     优势洗牌
 * @see LeetCode1326
 */
public interface Greedy {
}
