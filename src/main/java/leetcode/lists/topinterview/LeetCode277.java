package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/5 13:19
 */
public class LeetCode277 {


    private int[][] graph;

    public int findCelebrity(int n) {
        int ans = 0;
        for (int k = 0; k < n; k++) {
            if (knows(ans, k)) {
                ans = k;
            }
        }

        for (int k = 0; k < n; k++) {
            if (k != ans) {
                if (!knows(k, ans)) {
                    return -1;
                }
                if (knows(ans, k)) {
                    return -1;
                }
            }
        }
        return ans;
    }


    //获取到 A 是否认识 B。
    private boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }
}
