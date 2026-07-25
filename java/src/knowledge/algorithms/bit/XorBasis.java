package knowledge.algorithms.bit;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/26 17:07
 * @description 线性基 (Linear Basis over GF(2))
 * <适用场景>
 * 求一组数的任意子集异或和的最大值、最小值、第 k 小值，或判断某数能否被异或表出。
 * <核心>
 * 维护每个二进制位互不相同的一组基 b[i]（最高位为 i）；插入时高位向低位消元。
 * 化为"简化行阶梯"（每个基仅在自己最高位为 1）后，非零基按位组合即可枚举全部异或值。
 */
public class XorBasis {

    private final int[] b;
    private int cnt; // 基的个数

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
                    cnt++;
                    return;
                }
                x ^= b[i];       // 保证每个基的二进制长度互不相同
            }
        }
        // 若正常循环结束，说明 x 可以被已有基表出，不是线性无关基
    }

    // 判断 x 能否被基异或表出
    public boolean canRepresent(int x) {
        for (int i = b.length - 1; i >= 0; i--) {
            if (((x >> i) & 1) == 1) {
                if (b[i] == 0) return false;
                x ^= b[i];
            }
        }
        return x == 0;
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

    // 求非空子集的最小异或和（若基不满秩，空集异或 0 也可取到，视题意而定）
    public int minXor() {
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) return b[i];
        }
        return 0;
    }

    /**
     * 第 k 小的异或值（k 从 1 计，包含空集异或 0）。
     * 先把线性基化简为每个基仅在自身最高位为 1 的规范形，再将 k 的二进制映射到基的选取。
     */
    public long kthMin(long k) {
        // 化简为规范形
        int[] basis = new int[cnt];
        int m = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0) continue;
            int cur = b[i];
            for (int j = i - 1; j >= 0; j--) {
                if (((cur >> j) & 1) == 1 && b[j] != 0) cur ^= b[j];
            }
            basis[m++] = cur;
        }
        // basis[0..m-1] 从低位基到高位基，(k-1) 的第 t 位决定是否选第 t 个基
        if (k > (1L << m)) return -1; // 超出可表示的不同异或值个数
        long rank = k - 1;
        long res = 0;
        for (int i = 0; i < m; i++) {
            if (((rank >> i) & 1) == 1) res ^= basis[i];
        }
        return res;
    }

    public static void main(String[] args) {
        XorBasis xb = new XorBasis(4); // 值域 <16
        for (int x : new int[]{1, 2, 3, 4}) xb.insert(x);
        System.out.println("maxXor expect 7: " + xb.maxXor());
        System.out.println("canRepresent(6) expect true: " + xb.canRepresent(6));
        System.out.println("canRepresent(8) expect false: " + xb.canRepresent(8));
        // {1,2,4} 是一组基，异或可表出 0..7 全部 8 个值，第 1 小=0，第 8 小=7
        System.out.println("kthMin(1) expect 0: " + xb.kthMin(1));
        System.out.println("kthMin(8) expect 7: " + xb.kthMin(8));
    }
}
