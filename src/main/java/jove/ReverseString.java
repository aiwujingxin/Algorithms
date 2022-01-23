package jove;

/**
 * @author jingxinwu
 * @date 2022-01-08 12:06 PM
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("ibwa am a student"));
    }

    public String reverse(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = reverse(s.toCharArray(), 0, s.length() - 1);

        System.out.println(chars);

        int first = 0;
        int second = first + 1;
        while (second < chars.length) {
            while (first < chars.length) {
                if (chars[first] != ' ') {
                    break;
                } else {
                    first++;
                }
            }
            while (second < chars.length) {
                if (chars[second] == ' ') {
                    break;
                } else {
                    second++;
                }
            }

            reverse(chars, first, second - 1);
            first = second;
            second = first + 1;
        }

        return String.copyValueOf(chars);

    }

    public char[] reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return chars;
    }

}
