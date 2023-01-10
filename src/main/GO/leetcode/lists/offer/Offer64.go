package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 02:54
 */

func sumNums(n int) int {
	ans := 0
	var dfs func(int)
	dfs = func(n int) {
		if n <= 0 {
			return
		}
		ans += n
		dfs(n - 1)
	}
	dfs(n)
	return ans
}
