package basic.algorithm.sort;


/**
 * @author jingxinwu
 * @date 2021-06-06 4:45 下午
 */
public class InsertSort implements Sort {


    //将数组分为已排序区间和未排序区间两部分，
    // 从未排序区间中依次取元素跟已排序区间的元素一一对比，找到适合插入的位置。
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
