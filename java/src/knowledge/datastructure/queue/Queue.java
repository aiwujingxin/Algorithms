package knowledge.datastructure.queue;

import knowledge.datastructure.other.impl.DequeMinMax;
import knowledge.datastructure.queue.impl.SlidingWindowMatrix;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 队列 (Queue) 精选题单(导航索引)
 * <解题识别>
 * 出现以下信号优先考虑队列:需要「先进先出」的层序 / 逐层扩散、滑动窗口区间最值、或环形缓冲。
 * 1. 层序推进:BFS / 多源扩散用队列逐层出队入队。
 * 2. 窗口最值:单调队列(双端队列)维护窗口内的最大 / 最小候选。
 * 3. 定长缓冲:循环队列用取模复用数组空间,避免搬移。
 * <模板实现>
 * @see MyQueue             队列基础模板(循环数组实现)
 * @see CircularQueue       循环队列(定长缓冲, 头尾指针取模)
 * @see CircularDeque       循环双端队列
 * @see MonotonicQueue      单调队列(滑动窗口区间最值,详见其内部题单)
 * @see DequeMinMax         单调队列容器(同时维护窗口最大 / 最小)
 * @see SlidingWindowMatrix 二维滑动窗口区间最值
 * <I. 单调队列 (滑动窗口最值)>
 * 策略:双端队列存下标,队首过期则弹出,新元素入队前弹掉队尾所有「被它压制」者,队首即窗口极值。
 * @see LeetCode239   滑动窗口最大值 (单调递减队列)
 * @see LeetCode1438  绝对差不超过限制的最长连续子数组 (同时维护最大 / 最小)
 * @see LeetCode862   和至少为 K 的最短子数组 (前缀和 + 单调队列)
 * @see LeetCode2762  不间断子数组
 * @see LeetCode1696  跳跃游戏 VI (单调队列优化 DP)
 * <II. 队列设计 (Design)>
 * 策略:头尾指针 + 取模实现定长循环缓冲,O(1) 入队出队。
 * @see LeetCode622   设计循环队列
 * @see LeetCode641   设计循环双端队列
 * @see LeetCode933   最近的请求次数 (队列滑动时间窗)
 * @see LeetCode362   敲击计数器
 * <III. BFS 层序应用>
 * 策略:队列逐层扩散,统计层数 / 最短步数;多源问题一次性入队所有源点。
 * @see LeetCode1091  二进制矩阵中的最短路径 (BFS)
 * @see LeetCode994   腐烂的橘子 (多源 BFS)
 * @see LeetCode542   01 矩阵 (多源 BFS 距离)
 */
public interface Queue {
}
