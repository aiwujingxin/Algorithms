package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 22:12
 */
public class LeetCode1654_math {

    //https://leetcode.cn/problems/minimum-jumps-to-reach-home/solutions/2418306/tan-xin-shen-du-you-xian-sou-suo-by-peac-mdu2/

    int a, b, x, max;
    boolean[] visited;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }
        this.a = a;
        this.b = b;
        this.x = x;
        max = 2000 + a + b;
        visited = new boolean[max + 1];
        for (int pos : forbidden) {
            visited[pos] = true;
        }
        return dfs(a, 0, true);
    }

    int dfs(int cur, int steps, boolean isForward) {
        if (cur < 0 || cur > max || visited[cur]) {
            return -1;
        }
        steps++;
        if (cur == x) {
            return steps;
        }
        if (isForward) {
            visited[cur] = true;
        }
        int forwardSteps = -1, backwardSteps = -1;
        int nextForwardPos = cur + a, nextBackwardPos = cur - b;
        if (nextBackwardPos >= x) {
            if (isForward) {
                backwardSteps = dfs(nextBackwardPos, steps, false);
            }
            if (backwardSteps == -1) {
                forwardSteps = dfs(nextForwardPos, steps, true);
            }
        } else {
            forwardSteps = dfs(nextForwardPos, steps, true);
            if (forwardSteps == -1 && isForward) {
                backwardSteps = dfs(nextBackwardPos, steps, false);
            }
        }
        return forwardSteps == -1 ? backwardSteps : forwardSteps;
    }
}
