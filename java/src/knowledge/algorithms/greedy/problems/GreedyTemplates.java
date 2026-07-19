package knowledge.algorithms.greedy.problems;

import knowledge.datastructure.graph.shortestpath.impl.Dijkstra;
import leetcode.problems.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 7/19/26 16:29
 * 贪心算法通用解题框架 (The 6 Pillars of Greedy Algorithms)
 */
public class GreedyTemplates {


    /**
     * =================================================================================
     * 模板 1：排序 + 线性扫描 (Sorting + Linear Scan)
     * =================================================================================
     * <适用场景>
     * 区间调度 (Interval Scheduling)、活动选择、静态资源分配、双指针贪心。
     * <核心思想>
     * 预处理消除无序性。通过排序将杂乱的数据变得有序，然后通过一次遍历，
     * 每次只处理局部最优，从而推导出全局最优。
     * <关键点>
     * 1. Comparator 的定义是解题的灵魂：
     * - 选择型(435/452/646): 按右端点升序 → 选最早结束
     * - 覆盖型(1024/1326): 按左端点升序 → 找当前可达最远
     * - 合并型(56/2580): 按左端点升序 → 扫描合并连通分量
     * 2. ⚠️ 比较器溢出: 用 Integer.compare(a,b) 而非 a-b
     * <p>
     * <代表题目>
     *
     * @see LeetCode435     无重叠区间
     * @see LeetCode452     用最少数量的箭引爆气球
     * @see LeetCode646     最长数对链
     * @see LeetCode2580    统计将重叠区间合并成组的方案数
     * @see LeetCode455     分发饼干
     * @see LeetCode870     优势洗牌
     */
    public int greedyLinearScan(int[][] items) {
        // 1. 预处理：排序
        // 按结束时间升序 (选择型); 按开始时间升序 (覆盖/合并型)
        // ⚠️ 永远用 Integer.compare，避免极端值溢出
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        // 2. 线性扫描
        for (int[] item : items) {
            int start = item[0];
            int end = item[1];

            // 3. 贪心选择判定
            // 435: start >= lastEnd (端点相等不算重叠)
            // 452: start > lastEnd  (端点相等算重叠，同一箭可射)
            // 646: start > lastEnd  (严格大于才可链接)
            if (start >= lastEnd) {
                // 4. 采纳决策
                count++;
                // 5. 更新状态
                // 选择型: lastEnd = end (只更新选中的)
                // 合并型: lastEnd = Math.max(lastEnd, end) (始终更新)
                lastEnd = end;
            }
        }
        return count;
    }

    /**
     * =================================================================================
     * 模板 2：堆维护 / 反悔贪心 (Heap / Regret Greedy)
     * =================================================================================
     * <适用场景>
     * 动态数据流、带截止时间的调度、移除 K 个元素求极值、允许"反悔"的场景。
     * <核心思想>
     * 维护一个"当前最优集合"。当新元素破坏约束（如超时、超重）时，
     * 利用堆找出集合里"最差"的那个元素（代价最大/收益最小）并牺牲掉，以保全大局。
     * <关键点>
     * 时光倒流。允许先犯错，再通过堆来修正历史决策。
     * <p>
     * <反悔贪心 vs 普通堆贪心>
     * - 普通堆贪心: 每次从堆中取最优，不可撤回 (Dijkstra, Prim)
     * - 反悔贪心: 先贪心选择，发现不行再从堆中淘汰最差的 (630, 871, 2813)
     * <p>
     * <代表题目>
     *
     * @see LeetCode630     课程表 III (按截止排序，堆顶=最长课程，超时则替换)
     * @see LeetCode871     最低加油次数 (路过加油站存入堆，没油时从堆取最大)
     * @see LeetCode2813    子序列最大优雅度 (选 k 个，堆维护重复类别中最小利润)
     * @see LeetCode1353    最多可以参加的会议数目
     * @see LeetCode1705    吃苹果的最大数目
     */
    public int greedyWithHeap(int[][] tasks, int limit) {
        // 1. 预处理：按截止时间/开始时间排序
        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. 堆的选择：
        // 求最大收益 → 小顶堆 (方便扔掉收益最小的)
        // 求最小代价 → 大顶堆 (方便扔掉代价最大的)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 大顶堆

        long currentTotalCost = 0;

        for (int[] task : tasks) {
            int cost = task[1];

            // 3. 先无脑贪心：尝试接纳当前任务
            currentTotalCost += cost;
            pq.offer(cost);

            // 4. 约束检查与反悔 (Regret)
            while (currentTotalCost > limit && !pq.isEmpty()) {
                // 5. 贪心反悔：扔掉堆顶那个"最差"的累赘
                currentTotalCost -= pq.poll();
            }
        }
        return pq.size();
    }

