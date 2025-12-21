package knowledge.algorithms.greedy;

import knowledge.algorithms.greedy.problems.GreedyLoading;
import knowledge.algorithms.greedy.problems.MaxActivity;
import knowledge.algorithms.greedy.problems.MinCover;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2025/12/21 22:55
 * @description 贪心算法精选题单
 * 1. 观察问题结构：分析是否存在「局部最优决策可推导全局最优」的性质。
 * 2. 设计贪心策略：确定每一步的选择规则（最小/最大、配对、反悔等）。
 * 3. 验证策略正确性：通过交换论证法或反证法，确保不破坏全局最优。
 * <价值优先型>
 * @see GreedyLoading       最优装载问题
 * * <静态极值-排序>
 * @see LeetCode455         分发饼干
 * @see LeetCode860         柠檬水找零 (优先找零大面额)
 * @see LeetCode605         种花问题 (防御式贪心)
 * @see LeetCode1402        做菜顺序
 * @see LeetCode870         优势洗牌 (田忌赛马)
 * @see LeetCode1899        合并若干三元组以形成目标三元组
 * * <动态极值-堆>
 * @see LeetCode2182        构造限制重复的字符串
 * @see LeetCode1962        移除石子使总数最小
 * @see LeetCode767         重构字符串 (隔板法)
 * @see LeetCode2233        K次增加后的最大乘积
 * @see LeetCode2856        删除数对后的最小数组长度 (堆模拟/数学)
 * * <代价合并> (哈夫曼思想)
 * @see LeetCode1167        连接棒材的最低费用
 * <区间问题>
 * @see MaxActivity         活动选择（最大）不重叠
 * @see MinCover            区间覆盖（最少）覆盖
 * * <活动选择 不重叠>
 * @see LeetCode435         无重叠区间
 * @see LeetCode646         最长数对链
 * * <分组 会议室>
 * @see LeetCode253         会议室 II
 * @see LeetCode2406        将区间分为最少组数 (差分/扫描线)
 * * <覆盖 合并>
 * @see LeetCode452         用最少数量的箭引爆气球
 * @see LeetCode2580        统计将重叠区间合并成组的方案数
 * @see LeetCode1288        删除被覆盖区间
 * @see LeetCode1326        灌溉花园的最少水龙头数目 (跳跃游戏变种)
 * @see LeetCode757         设置交集大小至少为2
 * * <区间 堆> (带截止时间的调度)
 * @see LeetCode1353        最多可以参加的会议数目 (按开始时间排序，堆维护结束时间)
 * @see LeetCode1705        吃苹果的最大数目
 * @see LeetCode2589        完成所有任务的最少时间
 * <贪心构造>
 * * <字典序>
 * @see LeetCode31          下一个排列
 * @see LeetCode670         最大交换
 * @see LeetCode2375        根据模式串构造最小数字
 * * <回文串>
 * @see LeetCode564         寻找最近的回文数
 * @see LeetCode2384        最大回文数字
 * @see LeetCode266         回文排列
 * * <双向扫描>
 * @see LeetCode135         分发糖果 (既要又要)
 * @see LeetCode955         删列造序 II
 * * <单调栈> (保留字典序最小/最大)
 * @see LeetCode402         移掉 K 位数字 (核心)
 * @see LeetCode321         拼接最大数 (双栈合并)
 * @see LeetCode316         去除重复字母
 * @see LeetCode1081        不同字符的最小子序列
 * * <括号与计数>
 * @see LeetCode678         有效的括号字符串 (维护区间 [min, max])
 * @see LeetCode921         使括号有效的最少添加
 * <跳跃游戏> (覆盖模型)
 * @see LeetCode55          跳跃游戏
 * @see LeetCode45          跳跃游戏 II
 * @see LeetCode134         加油站
 * @see LeetCode1024        视频拼接
 * @see LeetCode1306        跳跃游戏 III
 * @see LeetCode1696        跳跃游戏 VI (单调队列)
 * <反悔贪心> (堆维护已选集合)
 * @see LeetCode871         最低加油次数
 * @see LeetCode630         课程表 III
 * @see LeetCode2813        子序列最大优雅度
 * @see LeetCode3049        标记所有下标的最早秒数 II
 * <数学 其他>
 * @see LeetCode179         最大数 (排序不等式)
 * @see LeetCode1005        K 次取反后最大化的数组和
 * @see LeetCode121         买卖股票的最佳时机 (贪心记录最小值)
 * @see LeetCode122         买卖股票的最佳时机 II (收集正利润)
 * @see LeetCode968         监控二叉树 (树形贪心，自底向上)
 */
public interface Greedy {
}
