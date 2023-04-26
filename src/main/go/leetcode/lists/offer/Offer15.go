package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 21:49
 */

func hammingWeight(num uint32) int {
	count := 0
	for i := 0; i < 32; i++ {
		if (num & 1) == 1 {
			count++
		}
		num >>= 1
	}
	return count
}
