package offer;

/**
 * @author jingxinwu
 * @date 2021-11-25 12:51 上午
 */
public class Offer56_2 {


    //todo
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
