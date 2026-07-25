package knowledge.datastructure.stack;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2/20/26 18:23
 * @description 栈 (Stack) 精选题单(导航索引)
 * <解题识别>
 * 出现以下信号优先考虑栈:需要「后进先出」、括号 / 嵌套配对、表达式求值、或为每个元素找「最近的更大 / 更小者」。
 * 1. 配对 / 嵌套:遇左符入栈,遇右符弹栈匹配(括号、路径、标签)。
 * 2. 就近关系:单调栈维护候选者,新元素弹出所有「被它压制」的旧元素。
 * 3. 表达式 / 撤销:用栈缓存操作数与运算符,或用双栈实现队列 / 最值。
 * <模板实现>
 * @see MyStack             栈基础模板(数组实现,push / pop / peek)
 * @see MonotonicStack      单调栈(左右最近更大 / 更小,详见其内部完整题单)
 * <I. 括号与配对>
 * 策略:遇左括号入栈,遇右括号与栈顶配对;栈空 / 不匹配即非法。
 * @see LeetCode20    有效的括号 (基础配对)
 * @see LeetCode32    最长有效括号 (下标入栈求跨度)
 * @see LeetCode71    简化路径 (目录名入栈, ".." 弹栈)
 * @see LeetCode394   字符串解码 (数字栈 + 字符串栈嵌套展开)
 * <II. 表达式求值>
 * 策略:操作数入栈,遇运算符弹出计算再压回;或先转逆波兰。
 * @see LeetCode150   逆波兰表达式求值 (栈式求值模板)
 * @see LeetCode224   基本计算器 (含括号,符号栈)
 * @see LeetCode227   基本计算器 II (乘除优先级)
 * <III. 栈的设计 (Design)>
 * 策略:辅助栈 / 双栈达成 O(1) 附加能力。
 * @see LeetCode155   最小栈 (辅助栈同步维护当前最小)
 * @see LeetCode232   用栈实现队列 (双栈倒腾)
 * @see LeetCode225   用队列实现栈
 * @see LeetCode946   验证栈序列 (模拟入栈 / 出栈)
 * <IV. 单调栈(贪心构造)>
 * 策略:维护单调性,通过弹栈保证结果字典序最优 / 就近最值。详见 MonotonicStack 完整题单。
 * @see LeetCode739   每日温度 (右侧最近更大)
 * @see LeetCode84    柱状图中最大的矩形 (左右第一个更矮)
 * @see LeetCode316   去除重复字母 (单调栈 + 贪心字典序)
 * @see LeetCode402   移掉 K 位数字 (单调栈删峰)
 */
public interface Stack {
}
