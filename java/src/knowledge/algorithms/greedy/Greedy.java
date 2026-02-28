package knowledge.algorithms.greedy;

import knowledge.algorithms.greedy.problems.MaxActivity;
import knowledge.algorithms.greedy.problems.MinCover;
import knowledge.datastructure.graph.mst.impl.Prim;
import knowledge.datastructure.graph.shortestpath.impl.Dijkstra;
import knowledge.datastructure.stack.MonotonicStack;
import leetcode.problems.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2025/12/21 22:55
 * @description 贪心算法精选题单
 * 1. 观察问题结构：分析是否存在「局部最优决策可推导全局最优」的性质。
 * 2. 设计贪心策略：确定每一步的选择规则（最小/最大、配对、反悔等）。
 * 3. 验证策略正确性：通过交换论证法或反证法，确保不破坏全局最优。
 * <价值优先型>
 * * <静态极值>
 * 策略：基于当前固定的状态（排序后的数组），每次直接选择最有利的元素（最大/最小/最匹配），不涉及动态更新集合。
 * 本质：利用单调性或排序不等式，通过一次遍历或双指针，将资源分配给最能产生价值的目标。
 * @see LeetCode455         分发饼干
 * @see LeetCode860         柠檬水找零 (优先找零大面额)
 * @see LeetCode605         种花问题 (防御式贪心)
 * @see LeetCode1402        做菜顺序
 * @see LeetCode870         优势洗牌 (田忌赛马)
 * @see LeetCode1899        合并若干三元组以形成目标三元组
 * * <动态极值>
 * 策略：在算法过程中维护一个动态集合（堆），随着操作进行，集合内容发生变化，每次操作依赖于当前集合的极值。
 * 本质：通过堆结构实时捕获系统演化过程中的“最值”，确保每一步操作都是在当前约束下的最优解。
 * @see LeetCode2182        构造限制重复的字符串
 * @see LeetCode1962        移除石子使总数最小
 * @see LeetCode767         重构字符串 (隔板法)
 * @see LeetCode2233        K次增加后的最大乘积
 * @see LeetCode2856        删除数对后的最小数组长度 (堆模拟/数学)
 * @see LeetCode1167        连接棒材的最低费用
 * * <Dijkstra / 瓶颈优先>
 * 策略：系统处于受限状态，利用堆时刻抓住当前最紧的那个约束（瓶颈/短板），优先处理它。
 * 本质：短板决定论。一旦解决或利用了当前的短板，系统边界就会向更有利的方向演化（水位上升、路径延伸、资本增加）。
 * @see Dijkstra
 * @see LeetCode407         接雨水 II
 * @see LeetCode502         IPO
 * @see LeetCode778         水位上升的泳池中游泳
 * @see LeetCode1631        最小体力消耗路径
 * @see LeetCode1102        得分最高的路径
 * @see LeetCode1514_Dij    概率最大的路径
 * * <Prim>
 * 策略：从一个节点开始，每次选择连接已选集合与未选集合的最小权值边进行扩展。
 * 本质：局部最优连接导致全局最小生成树，是Dijkstra在无向图连通性上的特例。
 * @see Prim                Prim
 * <区间问题>
 * * <活动选择 / 不重叠>
 * 策略：按结束时间排序，优先选择结束最早的区间，为后面留出更多空间。
 * 本质：最大化资源利用率，通过腾出时间槽来容纳更多活动。
 * @see MaxActivity         活动选择（最大）不重叠
 * @see LeetCode435         无重叠区间
 * @see LeetCode646         最长数对链
 * * <分组 / 会议室>
 * 策略：按开始时间排序，利用堆维护当前所有组的结束时间，尝试复用最早结束的那一组。
 * 本质：资源的复用与分配，通过紧凑排列减少资源（会议室/组）的闲置间隙。
 * @see LeetCode253         会议室 II
 * @see LeetCode2406        将区间分为最少组数 (差分/扫描线)
 * * <覆盖 / 合并>
 * 策略：按开始时间排序，尽可能延长当前区间的覆盖范围（右边界），直到断开。
 * 本质：连通性合并，通过贪心延伸右边界来减少所需的区间数量或合并碎片。
 * @see MinCover            区间覆盖（最少）覆盖
 * @see LeetCode452         用最少数量的箭引爆气球
 * @see LeetCode2580        统计将重叠区间合并成组的方案数
 * @see LeetCode1288        删除被覆盖区间
 * @see LeetCode1326        灌溉花园的最少水龙头数目 (跳跃游戏变种)
 * @see LeetCode757         设置交集大小至少为2
 * * <区间 + 堆> (带截止时间的调度)
 * 策略：按开始时间扫描，将所有可选任务放入堆中，优先处理截止时间最早的任务（EDF算法）。
 * 本质：在时间流逝的硬约束下，通过优先满足最紧迫的需求来最大化收益。
 * @see LeetCode1353        最多可以参加的会议数目 (按开始时间排序，堆维护结束时间)
 * @see LeetCode1705        吃苹果的最大数目
 * @see LeetCode2589        完成所有任务的最少时间
 * <贪心构造>
 * * <字典序>
 * 策略：从高位到低位，在满足约束的前提下，尽可能填入更小（或更大）的字符/数字。
 * 本质：高位权重大于低位权重之和，利用位权差异进行贪心决策。
 * @see LeetCode31          下一个排列
 * @see LeetCode670         最大交换
 * @see LeetCode2375        根据模式串构造最小数字
 * @see LeetCode3216        交换后字典序最小的字符串
 * * <回文串>
 * 策略：优先构造回文串的两侧（高位），将出现次数最多的字符放在外侧，奇数次字符放中间。
 * 本质：利用回文的对称性，将构造问题转化为一般的字典序贪心或频率统计问题。
 * @see LeetCode564         寻找最近的回文数
 * @see LeetCode2384        最大回文数字
 * @see LeetCode266         回文排列
 * * <双向扫描>
 * 策略：将复杂约束分解为左规则和右规则，分别进行两次线性扫描，最后取交集（max）。
 * 本质：解耦依赖关系，将双向约束转化为两个独立的单向约束问题。
 * @see LeetCode135         分发糖果 (既要又要)
 * @see LeetCode955         删列造序 II
 * * <单调栈> (保留字典序最小/最大)
 * 策略：维护一个单调序列，当新元素破坏单调性且仍有删除额度时，果断删除栈顶元素（反悔）。
 * 本质：通过局部删除逆序对，保证留下的序列在整体上具有最优的字典序结构。
 * @see MonotonicStack
 * * <括号与计数>
 * 策略：维护一个可能的平衡值区间 [min, max]，利用贪心缩放区间范围。
 * 本质：利用括号匹配的抵消性质，将匹配问题转化为数值区间的可行性判定。
 * @see LeetCode678         有效的括号字符串 (维护区间 [min, max])
 * @see LeetCode921         使括号有效的最少添加
 * <跳跃游戏> (覆盖模型)
 * 策略：维护当前能到达的最远距离 (max_reach)，在当前覆盖范围内寻找下一步能跳得更远的落脚点。
 * 本质：通过不断拓展“可达边界”，用最少的步数覆盖到终点。
 * @see LeetCode55          跳跃游戏
 * @see LeetCode45          跳跃游戏 II
 * @see LeetCode134         加油站
 * @see LeetCode1024        视频拼接
 * @see LeetCode1306        跳跃游戏 III
 * @see LeetCode1696        跳跃游戏 VI (单调队列)
 * <反悔贪心> (堆维护已选集合)
 * 策略：先无脑贪心选择，当遇到约束无法满足时，利用堆找出之前选择中“代价最大/收益最小”的元素进行替换（反悔）。
 * 本质：时光倒流。允许犯错，通过事后修正（撤销最差决策）来维持当前的最优状态。
 * @see LeetCode871         最低加油次数
 * @see LeetCode630         课程表 III
 * @see LeetCode2813        子序列最大优雅度
 * @see LeetCode3049        标记所有下标的最早秒数 II
 * <数学 其他>
 * 策略：基于数学不等式、排序性质或特定业务逻辑（如股票买卖规则）进行的直接计算。
 * 本质：利用数学上的单调性或极值定理，证明局部操作等价于全局最优。
 * @see LeetCode179         最大数 (排序不等式)
 * @see LeetCode1005        K 次取反后最大化的数组和
 * @see LeetCode121         买卖股票的最佳时机 (贪心记录最小值)
 * @see LeetCode122         买卖股票的最佳时机 II (收集正利润)
 * @see LeetCode968         监控二叉树 (树形贪心，自底向上)
 */
