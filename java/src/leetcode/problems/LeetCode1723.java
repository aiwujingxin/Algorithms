package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/13 22:30
 * @description 排列组合 ,回溯, 状态压缩DP
 */
public class LeetCode1723 {

    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        // 尽可能提前剪枝
        Arrays.sort(jobs);
        reverse(jobs);
        backtrack(jobs, 0, new int[k], 0);
        return res;
    }

    private void backtrack(int[] jobs, int jobIndex, int[] worker, int max) {
        if (jobIndex == jobs.length) {
            res = Math.min(max, res);
            return;
        }
        // 把当前的job分配给哪一个人
        for (int i = 0; i < worker.length; i++) {
            //剪枝：每次分配任务，如果前面有人是没有任务的，就停止搜索. 避免重复
            if (i > 0 && worker[i - 1] == 0) continue;
            if (Math.max(worker[i], max) >= res) continue;
            worker[i] += jobs[jobIndex];
            backtrack(jobs, jobIndex + 1, worker, Math.max(worker[i], max));
            worker[i] -= jobs[jobIndex];
        }
    }

    public void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    class Solution_bucket {
        int[] jobs;
        int n, k;
        int res = Integer.MAX_VALUE;

        public int minimumTimeRequired(int[] jobs, int k) {
            this.jobs = jobs;
            this.n = jobs.length;
            this.k = k;
            // 优化：降序排序，让大的任务先被分配，可以更快地抬高工作时间的下界，
            // 从而让剪枝条件（如 maxTime >= res）更早地被触发。
            Arrays.sort(jobs);
            reverse(jobs);
            // 从第0个工人开始分配，初始状态下所有值都为0。
            backtrack(0, 0, new int[k], 0, 0);
            return res;
        }

        /**
         * "为工人找任务"模型的回溯函数
         *
         * @param workerIndex  当前正在分配任务的工人 (0 to k-1)
         * @param jobIndex     为当前工人挑选任务时，从哪个工作索引开始考虑（用于构建子集）
         * @param workerTimes  长度为k的数组，记录每个工人的总工时
         * @param usedJobsMask 位掩码，记录哪些工作已经被分配
         * @param maxTime      到目前为止，workerTimes中的最大值
         */
        private void backtrack(int workerIndex, int jobIndex, int[] workerTimes, int usedJobsMask, int maxTime) {
            // ============================ 终止与剪枝 ============================
            // 剪枝1：限界剪枝 (宏观)
            // 如果当前方案的最大工时已经不优于已找到的全局最优解，则此路不通。
            if (maxTime >= res) {
                return;
            }
            // 终止条件：所有工人都已考虑完毕
            if (workerIndex == k) {
                // 只有当所有工作都分配完毕时，才是一个有效的完整方案
                if (usedJobsMask == (1 << n) - 1) {
                    // 更新全局最优解
                    res = maxTime; // 此时的 maxTime 就是这个方案的最大工时
                }
                return;
            }
            // ============================ 核心决策分支 ============================

            // 决策 A: "跳过"当前工人，让他空闲，直接去处理下一个工人。
            // 这个决策的本质是，当前工人被分配的子集已经确定（可能是空集，也可能是下面for循环构建的某个非空子集），
            // 我们现在基于这个确定的状态，去为下一个工人分配任务。
            // 剪枝2：空闲工人等效性剪枝
            // 如果前一个工人(workerIndex-1)是空闲的，我们就不允许当前工人也被“跳过”。
            // 这是为了强制所有空闲的工人排在队伍后面，避免因工人无差别而导致的重复计算。
            // 例如，避免 [jobA]->w0, []->w1, [jobB]->w2 和 [jobA]->w0, [jobB]->w1, []->w2 这种等效方案。
            if (workerIndex > 0 && workerTimes[workerIndex - 1] == 0) {
                // 什么也不做，即禁止了 backtrack(workerIndex + 1, ...) 这个调用。
                // 这条剪枝在你这个模型里实现起来比较tricky，但这是最接近你原意的写法。
                // 一个更强的剪枝是直接 return，但那意味着一旦有工人空闲，后面就不能再有空闲的了。
            } else {
                backtrack(workerIndex + 1, 0, workerTimes, usedJobsMask, maxTime);
            }
            // 决策 B: 为当前工人(workerIndex)分配一个或多个任务。
            // for循环负责从 jobIndex 开始，为当前工人构建非空子集。
            for (int i = jobIndex; i < n; i++) {
                // 如果工作i已经被分配，跳过
                if ((usedJobsMask & (1 << i)) != 0) {
                    continue;
                }
                // 剪枝3：相同任务等效性剪枝
                // 如果当前任务和前一个任务时长相同，且前一个任务在本轮决策中未被使用，
                // 那么选择当前任务会和选择前一个任务产生重复的搜索路径，故跳过。
                if (i > 0 && jobs[i] == jobs[i - 1] && (usedJobsMask & (1 << (i - 1))) == 0) {
                    continue;
                }
                // 剪枝4：限界剪枝 (微观/预判)
                // 如果给当前工人分配任务i会导致他自己的工时超过全局最优解，那么此分配无意义。
                if (workerTimes[workerIndex] + jobs[i] >= res) {
                    continue;
                }
                // --- 做出选择 ---
                workerTimes[workerIndex] += jobs[i]; // 分配任务i
                // --- 递归探索 ---
                // 继续为当前工人(workerIndex)从 i+1 开始寻找更多可分配的任务。
                // 这会构建出 {..., jobs[i], jobs[j]}, {..., jobs[i], jobs[k]} 等更大的子集。
                int newMaxTime = Math.max(maxTime, workerTimes[workerIndex]);
                backtrack(workerIndex, i + 1, workerTimes, (usedJobsMask | (1 << i)), newMaxTime);
                // --- 撤销选择 (回溯) ---
                workerTimes[workerIndex] -= jobs[i]; // 将任务i收回
            }
        }

        public void reverse(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
    }

    class Solution_DP { //以盒子的视角”（为工人找任务）

        public int minimumTimeRequired(int[] jobs, int k) {
            int n = jobs.length;
            // 预处理，计算所有子集的工作量总和  存的是 mask 对应子集的工作量总和
            int[] sum = new int[1 << n];
            for (int i = 1; i < (1 << n); i++) {
                // 找到 i 的最低位的 1，比如 i=6 (0110), x=2 (0010)
                int x = Integer.lowestOneBit(i);
                // 找到这个位对应的索引，比如 x=2 -> 索引 1
                int p = Integer.numberOfTrailingZeros(x);
                // sum[i] = sum[i去掉最低位的1] + jobs[最低位1对应的索引]
                // sum[0110] = sum[0100] + jobs[1]
                sum[i] = sum[i ^ x] + jobs[p];
            }

            // dp[i][j]: 给 i 个工人分配 j (mask) 的工作，最小的最大工作时间
            int[][] dp = new int[k][1 << n];
            for (int i = 0; i < k; i++) {
                Arrays.fill(dp[i], -1);
            }

            // 初始化：给 0 个工人（也就是第1个工人）分配任何子集 j，
            // 他的工作时间就是这个子集的时间总和
            for (int j = 0; j < (1 << n); j++) {
                dp[0][j] = sum[j];
            }

            // 动态规划 + 状态压缩
            // 从第 1 个工人开始（总共 2 个工人）
            for (int i = 1; i < k; i++) {
                // 遍历所有可能分配给这 i+1 个工人的工作集合 (mask)
                for (int j = 0; j < (1 << n); j++) {
                    dp[i][j] = dp[i - 1][j]; // 初始化：假设第 i 个工人啥也不干

                    // 关键：枚举 j 的子集 s，s 分配给第 i 个工人，j-s 分配给前 i-1 个工人
                    // for (int s = j; s > 0; s = (s - 1) & j) {
                    // 上面这种枚举子集的方式太慢了，会超时
                    // 我们可以换个思路
                    // 考虑给第 i 个工人分配一个子集 s，剩下的 j^s 分配给前 i-1 个工人
                    for (int s = 1; s <= j; s++) {
                        if ((j & s) == s) { // 确保 s 是 j 的子集
                            // dp[i][j] 的值，是 "前 i-1 个工人的最大时间" 和 "第 i 个工人的时间" 这两者中的较大值
                            // 我们要让这个较大值尽可能小
                            int val = Math.max(dp[i - 1][j ^ s], sum[s]);
                            if (dp[i][j] == -1 || dp[i][j] > val) {
                                dp[i][j] = val;
                            }
                        }
                    }
                }
            }
            // 最终结果是给 k-1 个工人（总共k个）分配所有工作((1<<n)-1)的最小最大值
            return dp[k - 1][(1 << n) - 1];
        }
    }

    class Solution_dp {
        public boolean makesquare(int[] matchsticks) {
            int n = matchsticks.length;
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) return false;
            int target = sum / 4;
            int total = 1 << n;
            int[] dp = new int[total]; // dp[mask] 表示当前已选火柴的状态下的边长余量
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int mask = 0; mask < total; mask++) {
                if (dp[mask] == -1) continue; // 无效状态
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) continue; // 火柴已使用
                    int nextMask = mask | (1 << i);
                    int remainder = dp[mask] + matchsticks[i];
                    if (remainder > target) continue; // 超出当前边长度
                    // 如果刚好完成一条边，余量归零；否则继续累加
                    dp[nextMask] = (remainder == target) ? 0 : remainder;
                    if (dp[nextMask] == 0 && nextMask == total - 1) {
                        return true; // 所有火柴用完且四条边都完成
                    }
                }
            }
            return dp[total - 1] == 0;
        }
    }
}
