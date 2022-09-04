package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-24 1:15 上午
 */
public class Offer53_2 {

    public static void main(String[] args) {
        System.out.println(new Offer53_2().missingNumber(new int[]{7, 8, 9, 11, 12}));
        System.out.println(new Offer53_2().missingNumber(new int[]{1})); //0
        System.out.println(new Offer53_2().missingNumber(new int[]{1, 2})); //0
    }


    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