public interface Greedy {

    /**
     * 贪心算法通用解题框架 (The 5 Pillars of Greedy Algorithms)
     * 贪心算法的核心在于“策略”，但其代码结构通常遵循以下 5 种范式。
     * 遇到新题时，请尝试将问题映射到以下某种结构中。
     */
    class GreedyTemplates {

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
         * Comparator 的定义是解题的灵魂（按结束时间？按价值？按开始时间？）。
         */
        public int greedyLinearScan(int[][] items) {
            // 1. 预处理：排序
            // 例如：按结束时间升序排序 (区间不重叠问题常用策略)
            Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

            int count = 0;
            // 记录上一次决策的边界/状态
            // (初始化为最小值，确保第一个元素能被选中)
            int lastEnd = Integer.MIN_VALUE;

            // 2. 线性扫描
            for (int[] item : items) {
                int start = item[0];
                int end = item[1];

                // 3. 贪心选择判定
                // 如果当前项满足条件（例如：开始时间 >= 上一个结束时间，说明不冲突）
                if (start >= lastEnd) {
                    // 4. 采纳决策
                    count++;
                    // 5. 更新状态：将边界推进到当前项的结束时间
                    lastEnd = end;
                }
                // 否则：跳过（贪心舍弃），因为它的结束时间一定比 lastEnd 晚（排序保证），
                // 或者它与已选区间重叠，选它不如选 lastEnd 划算。
            }
            return count;
        }

