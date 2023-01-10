package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 22:30
 */

func permutation(s string) []string {
	if len(s) == 0 {
		return []string{}
	}
	list := make([]string, 0)
	mp := make(map[string]bool)
	var dfs func(s []byte, index int)
	dfs = func(s []byte, index int) {
		if index == len(s) {
			mp[string(s)] = true
			return
		}
		for i := index; i < len(s); i++ {
			s[i], s[index] = s[index], s[i]
			dfs(s, index+1)
			s[i], s[index] = s[index], s[i]
		}
	}

	dfs([]byte(s), 0)
	for k := range mp {
		list = append(list, k)
	}
	return list
}
