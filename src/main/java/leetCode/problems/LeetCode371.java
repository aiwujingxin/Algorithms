package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/8 19:56
 */
public class LeetCode371 {

    public static void main(String[] args) {
        System.out.println(new LeetCode371().getSum(1, 2));
        System.out.println(new LeetCode371().getSum(-12, -8));

        System.out.println(new LeetCode371().getSum(12213, 4564));
        System.out.println(new LeetCode371().getSum(-12213, 4564));
        System.out.println(new LeetCode371().getSum(-8888, 8888));
        System.out.println(new LeetCode371().getSum(-8888, 4564));
        System.out.println(new LeetCode371().getSum(-4564, 8888));
        System.out.println(new LeetCode371().getSum(-1, 1));
        System.out.println(new LeetCode371().getSum(1, -1));
//        System.out.println(new LeetCode371().minus(8888, 4564));
    }

    public int getSum(int a, int b) {

        int one = Math.max(a, b);
        int two = Math.min(a, b);

        long res = 0;
        if (one == 0) {
            return two;
        }
        if (two == 0) {
            return one;
        }

        if (two > 0) {
            res = add(one, two);
        } else if (one < 0) {
            res = -1 * add(Math.abs(one), Math.abs(two));
        } else {
            res = one > Math.abs(two) ? minus(one, Math.abs(two)) : -1 * minus(Math.abs(two), one);
        }

        if (res < Integer.MIN_VALUE) {

            return Integer.MIN_VALUE;
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) res;
    }

    // 大减小
    public long minus(int a, int b) {
        String one = String.valueOf(a);
        String two = String.valueOf(b);
        StringBuilder sb = new StringBuilder();

        int i = one.length() - 1;
        int j = two.length() - 1;
        int flag = 0;
        while (i >= 0 || j >= 0) {
            int temp1 = i >= 0 ? (one.charAt(i) - '0') : 0;
            int temp2 = j >= 0 ? (two.charAt(j) - '0') : 0;
            int res;
            if (temp1 + flag < temp2) {
                res = 10 + temp1 + flag - temp2;
                flag = -1;
            } else {
                res = temp1 - temp2 + flag;
            }
            sb.append(res);
            i--;
            j--;
        }

        return Long.parseLong(sb.reverse().toString());
    }

    public long add(int a, int b) {
        String one = String.valueOf(a);
        String two = String.valueOf(b);
        StringBuilder sb = new StringBuilder();
        int i = one.length() - 1;
        int j = two.length() - 1;
        int flag = 0;
        while (i >= 0 || j >= 0) {
            int temp1 = i >= 0 ? (one.charAt(i) - '0') : 0;
            int temp2 = j >= 0 ? (two.charAt(j) - '0') : 0;
            int sum = temp1 + temp2 + flag;
            flag = sum / 10;
            int r = sum % 10;
            sb.append(r);
            i--;
            j--;
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
