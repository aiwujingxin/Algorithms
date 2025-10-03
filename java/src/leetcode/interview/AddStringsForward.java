package leetcode.interview;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 01:50
 */
public class AddStringsForward {

    /**
     * 【最终正确修复版 v3】从左到右计算等长字符串的和。
     * 这个版本修复了因前导零导致结果不一致的问题。
     *
     * @param a 第一个数字字符串
     * @param b 第二个数字字符串
     * @return 两数之和的字符串
     */
    public static String addEqualLength(String a, String b) {
        int n = a.length();
        if (n == 0) {
            return "";
        }
        // 特殊情况：如果两个输入都是"0"，直接返回"0"
        if (n == 1 && a.equals("0") && b.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder(n + 1);
        int pendingNines = 0;
        for (int i = 0; i < n; i++) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';
            int sum = digitA + digitB;
            if (sum < 9) {
                for (int k = 0; k < pendingNines; k++) {
                    result.append('9');
                }
                pendingNines = 0;
                result.append(sum);
            } else if (sum > 9) {
                int len = result.length();
                while (len > 0 && result.charAt(len - 1) == '9') {
                    result.setCharAt(len - 1, '0');
                    len--;
                }
                if (len == 0) {
                    result.insert(0, '1');
                } else {
                    result.setCharAt(len - 1, (char) (result.charAt(len - 1) + 1));
                }
                for (int k = 0; k < pendingNines; k++) {
                    result.append('0');
                }
                pendingNines = 0;
                result.append(sum % 10);
            } else { // sum == 9
                pendingNines++;
            }
        }
        for (int k = 0; k < pendingNines; k++) {
            result.append('9');
        }
        String finalResult = result.toString();
        // 【关键修复】: 处理前导零
        // 找到第一个非'0'字符的索引
        int firstNonZero = 0;
        while (firstNonZero < finalResult.length() - 1 && finalResult.charAt(firstNonZero) == '0') {
            firstNonZero++;
        }
        return finalResult.substring(firstNonZero);
    }


    // ====================================================================
    // 2. 暴力解 / 正确答案生成器 (The Oracle)
    // 使用 Java 自带的 BigInteger，它的结果是绝对可靠的。
    // ====================================================================
    public static String oracleSolution(String a, String b) {
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        return numA.add(numB).toString();
    }

    // ====================================================================
    // 3. 数据生成器 (Data Generator)
    // 生成指定长度的随机数字字符串
    // ====================================================================
    public static String generateRandomNumberString(int length, Random rand) {
        if (length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10)); // 生成 0-9 的随机数字
        }
        return sb.toString();
    }

    // ====================================================================
    // 4. 比对器 (The Main Test Loop)
    // ====================================================================
    public static void main(String[] args) {
        int testRounds = 10000; // 测试轮数，可以增加以提高测试强度
        int maxLength = 50;     // 生成随机字符串的最大长度
        Random rand = new Random();
        boolean success = true;
        System.out.println("开始对拍测试，共 " + testRounds + " 轮...");
        for (int i = 1; i <= testRounds; i++) {
            // 生成一组随机测试数据
            int len = rand.nextInt(maxLength) + 1; // 长度至少为1，避免空字符串
            String a = generateRandomNumberString(len, rand);
            String b = generateRandomNumberString(len, rand);
            // 分别用两个方法计算结果
            String myResult = addEqualLength(a, b);
            String oracleResult = oracleSolution(a, b);
            // 比对结果
            if (!myResult.equals(oracleResult)) {
                System.out.println("\n!!!!!! 测试失败 !!!!!!");
                System.out.println("失败的测试用例 (第 " + i + " 轮):");
                System.out.println("  a = " + a);
                System.out.println("  b = " + b);
                System.out.println("  你的结果 (Actual):   " + myResult);
                System.out.println("  正确的结果 (Expected): " + oracleResult);
                success = false;
                break; // 发现错误后立即停止
            }
            // 打印进度
            if (i % 1000 == 0) {
                System.out.println("已完成 " + i + " / " + testRounds + " 轮测试，暂未发现错误...");
            }
        }
        if (success) {
            System.out.println("\n恭喜！通过了全部 " + testRounds + " 轮随机测试！正确率 100%！");
        }
    }
}
