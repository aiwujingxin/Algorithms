package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 13:08
 */

func countBits(n int) []int {
	if n == 0 {
		return []int{}
	}
	res := make([]int, 0)
	for i := 0; i < n; i++ {
		num := i
		count := 0
		for num > 0 {
			if num&1 == 1 {
				count++
			}
			num >>= 1
		}
		res = append(res, count)
	}
	return res
}
