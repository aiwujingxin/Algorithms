package knowledge.algorithms.dp.compressdp.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 14:23
 * @description 蒙德里安的梦想
 * <a href="https://www.bilibili.com/video/BV1cv411b7EG/?spm_id_from=333.337.search-card.all.click&vd_source=8493a3e08130914836f4b3e1a5219439">...</a>
 */
public class Acwing291 {

    public static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line);
                int n = Integer.parseInt(str.nextToken());
                int m = Integer.parseInt(str.nextToken());

                if (n == 0 && m == 0) {
                    break;
                }
                // 在这个算法中，n 是状态压缩的维度，m 是迭代的次数。
                // 为了性能，最好让 n 是较小的那个数。
                if (n > m) {
                    int temp = n;
                    n = m;
                    m = temp;
                }
                // 预处理 状态数组 st[mask] 判断状态 i 是否合法
                // st[i] 为 true 表示状态 i 中，不出现连续的奇数个0
                boolean[] st = new boolean[1 << n];
                for (int i = 0; i < (1 << n); i++) {
                    int cnt = 0; // 记录连续 0 的个数
                    st[i] = true;
                    for (int j = 0; j < n; j++) {
                        if (((i >> j) & 1) == 1) { // 如果当前位是 1
                            if ((cnt & 1) == 1) {  // 检查之前的连续0的个数是否是奇数
                                st[i] = false;
                                break;
                            }
                        } else {
                            cnt++;
                        }
                    }
                    // 循环结束后，还要检查最后一段连续的0
                    if ((cnt & 1) == 1) {
                        st[i] = false;
                    }
                }

                // 2. 状态计算
                // f[i][j]: 铺满前 i 列，且第 i 列状态为 j 的方案数
                long[][] f = new long[m + 1][1 << n];

                // 第 0 列不横放是一种合法答案
                f[0][0] = 1;

                for (int i = 1; i <= m; i++) {               // 阶段：枚举列
                    for (int j = 0; j < (1 << n); j++) {     // 状态：枚举第 i 列的状态 j
                        for (int k = 0; k < (1 << n); k++) { // 决策：枚举第 i-1 列的状态 k
                            // 检查兼容性：
                            // 1. (j & k) == 0: 不出现重叠的 1
                            // 2. st[j | k]: 不出现连续的奇数个0
                            if ((j & k) == 0 && st[j | k]) {
                                f[i][j] += f[i - 1][k];
                            }
                        }
                    }
                }
                // 3. 输出结果 f[m][0] 表示铺满了 m 列不横放
                System.out.println(f[m][0]);
            }
        }
    }
}
