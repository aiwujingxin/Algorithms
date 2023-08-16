package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/13 13:48
 */

func twoSum(numbers []int, target int) []int {

	if len(numbers) == 0 {
		return []int{}
	}
	left, right := 0, len(numbers)-1

	for left < right {
		if numbers[left]+numbers[right] == target {
			return []int{left, right}
		} else if numbers[left]+numbers[right] < target {
			left++
		} else {
			right--
		}
	}
	return []int{}
}
