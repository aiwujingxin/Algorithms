package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 15:32
 */
public class LeetCode68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int nextIndex = findNextIndex(words, index, maxWidth);
            String line = justify(index, nextIndex, words, maxWidth);
            res.add(line);
            index = nextIndex;
        }

        return res;
    }

    private String justify(int index, int nextIndex, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int gap = nextIndex - index - 1;
        // 1. only one word; 2. last word; 3. multiple words
        if (gap == 0) {
            sb.append(words[index]);
            sb.append(generateSpaces(maxWidth - sb.length()));
        } else if (nextIndex == words.length) {
            for (int i = index; i < nextIndex; i++) {
                sb.append(words[i]);
                // last word
                if (i == nextIndex - 1) break;
                sb.append(" ");
            }
            sb.append(generateSpaces(maxWidth - sb.length()));
        } else {
            int currLen = getCurrLen(words, index, nextIndex);
            int remain = maxWidth - currLen;
            int spaceEachGap = remain / gap;
            int spaceRemain = remain % gap;

            for (int i = index; i < nextIndex; i++) {
                sb.append(words[i]);
                // last word
                if (i == nextIndex - 1) break;
                sb.append(generateSpaces(spaceEachGap + 1));
                if (spaceRemain > 0) {
                    sb.append(" ");
                    spaceRemain--;
                }
            }
        }

        return sb.toString();
    }

    private int getCurrLen(String[] words, int currIndex, int nextIndex) {
        int currLen = words[currIndex].length();

        for (int i = currIndex + 1; i < nextIndex; i++) {
            currLen += words[i].length() + 1;
        }

        return currLen;
    }

    private String generateSpaces(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int findNextIndex(String[] words, int currIndex, int maxWidth) {
        int currLen = words[currIndex].length();
        int nextIndex = currIndex + 1;

        while (nextIndex < words.length) {
            if (words[nextIndex].length() + currLen + 1 > maxWidth) {
                break;
            }

            currLen += words[nextIndex].length() + 1;
            nextIndex++;
        }

        return nextIndex;
    }
}
