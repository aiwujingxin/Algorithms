package knowledge.algorithms.bit;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/26 17:07
 * @description 线性基模板：用于求数组子集的最大异或和、第 k 大异或和等。
 */
public class XorBasis {

    private final int[] b;

    /**
     * @param n 值域最大值 U 的二进制长度，例如 U=1e9 时 n=30
     */
    public XorBasis(int n) {
        this.b = new int[n];
    }

    // 插入一个数
    public void insert(int x) {
        // 从高到低遍历，保证参与 XOR 的基的最高位互不相同
        for (int i = b.length - 1; i >= 0; i--) {
            if (((x >> i) & 1) == 1) {
                if (b[i] == 0) { // x 和之前的基是线性无关的
                    b[i] = x;    // 新增一个基
                    return;
                }
                x ^= b[i];       // 保证每个基的二进制长度互不相同
            }
        }
        // 若正常循环结束，说明 x 可以被已有基表出，不是线性无关基
    }

    // 求最大异或和
    public int maxXor() {
        int res = 0;
        // 从高到低贪心：越高的位，越必须是 1
        for (int i = b.length - 1; i >= 0; i--) {
            if ((res ^ b[i]) > res) {
                res ^= b[i];
            }
        }
        return res;
    }
}