        /**
         * =================================================================================
         * 模板 2：堆维护 / 反悔贪心 (Heap / Regret Greedy)
         * =================================================================================
         * <适用场景>
         * 动态数据流、带截止时间的调度、移除 K 个元素求极值、允许“反悔”的场景。
         * <核心思想>
         * 维护一个“当前最优集合”。当新元素破坏约束（如超时、超重）时，
         * 利用堆找出集合里“最差”的那个元素（代价最大/收益最小）并牺牲掉，以保全大局。
         * <关键点>
         * 时光倒流。允许先犯错，再通过堆来修正历史决策。
         */
        public int greedyWithHeap(int[][] tasks, int limit) {
            // 1. 预处理：通常按 截止时间 或 开始时间 排序
            // (例如：按截止时间升序，优先处理紧急任务)
            Arrays.sort(tasks, (a, b) -> a[0] - b[0]);

            // 2. 堆的选择：
            // 如果求最大收益 -> 小顶堆 (方便扔掉收益最小的)
            // 如果求最小代价 -> 大顶堆 (方便扔掉代价最大的)
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 大顶堆示例

            long currentTotalCost = 0;

            for (int[] task : tasks) {
                int cost = task[1];

                // 3. 先无脑贪心：尝试接纳当前任务
                currentTotalCost += cost;
                pq.offer(cost);

                // 4. 约束检查与反悔 (Regret)
                // 如果当前状态破坏了约束（例如：总耗时超过了截止时间 limit）
                while (currentTotalCost > limit /* 或 pq.size() > K */) {
                    // 5. 贪心反悔：扔掉堆顶那个“最差”的累赘
                    // 这一步是核心：用当前任务替换掉了历史中最差的任务，优化了结构
                    if (!pq.isEmpty()) {
                        currentTotalCost -= pq.poll();
                    } else {
                        break;
                    }
                }
            }
            // 此时 pq 中的元素就是当前最优解集
            return pq.size();
        }

