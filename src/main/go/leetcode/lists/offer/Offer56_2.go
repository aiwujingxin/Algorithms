package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 16:11
 */

func singleNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	ones, twos := 0, 0
	for _, num := range nums {
		ones = ones ^ num&(^twos)
		twos = twos ^ num&(^ones)
	}
	return ones
}
