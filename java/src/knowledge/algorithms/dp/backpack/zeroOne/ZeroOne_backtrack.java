package knowledge.algorithms.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/27 00:17
 * @description 标准的二叉子集树
 */
public class ZeroOne_backtrack implements ZeroOnePack {

    int ans;

    @Override
    public int backPack(int[] C, int[] W, int V) {
        ans = 0;
        backtrack(0, C, W, V, 0, 0);
        return ans;
    }

    public void backtrack(int i, int[] C, int[] W, int V, int cw, int cv) {
        if (cw > V) {
            return;
        }
        if (i == C.length) {
            if (cv > ans) {
                ans = cv;
            }
            return;
        }
        if (cw + C[i] <= V) { // 可行性约束函数
            backtrack(i + 1, C, W, V, cw + C[i], cv + W[i]);
        }
        backtrack(i + 1, C, W, V, cw, cv);
    }
}
