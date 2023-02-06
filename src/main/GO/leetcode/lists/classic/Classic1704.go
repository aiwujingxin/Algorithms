package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/3 17:12
 */

func missingNumber(nums []int) int {
	has := map[int]bool{}
	for _, v := range nums {
		has[v] = true
	}
	for i := 0; ; i++ {
		if !has[i] {
			return i
		}
	}
}
