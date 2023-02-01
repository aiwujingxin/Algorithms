package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/21 22:44
 */

func combine(n int, k int) [][]int {

	res := make([][]int, 0)

	var dfs func(n, index, k int, temp []int)
	dfs = func(n, index, k int, temp []int) {
		if len(temp) > k {
			return
		}
		if len(temp) == k {
			res = append(res, append([]int(nil), temp...))
		}
		for i := index; i <= n; i++ {
			temp = append(temp, i)
			dfs(n, i+1, k, temp)
			temp = temp[:len(temp)-1]
		}
	}
	dfs(n, 1, k, []int{})
	return res
}
