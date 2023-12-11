package basic.datastructure.string.nubmer;

/**
 * @author jingxinwu
 * @date 2022-01-03 6:12 PM
 */
public class BigDecimal implements basic.datastructure.string.BigDecimal {

    @Override
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
            int num = n1 + n2 + flag;
            flag = num / 10;
            sb.append(num % 10);
            i--;
            j--;
        }
        if (flag > 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    @Override
    public String subtract(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return "";
        }
        if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            return addStrings(num1, num2.substring(1));
        }
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            return "-" + addStrings(num1.substring(1), num2);
        }
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
        }
        boolean sign = true;//正负号
        if (!compare(num1, num2)) {
            sign = false;
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int borrow = 0;//借位
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? (ch1[len1--] - '0') : 0;
            int n2 = len2 >= 0 ? (ch2[len2--] - '0') : 0;
            int num = n1 - n2 - borrow;
            borrow = 0;
            //需要向前借位
            if (num < 0) {
                borrow = 1;
                num += 10;
            }
            sb.append(num);
        }
        sb.reverse();//需要先翻转
        int index = 0;//去掉前面没用的’0‘
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        //如果两个数相同 直接返回"0"
        if (index == sb.length()) {
            return "0";
        }
        return sign ? sb.substring(index) : "-" + sb.substring(index);
    }

    @Override
    public String divide(String dividend, int divisor) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < dividend.length(); i++) {
            int t = dividend.charAt(i) - '0' + carry * 10;
            int currentResult = t / divisor;
            carry = t % divisor;
            sb.append(currentResult);
        }
        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }

    @Override
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        }

        if (num2 == null || num2.isEmpty()) {
            return num1;
        }

        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int p1 = i + j; // 十位
                int p2 = i + j + 1;// 个位
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[p2];
                arr[p2] = sum % 10; //个位
                arr[p1] += sum / 10; //十位
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j : arr) {
            if (sb.isEmpty() && j == 0) {
                continue;
            }
            sb.append(j);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static boolean compare(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return false;
        } else if (num1.length() > num2.length()) {
            return true;
        } else {
            return num1.compareTo(num2) > 0;
        }
    }
}
