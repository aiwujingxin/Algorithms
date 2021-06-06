package newker;

/**
 * @author jingxinwu
 * @date 2021-05-24 11:25 下午
 */
public class MaxsumofSubarray {


    public static void main(String[] args) {
        System.out.println(maxsumofSubarray(new int[]{1, -2, 3, 5, -2, 6, -1}));
    }

    public static int maxsumofSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int fn = 0;
        for (int i : arr) {
            fn = Math.max(fn + i, i);
            max = Math.max(max, fn);
        }
        return max;
    }
}
