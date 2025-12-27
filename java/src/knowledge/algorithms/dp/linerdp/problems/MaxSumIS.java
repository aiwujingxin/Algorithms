package knowledge.algorithms.dp.linerdp.problems;

import knowledge.datastructure.adv.BITree_Max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 12/27/25 23:43
 * @description 最大上升子序列和
 * <a href="https://www.acwing.com/problem/content/description/1018/"></a>
 */
public class MaxSumIS {

    public class Main {
        public static void main(String[] args) {
            // 使用 Scanner 读取输入
            Scanner sc = new Scanner(System.in);

            // 读取 N
            if (sc.hasNext()) {
                int n = sc.nextInt();

                // 读取序列
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }

                // dp[i] 表示以 a[i] 结尾的最大上升子序列和
                int[] dp = new int[n];

                // 记录全局最大值
                int res = 0;

                for (int i = 0; i < n; i++) {
                    // 初始化：每个元素本身至少是一个长度为1的子序列
                    dp[i] = a[i];

                    // 遍历 i 之前的所有元素 j
                    for (int j = 0; j < i; j++) {
                        // 如果满足上升条件 (a[j] < a[i])
                        if (a[j] < a[i]) {
                            // 状态转移：尝试把 a[i] 接在 a[j] 后面
                            dp[i] = Math.max(dp[i], dp[j] + a[i]);
                        }
                    }

                    // 每次计算完 dp[i]，更新全局最大值
                    res = Math.max(res, dp[i]);
                }

                // 输出结果
                System.out.println(res);
            }

            sc.close();
        }
    }


    public class Main_BITree {


        public static void main(String[] args) throws IOException {
            // 使用 BufferedReader 加快 I/O 速度
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (!st.hasMoreTokens()) return;
            int n = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            // 这里的 b 数组用于离散化
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = a[i];
            }

            // --- 1. 离散化 (Discretization) ---
            // 对 b 数组排序并去重
            Arrays.sort(b);
            int uniqueCount = 0;
            // 原地去重逻辑
            for (int i = 0; i < n; i++) {
                if (i == 0 || b[i] != b[i - 1]) {
                    b[uniqueCount++] = b[i];
                }
            }
            // 此时 b 数组的前 uniqueCount 个元素是排序且去重后的值

            // --- 2. 动态规划 + 树状数组 ---
            // 树状数组的大小为去重后的元素个数
            BITree_Max bit = new BITree_Max(uniqueCount);
            long ans = 0;

            for (int i = 0; i < n; i++) {
                int val = a[i];

                // 二分查找 val 在去重数组 b 中的排名 (下标 + 1)
                // 这一步是为了找到离散化后的值
                int rank = Arrays.binarySearch(b, 0, uniqueCount, val) + 1;

                // 查询：在树状数组中找比当前 rank 小的位置 (1 到 rank-1) 的最大和
                // 也就是找比当前数值小的数结尾的最大上升子序列和
                long maxPrevSum = bit.max(rank - 1);

                // 当前以 a[i] 结尾的最大和
                long currentSum = Math.max(0L, maxPrevSum) + val;

                // 更新：将这个新和更新到树状数组的 rank 位置
                bit.update(rank, currentSum);

                // 更新全局最大值
                ans = Math.max(ans, currentSum);
            }

            System.out.println(ans);
        }
    }
}
