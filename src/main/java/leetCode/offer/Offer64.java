package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-12-04 3:26 下午
 */


public class Offer64 {


    public static void main(String[] args) {
        System.out.println(new Offer64().sumNums(9));
    }


    int res = 0;

    int max = 0;

    public int sumNums(int n) {
        max = n;

        helper(1);

        return res;
    }

    private void helper(int n) {
        if (n == max + 1) {
            return;
        }

        res = res + n;

        helper(n + 1);

    }


}
