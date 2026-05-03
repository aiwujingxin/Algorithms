package knowledge.datastructure.string.match;

import knowledge.datastructure.string.trie.ACAutomaton;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/26 17:47
 */
public class ACMaton implements knowledge.datastructure.string.match.StringMatch {

    public int strStr(String haystack, String needle) {
        // 1. 初始化并构建 AC 自动机
        ACAutomaton ac = new ACAutomaton();
        ac.insert(needle);
        ac.build();
        // 2. 在 haystack 中查询
        ACAutomaton.Node node = ac.root;
        for (int i = 0; i < haystack.length(); i++) {
            int index = haystack.charAt(i) - 'a';
            // 匹配失败，顺着 fail 指针回溯
            if (node != null && node.children[index] == null) {
                node = node.fail;
            }
            if (node == null) {
                node = ac.root;
                continue;
            }
            // 匹配成功，走到下一个节点
            node = node.children[index];
            // 如果当前节点是结束节点，说明找到了 needle
            if (node.isEnd) {
                // i 是结束位置，起始位置 = 结束位置 - 模式串长度 + 1
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}