        /**
         * =================================================================================
         * 模板 3：瓶颈优先 / 广义 Dijkstra (Bottleneck / Best-First)
         * =================================================================================
         * <适用场景>
         * 接雨水 II、最小体力消耗路径、水位上升游泳、带权重的网格搜索。
         * <核心思想>
         * 短板决定论。系统受限于当前的“短板”（最小值）。
         * 优先处理短板，一旦解决或利用了短板，系统边界才会向更有利方向演化。
         * <关键点>
         * 最小堆始终输出当前的“全局最小值”，保证了传播过程的单调性。
         */
        public int greedyBottleneck(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // 1. 最小堆：始终输出当前的“短板” (权重最小的点)
            // int[] 存储 {权重, r, c}
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            boolean[][] visited = new boolean[m][n];

            // 2. 初始化：将起始边界入堆 (如最外圈、起点)
            // (伪代码：将边界加入 pq 并标记 visited)
            // for (boundary node : grid) { pq.offer(...); visited[...]=true; }

            int currentMax = 0; // 记录路径上的最大瓶颈（例如：当前围墙的最高水位）
            int result = 0;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            // 3. 最佳优先搜索 (Best-First Search)
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int val = curr[0], r = curr[1], c = curr[2];

                // 4. 更新瓶颈：木桶效应
                // 这一步很关键：当前的有效高度由路径上的最大值决定
                currentMax = Math.max(currentMax, val);

                // 5. 拓展邻居
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;

                        // 6. 核心处理逻辑
                        // (例如：接雨水 -> 如果邻居比 currentMax 矮，就能接水)
                        if (grid[nr][nc] < currentMax) {
                            result += (currentMax - grid[nr][nc]);
                        }

                        // 7. 邻居入堆：带着它的属性加入前沿
                        // 注意：有些题目需要放入 Math.max(grid[nr][nc], currentMax)
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
         * 维护一个“完美序列”。当新元素入栈时，如果它比栈顶元素“更优”（例如更小），
         * 且我们还有“作弊额度”（k > 0，允许删除），就踢走栈顶元素，让新元素上位。
         * <关键点>
         * 栈内元素始终保持单调性（递增或递减）。
         */
        public String greedyMonotonicStack(String s, int k) {
            // 使用 Deque 作为栈
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                // 1. 贪心循环：优胜劣汰
                // stack.peekLast() > c : 表示栈顶元素比当前元素大（字典序差，想求最小数）
                // k > 0 : 表示还有删除额度
                while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                    stack.pollLast(); // 踢走劣质元素（反悔）
                    k--;              // 消耗额度
                }
                stack.addLast(c);
            }

            // 2. 扫尾：如果额度没用完
            // 因为栈内已经是单调递增的，尾部一定是最大的，直接删尾部
            while (k > 0) {
                stack.pollLast();
                k--;
            }

            // 3. 构建结果
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollFirst());
            }
            // (注意：某些题目可能需要处理前导零)
            return sb.toString();
        }

        /**
         * =================================================================================
         * 模板 5：区间覆盖 / 跳跃延伸 (Coverage Extension)
         * =================================================================================
         * <适用场景>
         * 跳跃游戏、视频拼接、灌溉花园、区间覆盖最小数量。
         * <核心思想>
         * 在当前能力的极限范围内，寻找下一步能帮我跳得更远的跳板。
         * 不断更新“当前能到达的最远边界”。
         * <关键点>
         * 隐式 BFS。每一次跳跃代表了一层 BFS 的扩展。
         */
        public int greedyJump(int[] nums) {
            int end = 0;        // 当前步数能覆盖到的右边界 (Current Reach)
            int maxPosition = 0;// 潜力：下一步能到达的最远位置 (Max Potential)
            int steps = 0;

            // 遍历范围通常是 [0, n-2]，因为到了 n-1 就不用再跳了
            for (int i = 0; i < nums.length - 1; i++) {
                // 1. 贪心探测：在这个位置，最远能探到哪里？
                maxPosition = Math.max(maxPosition, i + nums[i]);

                // 2. 边界判定：走到了当前步数的尽头
                if (i == end) {
                    // 必须进行下一次跳跃了
                    end = maxPosition; // 将边界更新为刚才探测到的最远位置
                    steps++;

                    // 剪枝：如果已经覆盖终点，提前结束
                    if (end >= nums.length - 1) break;
                }
            }
            return steps;
        }
    }
}
