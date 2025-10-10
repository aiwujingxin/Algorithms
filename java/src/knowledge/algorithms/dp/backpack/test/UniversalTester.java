package knowledge.algorithms.dp.backpack.test;


import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 16:03
 */
class UniversalTester<T> {
    private final List<T> solvers = new ArrayList<>();
    private final Method method;
    private final String methodName;
    private final Function<Object[], String> inputFormatter;

    public UniversalTester(Class<T> interfaceClass, String methodName, Function<Object[], String> inputFormatter) {
        this.method = findMethod(interfaceClass, methodName);
        this.methodName = methodName;
        this.inputFormatter = inputFormatter;
    }

    public UniversalTester(Class<T> interfaceClass, String methodName) {
        this(interfaceClass, methodName, null);
    }

    private Method findMethod(Class<T> interfaceClass, String methodName) {
        try {
            // 查找接口中的方法
            for (Method m : interfaceClass.getDeclaredMethods()) {
                if (m.getName().equals(methodName)) {
                    return m;
                }
            }
            throw new RuntimeException("在接口 " + interfaceClass.getSimpleName() + " 中找不到方法: " + methodName);
        } catch (Exception e) {
            throw new RuntimeException("初始化测试器失败", e);
        }
    }

    public void addSolver(T solver) {
        solvers.add(solver);
    }

    public boolean testAll(Object[] inputs, Object expected) {
        System.out.println("=== 测试开始 ===");
        System.out.printf("方法: %s\n", methodName);

        // 格式化输入参数
        if (inputFormatter != null) {
            System.out.println("输入: " + inputFormatter.apply(inputs));
        } else {
            System.out.println("输入: " + Arrays.toString(inputs));
        }
        System.out.println("期望: " + expected);

        Map<String, Object> results = new LinkedHashMap<>();
        Map<String, Long> times = new LinkedHashMap<>();
        boolean allMatch = true;

        for (T solver : solvers) {
            try {
                long start = System.nanoTime();
                Object result = method.invoke(solver, inputs);
                long end = System.nanoTime();

                String solverName = solver.getClass().getSimpleName();
                results.put(solverName, result);
                times.put(solverName, end - start);

                if (!Objects.equals(result, expected)) {
                    allMatch = false;
                }
            } catch (Exception e) {
                System.out.println("❌ 算法执行错误: " + solver.getClass().getSimpleName() + " - " + e.getCause());
                allMatch = false;
            }
        }

        System.out.println("结果对比:");
        results.forEach((name, result) -> {
            String status = Objects.equals(result, expected) ? "✓" : "✗";
            System.out.printf("  %-25s: %s %s (%.3fms)\n",
                    name, result, status, times.get(name) / 1e6);
        });

        System.out.println("所有算法结果一致: " + (allMatch ? "是" : "否"));

        if (!allMatch) {
            System.out.println("❌ 发现不一致的用例！");
            printDebugInfo(inputs, expected, results);
        }

        System.out.println("=== 测试结束 ===\n");
        return allMatch;
    }

    private void printDebugInfo(Object[] inputs, Object expected, Map<String, Object> results) {
        System.out.println("调试信息:");
        System.out.println("  输入参数: " + Arrays.toString(inputs));
        System.out.println("  期望结果: " + expected);
        System.out.println("  各算法结果: " + results);
    }

    public int getSolverCount() {
        return solvers.size();
    }
}