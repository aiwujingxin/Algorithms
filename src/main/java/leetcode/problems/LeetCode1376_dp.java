package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/27 18:55
 */
public class LeetCode1376_dp {

    int[] dp, manager, informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 记录最长时间
        int time = 0;
        this.manager = manager;
        this.informTime = informTime;
        // dp数组记忆化每一个员工获取到信息所需时间
        dp = new int[n];
        // 遍历进行消息获取
        for (int i = 0; i < n; i++) {
            time = Math.max(time, dfs(i));
        }
        return time;
    }

    // 以当前员工为起点往上遍历获取时间
    private int dfs(int i) {
        // 信息是总负责人发出的，所以每一个员工往上遍历一定会遍历到总负责人，返回总负责人的时间
        if (manager[i] == -1) {
            return informTime[i];
        }

        // 如果当前的 i 编号的员工的时间以及算出就返回
        if (dp[i] > 0) {
            return dp[i];
        }

        int res = informTime[i] + dfs(manager[i]);
        // 记录当前员工从总负责人发出后获取所需到信息所需时间
        dp[i] = res;
        return res;
    }
}
