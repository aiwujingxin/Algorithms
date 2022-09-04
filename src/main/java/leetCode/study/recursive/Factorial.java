package leetCode.study.recursive;

/**
 * @author jingxinwu
 * @date 2022-01-31 1:33 PM
 */
public class Factorial {


    public static void main(String[] args) {
        System.out.println(new Factorial().factorial(4));
    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return (n) * factorial(n - 1);
    }
}
