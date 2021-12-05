package classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 1:19 下午
 */
public class Number0106 {


    public static void main(String[] args) {
        System.out.println(new Number0106().compressString("aabcccccaaa"));
    }

    public String compressString(String S) {

        if (S == null || S.length() == 0) {
            return "";
        }

        if (S.length() == 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = 1;

        while (right < S.length()) {
            Character target = S.charAt(left);
            int count = 1;
            right = left + 1;

            while (right < S.length() && S.charAt(right) == target) {
                count++;
                right++;
            }
            sb.append(target).append(count);
            left = right;
        }
        return sb.toString().length() > S.length() ? S : sb.toString();
    }

}
