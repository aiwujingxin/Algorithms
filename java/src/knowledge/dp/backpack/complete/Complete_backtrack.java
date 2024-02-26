package knowledge.dp.backpack.complete;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 15:27
 */
public class Complete_backtrack implements CompletePack {

    int ans;

    public int backPack(int[] C, int[] W, int V) {
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

        // 选当前物品，可以选择0次～多次
        for (int i = 0; i <= (V - CW) / C[index]; i++) {
            backtrack(index + 1, C, W, V, CW + i * C[index], CV + i * W[index]);
        }
    }
}
