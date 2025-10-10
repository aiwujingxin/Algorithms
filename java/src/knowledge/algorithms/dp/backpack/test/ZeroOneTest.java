package knowledge.algorithms.dp.backpack.test;

import knowledge.algorithms.dp.backpack.zeroOne.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 16:03
 */
public class ZeroOneTest {

    public static void main(String[] args) {
        // 测试背包问题
        testKnapsack();
    }

    public static void testKnapsack() {
        // 创建背包问题测试器
        UniversalTester<ZeroOnePack> tester = new UniversalTester<>(
                ZeroOnePack.class,
                "backPack",
                inputs -> {
                    int[] C = (int[]) inputs[0];
                    int[] W = (int[]) inputs[1];
                    int V = (int) inputs[2];
                    return String.format("体积%s, 价值%s, 容量%d", Arrays.toString(C), Arrays.toString(W), V);
                }
        );

        // 自动注册所有实现
        SolverAutoRegister.autoRegister(tester, ZeroOnePack.class);

        // 对拍测试
        System.out.println("开始背包问题对拍测试...");
        randomKnapsackTest(tester, 1000);
        System.out.println("对拍测试完成！");
    }

    public static void randomKnapsackTest(UniversalTester<ZeroOnePack> tester, int testCases) {
        Random random = new Random();
        int passed = 0;

        for (int i = 1; i <= testCases; i++) {
            System.out.println("第 " + i + " 个测试用例:");

            // 随机生成测试数据
            int n = random.nextInt(6) + 3;   // 物品数量 3-8
            int V = random.nextInt(20) + 10; // 背包容量 10-29

            int[] C = new int[n];
            int[] W = new int[n];

            for (int j = 0; j < n; j++) {
                C[j] = random.nextInt(8) + 1;   // 物品体积 1-8
                W[j] = random.nextInt(10) + 1;  // 物品价值 1-10
            }

            // 使用可靠的解法作为基准
            int expected = new ZeroOne_dp_2d().backPack(C, W, V);

            // 测试所有解法
            Object[] inputs = {C, W, V};
            boolean success = tester.testAll(inputs, expected);
            if (success) {
                passed++;
            }
        }

        System.out.println("=== 对拍结果汇总 ===");
        System.out.printf("测试用例总数: %d\n", testCases);
        System.out.printf("通过用例数: %d\n", passed);
        System.out.printf("通过率: %.2f%%\n", (passed * 100.0 / testCases));
    }

    // 使用反射自动注册
    static class SolverAutoRegister {
        @SuppressWarnings("unchecked")
        public static <T> void autoRegister(UniversalTester<T> tester, Class<T> interfaceClass) {
            System.out.println("正在自动注册 " + interfaceClass.getSimpleName() + " 的实现...");

            // 手动列出所有实现类
            Class<?>[] knownClasses = {
                    ZeroOne_dfs_memo.class,
                    ZeroOne_backtrack.class,
                    ZeroOne_branch_bound.class,
                    ZeroOne_dp_1d.class,
                    ZeroOne_dp_2d.class,
            };

            for (Class<?> clazz : knownClasses) {
                if (interfaceClass.isAssignableFrom(clazz) && !clazz.isInterface()) {
                    try {
                        T solver = (T) clazz.getDeclaredConstructor().newInstance();
                        tester.addSolver(solver);
                        System.out.println("✅ 注册: " + clazz.getSimpleName());
                    } catch (Exception e) {
                        System.out.println("❌ 注册失败: " + clazz.getSimpleName() + " - " + e.getMessage());
                    }
                }
            }

            System.out.println("注册完成，共找到 " + tester.getSolverCount() + " 个实现\n");
        }
    }
}
