package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/21 22:23
 */

func findKthLargest(nums []int, k int) int {
	if len(nums) == 0 {
		return -1
	}
	return findKthLargestH(nums, 0, len(nums)-1, k)
}

func findKthLargestH(nums []int, start, end, k int) int {
	left, right := start, end
	for left <= right {
		index := part(nums, start, end)

		if index+1 == k {
			return nums[index]
		} else if index+1 < k {
			return findKthLargestH(nums, index+1, end, k)
		} else {
			return findKthLargestH(nums, start, index-1, k)
		}
	}
	return -1
}

func part(nums []int, i, j int) int {
	pi := nums[i]
	for i < j {
		for i < j && nums[j] <= pi {
			j--
		}
		nums[i] = nums[j]
		for i < j && nums[i] >= pi {
			i++
		}
		nums[j] = nums[i]
	}
	nums[i] = pi
	return i
}
