package offerII;

/**
 * @author jingxinwu
 * @date 2021-12-06 11:44 下午
 */
public class Offer2 {

    public static void main(String[] args) {
        System.out.println(new Offer2().addBinary("11", "10"));
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}
