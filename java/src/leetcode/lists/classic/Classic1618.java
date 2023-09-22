package leetcode.lists.classic;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 14:20
 */
public class Classic1618 {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.isEmpty()) {
            return value.isEmpty();
        }

        if (value.isEmpty()) {
            return pattern.length() == 1;
        }

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';
        int size = value.length();

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                if (matches(pattern, value, mainSize, altSize, altIndex)) {

//                    System.out.println(value.substring(0, mainSize));
//                    System.out.println(value.substring(mainSize, mainSize + altSize));

                    if (!value.substring(0, mainSize).equals(value.substring(mainSize, mainSize + altSize))) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public static boolean matches(String pattern, String value, int mainSize, int altSize, int firstAlt) {
        int stringIndex = mainSize;
        for (int i = 1; i < pattern.length(); i++) {
            int size = pattern.charAt(i) == pattern.charAt(0) ? mainSize : altSize;
            int offset = pattern.charAt(i) == pattern.charAt(0) ? 0 : firstAlt;
            if (!isEqual(value, offset, stringIndex, size)) {
                return false;
            }
            stringIndex += size;
        }
        return true;
    }

    public static boolean isEqual(String s1, int offset1, int offset2, int size) {
        for (int i = 0; i < size; i++) {
            if (s1.charAt(offset1 + i) != s1.charAt(offset2 + i)) {
                return false;
            }
        }
        return true;
    }

    public static int countOf(String pattern, char c) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
