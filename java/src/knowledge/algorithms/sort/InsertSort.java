package knowledge.algorithms.sort;


/**
 * @author jingxinwu
 * @date 2021-06-06 4:45 下午
 * @description 插入排序
 * 将数组分为已排序区间和未排序区间两部分
 * 从未排序区间中依次取元素跟已排序区间的元素一一对比，找到适合插入的位置。
 */
public class InsertSort implements Sort {

    @Override
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int j = i - 1;
            while (j >= 0 && x < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = x;
        }
        return nums;
    }
}
