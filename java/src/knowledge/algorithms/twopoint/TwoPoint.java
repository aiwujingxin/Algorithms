package knowledge.algorithms.twopoint;

import knowledge.algorithms.sort.IndexingSort;
import knowledge.datastructure.list.LinkedList;
import leetcode.problems.*;

/**
 * @date 2023/11/7 00:37
 * @description 双指针 (Two Pointers) 算法体系索引
 * <核心思想>
 * 双指针不仅仅是一种代码技巧，更是一种"降低搜索空间"的思维方式。
 * 它利用数据的特定属性（有序性、几何特征、物理约束），将原本需要嵌套循环 O(N^2) 的暴力解法，优化为线性扫描 O(N) 或 O(N log N) 的解法。
 * <实现模式>
 * (1) 模拟/归位: 寻找到合适的数放到合适的位置 (如原地移除元素)
 * (2) 单调性博弈: 利用有序性，避免多次冗余扫描
 * <对撞指针>
 * 本质：利用单调性或贪心策略，每次移动排除掉"绝对不可能"的解。
 * @see LeetCode167     两数之和 II - 输入有序数组 (基础)
 * @see LeetCode15      三数之和 (降维: 定一动二 + 去重技巧)
 * @see LeetCode16      最接近的三数之和
 * @see LeetCode18      四数之和
 * @see LeetCode611     有效三角形的个数 (类似3Sum，判断 a+b>c)
 * @see LeetCode2563    统计公平数对的数目 (计数问题: 固定一端，滑动窗口统计另一端)
 * @see LeetCode75      颜色分类 (荷兰国旗问题: 三指针 L, Cur, R)
 * @see LeetCode287     寻找重复数 (快慢指针在数值空间上的映射)
 * @see LeetCode11      盛最多水的容器 (贪心: 面积由短板决定，移动短板才可能变大)
 * @see LeetCode42      接雨水 (积存: 当前位置能装多少水，取决于左右两边最高挡板的较小值)
 * @see LeetCode977     有序数组的平方 (逆向归并: 利用绝对值两头大中间小的几何特征)
 * <快慢指针>
 * @see IndexingSort    原址排序
 * @see LeetCode26      删除有序数组中的重复项
 * @see LeetCode27      移除元素
 * @see LeetCode80      删除有序数组中的重复项 II
 * @see LeetCode283     移动零
 * @see LeetCode922     按奇偶排序数组 II (双指针跳跃)
 * <链表特性>
 * @see LinkedList      链表相关
 * <滑动窗口>
 * @see SlidingWindow   滑动窗口专题
 * <双序列指针>
 * @see LeetCode88      合并两个有序数组 (逆向双指针技巧)
 * @see LeetCode21      合并两个有序链表
 * @see LeetCode392     判断子序列 (贪心匹配: 能配就配，不能配主串后移)
 * @see LeetCode524     通过删除字母匹配到字典里最长单词
 * @see LeetCode4       寻找两个正序数组的中位数
 * <括号相关>
 * @see LeetCode22      括号生成 (回溯 + 计数器剪枝)
 * @see LeetCode921     使括号有效的最少添加 (贪心: 维护左右需要的括号数)
 * @see LeetCode1963    使字符串平衡的最小交换次数 (贪心: 统计最大闭合失衡度)
 * @see LeetCode32      最长有效括号 (经典: 栈解法 O(N)空间，双指针解法 O(1)空间)
 * @see LeetCode678     有效的括号字符串 (贪心: 维护 balance 的可能范围 [min, max])
 * @see LeetCode2116    判断一个括号字符串是否有效 (贪心: 类似678，结合可变位置判断)
 */
public interface TwoPoint {
}
