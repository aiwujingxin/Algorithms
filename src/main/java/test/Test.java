package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jingxinwu
 * @date 2022-02-14 8:53 PM
 */
public class Test {

    public static void main(String[] args) {
        Integer[] itg = new Integer[]{11, 455, 578, 666};
        Arrays.sort(itg, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Arrays.stream(itg).forEach(integer -> System.out.println("-----" + integer));

    }
}
