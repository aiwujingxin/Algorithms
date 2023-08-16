package offer

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 20:43
 */

func reverseWords(s string) string {
	fields := strings.Fields(s)
	for i, j := 0, len(fields)-1; i < j; i, j = i+1, j-1 {
		fields[i], fields[j] = fields[j], fields[i]
	}
	return strings.Join(fields, " ")
}
