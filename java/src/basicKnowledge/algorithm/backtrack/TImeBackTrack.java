package basicKnowledge.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 10:11
 */
/*
 * 给四个数字 输出符合时间格式的全排列, 1,2,5,6
 * 12:56
 * 21:56
 * 15:26
 * ...
 */
public class TImeBackTrack {

    public static void main(String[] args) {
        System.out.println(new TImeBackTrack().time(new int[]{1, 2, 5, 6}));
    }

    public List<List<String>> time(int[] arr) {
        List<List<String>> res = new ArrayList<>();

        return res;

    }

}
