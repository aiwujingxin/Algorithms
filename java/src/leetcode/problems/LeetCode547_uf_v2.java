package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:36
 */
public class LeetCode547_uf_v2 {

    //https://leetcode.com/problems/number-of-provinces/discuss/2386746/Java-Union-Find-Solution

    int[] par;

    private int findPar(int u) {
        if (par[u] == u) {
            return u;
        }
        return par[u] = findPar(par[u]);
    }

    public int findCircleNum(int[][] arr) {

        //init
        int n = arr.length;
        par = new int[n];
        for (int i = 0; i < arr.length; i++) {
            par[i] = i;
        }

        int cnt = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    int p1 = findPar(i), p2 = findPar(j);
                    if (p1 != p2) {
                        par[p1] = par[p2]; //连接
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }
}
