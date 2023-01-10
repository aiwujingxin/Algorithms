package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 20:11
 */

func findContinuousSequence(target int) [][]int {

	if target == 0 {
		return [][]int{}
	}
	n := target/2 + 1
	presum := make([]int, n+1)
	presum[0] = 0
	sum := 0
	for i := 1; i <= n; i++ {
		sum = sum + i
		presum[i] = sum
	}
	mp := make(map[int]int)
	res := make([][]int, 0)
	for i := 0; i < len(presum); i++ {
		if v, ok := mp[presum[i]-target]; ok {
			t := make([]int, 0)
			for j := v + 1; j <= i; j++ {
				t = append(t, j)
			}
			res = append(res, t)
		}
		mp[presum[i]] = i
	}
	return res
}