    /**
     * =================================================================================
     * 模板 3：瓶颈优先 / 广义 Dijkstra (Bottleneck / Best-First)
     * =================================================================================
     * <适用场景>
     * 接雨水 II、最小体力消耗路径、水位上升游泳、带权重的网格搜索。
     * <核心思想>
     * 短板决定论。系统受限于当前的"短板"（最小值/瓶颈）。
     * 优先处理短板，一旦解决或利用了短板，系统边界才会向更有利方向演化。
     * <关键点>
     * 1. 最小堆始终输出当前的"全局最小值"，保证了传播过程的单调性。
     * 2. 与标准 Dijkstra 的区别：
     * - 标准 Dijkstra: dist[v] = dist[u] + w(u,v) (累加)
     * - 瓶颈路径: dist[v] = max(dist[u], w(u,v)) (取 max)
     * - 接雨水 II: 水位由围墙最低点决定 (取 max)
     * <p>
     * <代表题目>
     * @see Dijkstra
     * @see LeetCode407     接雨水 II (木桶效应: 最低围墙决定水位)
     * @see LeetCode778     水位上升的泳池中游泳 (路径瓶颈最小化)
     * @see LeetCode1631    最小体力消耗路径 (边权=高度差, 最小化路径最大边)
     * @see LeetCode502     IPO (资本门槛型: 解锁后选最大利润)
     */
    public int greedyBottleneck(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[m][n];

        // 初始化：将起始边界入堆 (如最外圈、起点)
        // (伪代码：将边界加入 pq 并标记 visited)

        int currentMax = 0;
        int result = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0], r = curr[1], c = curr[2];

