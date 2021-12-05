package classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 12:46 下午
 */
public class Number0103 {

    public static void main(String[] args) {
        System.out.println(new Number0103().replaceSpaces("               ", 5));
    }


    //题目给的字符串，后面的空格，就是故意构造出来的长度，这样就有足够空间了：
    // 足够空间，就不会越界；足够空间，从后向前操作，就不会覆盖未操作的字符
    public String replaceSpaces(String S, int length) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }
}
