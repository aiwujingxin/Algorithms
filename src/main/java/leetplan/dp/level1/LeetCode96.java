package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:20
 */
public class LeetCode96 {

    //copy
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                //左树种类的个数 * 右树种类的个数
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
