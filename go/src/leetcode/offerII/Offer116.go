package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/27 17:49
 */

func findCircleNum(isConnected [][]int) (ans int) {
	vis := make([]bool, len(isConnected))
	var dfs func(int)
	dfs = func(from int) {
		vis[from] = true
		for to, conn := range isConnected[from] {
			if conn == 1 && !vis[to] {
				dfs(to)
			}
		}
	}
	for i, v := range vis {
		if !v {
			ans++
			dfs(i)
		}
	}
	return
}
