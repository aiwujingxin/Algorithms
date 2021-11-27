package newker;

/**
 * @author jingxinwu
 * @date 2021-06-06 7:50 下午
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] products = new int[n + 1];
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max_val = 0;
        for (int i = 4; i <= n; i++) {
            max_val = 0;
            for (int j = 1; j <= i / 2; j++) {
                max_val = Math.max(max_val, products[j] * products[i - j]);
            }
            products[i] = max_val;
        }
        return products[n];

    }
}
