package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 16:45
 */
public class Offer56_2_bit {

    public static void main(String[] args) {
        System.out.println(new Offer56_2_bit().singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
//        System.out.println(Arrays.toString(counts));
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
