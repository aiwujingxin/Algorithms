package knowledge.algorithms.dp.backpack.test;

import knowledge.algorithms.dp.backpack.multiple.MultiplePack;
import knowledge.algorithms.dp.backpack.multiple.problems.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 23:53
 */
public class MultiplePackTest {

    public static void main(String[] args) {
        testMultiplePack();
    }

    public static void testMultiplePack() {
        UniversalTester<MultiplePack> tester = new UniversalTester<>(
                MultiplePack.class,
                "backPack",
                inputs -> {
                    int[] C = (int[]) inputs[0];
                    int[] W = (int[]) inputs[1];
                    int[] K = (int[]) inputs[2];
                    int V = (int) inputs[3];
                    return String.format("体积%s, 价值%s, 数量%s, 容量%d", Arrays.toString(C), Arrays.toString(W), Arrays.toString(K), V);
                }
        );

        // 自动注册所有实现
        SolverAutoRegister.autoRegister(tester, MultiplePack.class);

        // 对拍测试
        randomMultiplePackTest(tester, 100);
    }

    public static void randomMultiplePackTest(UniversalTester<MultiplePack> tester, int testCases) {
        Random random = new Random();
        int passed = 0;

        for (int i = 1; i <= testCases; i++) {
            System.out.println("=== 第 " + i + " 个测试用例 ===");

            // 随机生成测试数据
            int n = random.nextInt(5) + 10;   // 物品数量 3-7
            int V = random.nextInt(30) + 20; // 背包容量 10-39

            int[] C = new int[n];
            int[] W = new int[n];
            int[] K = new int[n];

            for (int j = 0; j < n; j++) {
                C[j] = random.nextInt(8) + 1;   // 物品体积 1-8
                W[j] = random.nextInt(10) + 1;  // 物品价值 1-10
                K[j] = random.nextInt(5) + 1;   // 物品数量 1-5
            }

            // 使用回溯解法作为基准（小规模数据）
            int expected = new Multiple_bk().backPack(C, W, K, V);

            // 测试所有解法
            Object[] inputs = {C, W, K, V};
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

    // 自动注册器
    static class SolverAutoRegister {
        @SuppressWarnings("unchecked")
        public static <T> void autoRegister(UniversalTester<T> tester, Class<T> interfaceClass) {
            System.out.println("正在自动注册 " + interfaceClass.getSimpleName() + " 的实现...");

            Class<?>[] knownClasses = {
                    Multiple_dp_1d.class,
                    Multiple_dp_2d.class,
                    Multiple_dq.class,
                    Multiple_bk.class,
                    Multiple_bit.class
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
