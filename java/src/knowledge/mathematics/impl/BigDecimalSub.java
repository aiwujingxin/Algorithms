package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:12
 */
public class BigDecimalSub {

    public static String subtract(String num1, String num2) {
        boolean isNum1Negative = num1.startsWith("-");
        boolean isNum2Negative = num2.startsWith("-");
        String positiveNum1 = isNum1Negative ? num1.substring(1) : num1;
        String positiveNum2 = isNum2Negative ? num2.substring(1) : num2;
        // 情况1: a - (-b)  =>  a + b
        if (!isNum1Negative && isNum2Negative) {
            return BigDecimalAdd.addStrings(positiveNum1, positiveNum2);
        }
        // 情况2: -a - b  =>  -(a + b)
        if (isNum1Negative && !isNum2Negative) {
            return "-" + BigDecimalAdd.addStrings(positiveNum1, positiveNum2);
        }
        // 情况3: -a - (-b)  =>  b - a
        if (isNum1Negative) {
            return subtract(positiveNum2, positiveNum1); // 交换一下，调用自己
        }
        // 情况4: a - b (都是正数)
        int cmp = compare(positiveNum1, positiveNum2);
        if (cmp == 0) {
            return "0";
        }
        if (cmp > 0) {// num1 > num2
            return doSubtract(positiveNum1, positiveNum2);
        }
        // num1 < num2, 结果是 -(num2 - num1)
        return "-" + doSubtract(positiveNum2, positiveNum1);
    }

    /**
     * 核心减法逻辑：计算大数减小数 (big - small)
     *
     * @return (big - small) 的结果字符串
     */
    private static String doSubtract(String big, String small) {
        StringBuilder res = new StringBuilder();
        int i = big.length() - 1;
        int j = small.length() - 1;
        int borrow = 0;
        while (i >= 0) {
            int digit1 = big.charAt(i--) - '0';
            int digit2 = j >= 0 ? small.charAt(j--) - '0' : 0;
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            res.append(diff);
        }
        // 反转并去除前导零
        res.reverse();
        int start = 0;
        while (start < res.length() - 1 && res.charAt(start) == '0') {
            start++;
        }
        return res.substring(start);
    }

    public static String subtractDecimalStrings(String num1, String num2) {
        // 1. 符号逻辑分派
        boolean isNum1Negative = num1.startsWith("-");
        boolean isNum2Negative = num2.startsWith("-");
        String pNum1 = isNum1Negative ? num1.substring(1) : num1;
        String pNum2 = isNum2Negative ? num2.substring(1) : num2;
        if (!isNum1Negative && isNum2Negative) { // a - (-b) => a + b
            // 这里需要一个小数加法函数，我们假设它也已实现
            return BigDecimalAdd.addDecimalStrings(pNum1, pNum2);
        }
        if (isNum1Negative && isNum2Negative) { // -a - (-b) => b - a
            return subtractDecimalStrings(pNum2, pNum1);
        }
        // 同样，-a - b => -(a+b) 也需要小数加法
        // --- 核心逻辑: 两个正小数相减 pNum1 - pNum2 ---
        // 2. 统一小数位数
        int decPlaces1 = pNum1.contains(".") ? pNum1.length() - pNum1.indexOf('.') - 1 : 0;
        int decPlaces2 = pNum2.contains(".") ? pNum2.length() - pNum2.indexOf('.') - 1 : 0;
        int maxDecimalPlaces = Math.max(decPlaces1, decPlaces2);
        // 3. 转换为等效整数的字符串
        String intStr1 = pNum1.replace(".", "") + "0".repeat(maxDecimalPlaces - decPlaces1);
        String intStr2 = pNum2.replace(".", "") + "0".repeat(maxDecimalPlaces - decPlaces2);
        // 4. 调用我们手写的完整整数减法
        String diffStr = subtract(intStr1, intStr2);
        // 5. 放回小数点
        if (maxDecimalPlaces == 0) {
            return diffStr;
        }
        boolean isResultNegative = diffStr.startsWith("-");
        StringBuilder absDiffStr = new StringBuilder(isResultNegative ? diffStr.substring(1) : diffStr);
        // 如果结果长度不足小数位数，前面要补0
        while (absDiffStr.length() <= maxDecimalPlaces) {
            absDiffStr.insert(0, "0");
        }
        int dotPos = absDiffStr.length() - maxDecimalPlaces;
        String result = absDiffStr.substring(0, dotPos) + "." + absDiffStr.substring(dotPos);
        // 6. 格式化结果 (去掉末尾的0和小数点)
        // 使用 StringBuilder 提高效率
        StringBuilder finalResult = new StringBuilder(result);
        // 去掉末尾的0
        while (!finalResult.isEmpty() && finalResult.charAt(finalResult.length() - 1) == '0') {
            finalResult.deleteCharAt(finalResult.length() - 1);
        }
        // 如果小数点是最后一位，也去掉
        if (!finalResult.isEmpty() && finalResult.charAt(finalResult.length() - 1) == '.') {
            finalResult.deleteCharAt(finalResult.length() - 1);
        }
        // 如果结果是"0"或"", 返回"0"
        if (finalResult.isEmpty() || finalResult.toString().equals("0")) {
            return "0";
        }
        return isResultNegative ? "-" + finalResult.toString() : finalResult.toString();
    }

    /**
     * 比较两个纯数字字符串的大小
     *
     * @return 1 如果 num1 > num2, -1 如果 num1 < num2, 0 如果 num1 == num2
     */
    public static int compare(String num1, String num2) {
        if (num1.length() > num2.length()) return 1;
        if (num1.length() < num2.length()) return -1;
        // 长度相等，从高位逐位比较
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) > num2.charAt(i)) return 1;
            if (num1.charAt(i) < num2.charAt(i)) return -1;
        }
        return 0; // 完全相等
    }
}
