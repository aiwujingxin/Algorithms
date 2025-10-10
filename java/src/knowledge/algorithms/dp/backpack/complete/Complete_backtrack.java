package knowledge.algorithms.dp.backpack.complete;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 15:27
 */
public class Complete_backtrack implements CompletePack {

    int ans;

    public int backPack(int[] C, int[] W, int V) {
        ans = 0;
        backtrack(0, C, W, V, 0, 0);
        return ans;
    }

    public void backtrack(int index, int[] C, int[] W, int V, int CW, int CV) {
        if (CW > V) {
            return;
        }
        if (index >= C.length) {
            ans = Math.max(ans, CV);
            return;
        }
        if (C[index] == 0) { // 安全处理 零重量且正价值会导致答案无上界
            backtrack(index + 1, C, W, V, CW, CV);
            return;
        }
        for (int i = 0; i <= (V - CW) / C[index]; i++) {
            backtrack(index + 1, C, W, V, CW + i * C[index], CV + i * W[index]);
        }
    }
}
