package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 17:53
 */

func permutation(s string) []string {

	if len(s) == 0 {
		return []string{}
	}
	res := make([]string, 0)
	var dfs func(index int, t []byte)
	dfs = func(index int, t []byte) {
		if index == len(s) {
			res = append(res, string(t))
			return
		}
		for i := index; i < len(t); i++ {
			t[i], t[index] = t[index], t[i]
			dfs(index+1, t)
			t[i], t[index] = t[index], t[i]
		}
	}
	dfs(0, []byte(s))
	return res
}
