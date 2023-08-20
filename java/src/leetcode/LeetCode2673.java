package leetcode;

public class LeetCode2673 {

    int ans = 0;
    int[] cost;

    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        dfs(1);
        return ans;
    }

    public int dfs(int index) {
        if (index * 2 > cost.length) {
            return cost[index - 1];
        }
        int left = dfs(index * 2);
        int right = dfs(index * 2 + 1);
        ans += Math.abs(left - right);
        return Math.max(left, right) + cost[index - 1];
    }
}