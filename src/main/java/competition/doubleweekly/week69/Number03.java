package competition.doubleweekly.week69;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2022-01-08 10:48 PM
 */
public class Number03 {

    public static void main(String[] args) {
//        System.out.println(new Number03().longestPalindrome(new String[]{"lc", "cl", "gg"})); //6
//        System.out.println(new Number03().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));//8
//        System.out.println(new Number03().longestPalindrome(new String[]{"cc", "ll", "xx"}));//2
//        System.out.println(new Number03().longestPalindrome(new String[]{"cc", "ll", "xx", "ty", "yt"}));//10
        System.out.println(new Number03().longestPalindrome(
                new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"})); //22
//        System.out.println(new Number03().longestPalindrome(
//                new String[]{"dd", "aa"}));// 2
        System.out.println(new Number03().longestPalindrome(
                new String[]{"dd", "aa", "dd"})); //6
//        System.out.println(new Number03().longestPalindrome(
//                new String[]{"aa", "aa", "aa", "aa"})); //8
//        System.out.println(new Number03().longestPalindrome(
//                new String[]{"lo", "lo"})); //0

    }

    public int longestPalindrome(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (s.charAt(0) == s.charAt(1)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int count = 0;
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                flag = true;
                count += (entry.getValue() - 1) * 2;
            } else {
                count += (entry.getValue()) * 2;
            }
        }
        if (flag) {
            count = count + 2;
        }

        HashSet<String> set = new HashSet<>();
        int reverseCount = 0;
        int prityCount = 0;
        int sameCount = 0;

        for (String s : words) {
            String reS = new StringBuilder(s).reverse().toString();

            //不一样且 反转后相同
            if (s.charAt(0) != s.charAt(1) && set.contains(reS)) {
                reverseCount++;
            }
            //一样且 不止一个
            if (s.charAt(0) == s.charAt(1) && set.contains(reS)) {
                prityCount++;
            }
            if (s.charAt(0) == s.charAt(1)) {
                sameCount++;
            }
            set.add(s);
        }

        System.out.println("count :" + count);
        System.out.println("reverseCount :" + reverseCount);
        System.out.println("prityCount : " + prityCount);
        System.out.println("sameCount :" + sameCount);

        if (reverseCount == 0 && prityCount == 0 && sameCount == 0) {
            return 0;
        }

        if (reverseCount == 0) {
            if (prityCount == 0) {
                return 2;
            } else {
                return count;
            }
        }

        int res = reverseCount * 4 + prityCount * 4 + (sameCount * 2);

//        int resver = reverseCount * 4;
//        int same = 0;
//        if (resver != 0) {
//            same = sameCount * 2;
//        } else {
//            same = sameCount == 0 ? 0 : 2;
//        }
//
//        if (prityCount == 0) {
//            if (same >= reverseCount) {
//                return reverseCount * 2 + 2;
//
//            } else {
//                return reverseCount * 2 + 2;
//            }
//        }
//        res = resver + same;
        return res;
    }

}
