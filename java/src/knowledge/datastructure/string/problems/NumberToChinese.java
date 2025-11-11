package knowledge.datastructure.string.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/26 14:04
 */
public class NumberToChinese {

    // 静态常量，避免重复创建
    private static final String[] NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] I_UNITS = {"", "拾", "佰", "仟"}; // 节内单位
    private static final String[] S_UNITS = {"", "万", "亿", "兆"}; // 节单位
    private static final String YUAN = "圆";
    private static final String JIAO = "角";
    private static final String FEN = "分";
    private static final String ZHENG = "整";

    /**
     * 将金额字符串转换为中文大写
     *
     * @param amount 金额字符串，例如 "12345.67"
     * @return 中文大写金额
     */
    public String toChinese(String amount) {
        if (amount == null || amount.trim().isEmpty() || !amount.matches("-?\\d+(\\.\\d+)?")) {
            return "无效的金额";
        }
        // 去除可能存在的逗号
        amount = amount.replace(",", "");
        // 处理负数
        if (amount.startsWith("-")) {
            return "负" + toChinese(amount.substring(1));
        }
        // 按小数点分割
        String[] parts = amount.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? parts[1] : "";
        // 转换整数部分
        String integerChinese = convertInteger(integerPart);
        // 转换小数部分
        String decimalChinese = convertDecimal(decimalPart, integerChinese.isEmpty());
        // 组合结果
        if (decimalChinese.isEmpty()) {
            if (integerChinese.isEmpty()) { // 如果金额是 "0" 或 "0.00"
                return "零圆整";
            }
            return integerChinese + YUAN + ZHENG;
        } else {
            if (integerChinese.isEmpty()) { // 如果金额是 "0.56"
                return decimalChinese;
            }
            return integerChinese + YUAN + decimalChinese;
        }
    }

    /**
     * 转换整数部分
     */
    private String convertInteger(String integerStr) {
        if (integerStr.equals("0")) return "";

        StringBuilder result = new StringBuilder();
        int length = integerStr.length();
        int sectionCount = (length + 3) / 4; // 每4位为一个节

        boolean zeroFlag = false;

        for (int i = 0; i < sectionCount; i++) {
            int start = length - (i + 1) * 4;
            start = Math.max(0, start);
            int end = length - i * 4;
            String sectionStr = integerStr.substring(start, end);
            int sectionNum = Integer.parseInt(sectionStr);

            if (sectionNum == 0) {
                zeroFlag = true;
            } else {
                String sectionChinese = convertSection(sectionStr);
                if (zeroFlag) {
                    result.insert(0, NUMBERS[0]);
                    zeroFlag = false;
                }
                result.insert(0, sectionChinese + S_UNITS[i]);
            }
        }

        String finalStr = result.toString();
        //  连续“零” → 单个“零”
        finalStr = finalStr.replaceAll("零+", "零");

        //  去掉结尾“零”
        if (finalStr.endsWith("零")) {
            finalStr = finalStr.substring(0, finalStr.length() - 1);
        }
        // “壹拾”开头简化为“拾”
        if (finalStr.startsWith("壹拾")) {
            finalStr = finalStr.substring(1);
        }

        return finalStr;
    }

    private String convertSection(String sectionStr) {
        StringBuilder sb = new StringBuilder();
        int len = sectionStr.length();
        boolean zeroFlag = false;
        for (int i = 0; i < len; i++) {
            int num = sectionStr.charAt(i) - '0';
            int pos = len - i - 1;
            if (num == 0) {
                zeroFlag = true;
            } else {
                if (zeroFlag) {
                    sb.append(NUMBERS[0]);
                    zeroFlag = false;
                }
                sb.append(NUMBERS[num]).append(I_UNITS[pos]);
            }
        }
        return sb.toString();
    }

    /**
     * 转换小数部分
     */
    private String convertDecimal(String decimalStr, boolean integerIsZero) {
        if (decimalStr.isEmpty() || "0".equals(decimalStr) || "00".equals(decimalStr)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int jiao = decimalStr.charAt(0) - '0';
        int fen = decimalStr.length() > 1 ? decimalStr.charAt(1) - '0' : 0;

        if (jiao == 0 && fen == 0) return "";

        if (jiao != 0) {
            result.append(NUMBERS[jiao]).append(JIAO);
        } else if (!integerIsZero) {
            // 只有整数部分非零时才补“零”
            result.append(NUMBERS[0]);
        }

        if (fen != 0) {
            result.append(NUMBERS[fen]).append(FEN);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        NumberToChinese converter = new NumberToChinese();
        System.out.println("10010.05  -> " + converter.toChinese("10010.05"));   // 壹万零壹拾圆零伍分
        System.out.println("12345.67  -> " + converter.toChinese("12345.67"));   // 壹万贰仟叁佰肆拾伍圆陆角柒分
        System.out.println("100000000 -> " + converter.toChinese("100000000"));  // 壹亿圆整
        System.out.println("100000007 -> " + converter.toChinese("100000007"));  // 壹亿零柒圆整
        System.out.println("100010000 -> " + converter.toChinese("100010000"));  // 壹亿零壹万圆整
        System.out.println("500.00    -> " + converter.toChinese("500.00"));     // 伍佰圆整
        System.out.println("15.00     -> " + converter.toChinese("15.00"));      // 拾伍圆整
        System.out.println("0.56      -> " + converter.toChinese("0.56"));       // 伍角陆分
        System.out.println("0.05      -> " + converter.toChinese("0.05"));       // 伍分
    }
}
