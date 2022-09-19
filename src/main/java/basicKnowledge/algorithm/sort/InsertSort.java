package basicKnowledge.algorithm.sort;


/**
 * @author jingxinwu
 * @date 2021-06-06 4:45 下午
 */
public class InsertSort implements ArraySort {

    @Override
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //待排序的数
            int num = nums[i];
            //j 用来找待排序的数
            int j = i - 1;
            //当j位于比num 的数停止
            while (j >= 0 && num < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            //j向后 + 1 位，是num排序好的位置
            nums[j + 1] = num;
        }
        return nums;

    }
}
