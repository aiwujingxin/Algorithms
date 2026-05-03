package knowledge.datastructure.string.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 01:50
 * @description 从左到右计算等长字符串的和
 */
public class AddStringsForward {

    public static String calculate(String a, String b) {
        int[] res = new int[a.length() + 1];
        int index = 0; // 记录最近一个和不为9的索引
        for (int i = 0; i < a.length(); i++) {
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0');
            res[i + 1] = sum % 10;
            if (sum != 9) {
                if (sum > 9) {
                    res[index]++; // 最左侧进位
                    Arrays.fill(res, index + 1, i + 1, 0); // 填充数字9->0
                }
                index = i + 1;
            }
        }
        int start = 0;
        while (start < res.length - 1 && res[start] == 0) start++;
        StringBuilder sb = new StringBuilder(res.length - start);
        for (int i = start; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
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
            String myResult = calculate(a, b);
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
