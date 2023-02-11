package classic

import "sort"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:58
 */

func permutationII(s string) []string {

	if len(s) == 0 {
		return []string{}
	}
	bytes := []byte(s)
	sort.Slice(bytes, func(i, j int) bool {
		return bytes[i] > bytes[j]
	})
	res := make([]string, 0)
	var dfs = func(index int, bytes []byte) {}
	dfs = func(index int, bytes []byte) {
		if index == len(s) {
			res = append(res, string(bytes))
			return
		}
		mp := make(map[byte]bool)
		for i := index; i < len(bytes); i++ {
			if mp[bytes[i]] {
				continue
			}
			mp[bytes[i]] = true
			bytes[i], bytes[index] = bytes[index], bytes[i]
			dfs(index+1, bytes)
			bytes[i], bytes[index] = bytes[index], bytes[i]
		}
	}
	dfs(0, bytes)
	return res
}