            // 更新瓶颈：木桶效应
            currentMax = Math.max(currentMax, val);

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    // 核心处理 (接雨水: 矮于水位则接水)
                    if (grid[nr][nc] < currentMax) {
                        result += (currentMax - grid[nr][nc]);
                    }

                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return result;
    }

    /**
     * =================================================================================
     * 模板 4：单调栈贪心 (Monotonic Stack)
     * =================================================================================
     * <适用场景>
     * 移掉 K 位数字、拼接最大数、去除重复字母、保留相对顺序的字典序问题。
     * <核心思想>
     * 维护一个"完美序列"。当新元素入栈时，如果它比栈顶元素"更优"（例如更小），
     * 且我们还有"作弊额度"（k > 0，允许删除），就踢走栈顶元素，让新元素上位。
     * <关键点>
     * 1. 栈内元素始终保持单调性（递增或递减）。
     * 2. "额度"的约束保证不会过度删除。
     * 3. 扫尾处理：额度没用完时，删尾部（已单调，尾部最大）。
     * <p>
     * <代表题目>
     *
     * @see LeetCode402     移掉 K 位数字 (求最小数)
     * @see LeetCode316     去除重复字母 (每种字符恰好一次，字典序最小)
     * @see LeetCode321     拼接最大数 (两个数组中选 k 个拼最大)
     * @see LeetCode1673    找到最具竞争力的子序列
     */
    public String greedyMonotonicStack(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 贪心循环：优胜劣汰
            // 条件: 栈顶劣于当前 && 还有删除额度 && 后面还有足够字符
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }

        // 扫尾：额度没用完，栈内已单调递增，删尾部
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }

    /**
     * =================================================================================
     * 模板 5：区间覆盖 / 跳跃延伸 (Coverage Extension / Implicit BFS)
     * =================================================================================
     * <适用场景>
     * 跳跃游戏、视频拼接、灌溉花园、区间覆盖最小数量。
     * <核心思想>
     * 在当前能力的极限范围内，寻找下一步能帮我跳得更远的跳板。
     * 不断更新"当前能到达的最远边界"。
     * <关键点>
     * 1. 隐式 BFS：每一次跳跃代表了一层 BFS 的扩展。
     * 2. 三个变量: end(当前层边界), maxPosition(下一层边界), steps(层数)
     * 3. ⚠️ 遍历到 n-2 而非 n-1（否则当 end==n-1 时多算一跳）
     * 4. 45/1024/1326 同构: 差异仅在输入预处理（点→线段→水龙头）
     * <p>
     * <代表题目>
     *
     * @see LeetCode55      跳跃游戏 (简化版: 只判断 reach >= n-1)
     * @see LeetCode45      跳跃游戏 II (标准模板)
     * @see LeetCode1024    视频拼接 (clips → maxReach[] 预处理后同 45)
     * @see LeetCode1326    灌溉花园的最少水龙头数目 (同 1024)
     * @see LeetCode134     加油站 (变体: 环形 + 起点选择)
     */
    public int greedyJump(int[] nums) {
        int end = 0;         // 当前层右边界 (Current Layer End)
        int maxPosition = 0; // 下一层能到达的最远位置 (Next Layer End)
        int steps = 0;

        // ⚠️ 遍历到 n-2：到了 n-1 就不需要再跳了
        for (int i = 0; i < nums.length - 1; i++) {
            // 1. 探测：在这个位置，最远能到哪里？
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 2. 到达当前层边界：必须跳了
            if (i == end) {
                end = maxPosition;
                steps++;
                // 剪枝：已覆盖终点
                if (end >= nums.length - 1) break;
            }
        }
        return steps;
    }

    /**
     * =================================================================================
     * 模板 6：补丁型贪心 / 子集和覆盖 (Patching / Subset-Sum Coverage)
     * =================================================================================
     * <适用场景>
     * 构造连续值、按要求补齐数组、添加硬币使覆盖 [1, target]。
     * <核心思想>
     * 维护 reach = 当前可构造的连续值上界 [0, reach)。
     * 遍历排序后的数组，若 nums[i] <= reach 则吸收（reach += nums[i]），
     * 否则"缺啥补啥"——补 reach 本身，实现覆盖范围翻倍。
     * <关键点>
     * 1. 补 reach 本身的最优性: 约束 v <= reach（否则产生断层），
     * 在约束内取最大 v = reach，新覆盖 [0, 2*reach)，增长率最大。
     * 2. ⚠️ reach 必须用 long: n 最大 2^31-1，翻倍后超出 int。
     * 3. 补丁次数上界: O(log target)，因为每次翻倍。
     * 4. 330 vs 1798 的"同卵双胞胎": 遇断档 stop(1798) vs patch(330)。
     * <p>
     * <代表题目>
     *
     * @see LeetCode330     按要求补齐数组 (补丁版: 遇断补 reach 翻倍)
     * @see LeetCode1798    构造连续值的最大数目 (只读版: 断档即停)
     * @see LeetCode2952    需要添加的硬币的最小数目 (330 同族: 先排序)
     */
    public int greedyPatching(int[] nums, int target) {
        Arrays.sort(nums);
        // ⚠️ 必须用 long！当 target 接近 Integer.MAX_VALUE 时，
        // reach 翻倍会超出 int 范围，导致溢出变负 → while 死循环
        long reach = 0; // 当前能覆盖 [1, reach]
        int patches = 0;
        int i = 0;

        while (reach < target) {
            if (i < nums.length && nums[i] <= reach + 1) {
                // 吸收: 现有元素在可达范围内，直接扩展
                // [1, reach] ∪ [nums[i], reach+nums[i]] = [1, reach+nums[i]]
                reach += nums[i];
                i++;
            } else {
                // 补丁: 当前 reach+1 无法覆盖，必须添加
                // 补什么最优？补 reach+1！
                // 新覆盖: [1, reach] ∪ [reach+1, 2*reach+1] = [1, 2*reach+1]
                reach += reach + 1; // 等价于 reach = 2*reach + 1
                patches++;
            }
        }
        return patches;

        // 变体 1798 (只读版): 遇到断档直接 break，返回 reach
        // long reach = 1;
        // for (int c : coins) {
        //     if (c > reach) break;  // 断档即停
        //     reach += c;
        // }
        // return (int) reach;
    }
}
