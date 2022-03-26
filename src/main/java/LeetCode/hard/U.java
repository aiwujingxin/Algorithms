package LeetCode.hard;

/**
 * @author jingxinwu
 * @date 2022-03-23 11:33
 */
public class U {

    public static int max = 0;

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1};
        test(arr, 0, 2);
        System.out.println(max);
    }

    public static int test(int[] array, int index, int k) {
        if (index == array.length || k == 0) {
            int len = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 1) {
                    len++;
                    max = Math.max(len, max);
                } else {
                    len = 0;
                }
            }
        }

        //回溯思想 把改变的元素再修改回来，再重新尝试, 结点（index）在改变
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 0) {
                array[j] = 1;
                test(array, index + 1, k - 1);
                array[j] = 0;
            }
        }
        return max;
    }

}
