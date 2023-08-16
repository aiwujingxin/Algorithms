package hot100

func findDuplicate(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	left, right, ans := 0, len(nums)-1, -1
	for left <= right {
		mid := (left + right) / 2
		count := 0
		for i := 0; i < len(nums); i++ {
			if nums[i] <= mid {
				count++
			}
		}
		if count <= mid {
			left = mid + 1
		} else {
			right = mid - 1
			ans = mid //说明这是符合条件的答案， 为什么不直接返回呢？
			//因为要找到第一个数字，那个数字才是答案
		}
	}
	return ans
}

func findDuplicateII(nums []int) int {
	slow, fast := 0, 0
	for slow, fast = nums[slow], nums[nums[fast]]; slow != fast; slow, fast = nums[slow], nums[nums[fast]] {
	}
	slow = 0
	for slow != fast {
		slow = nums[slow]
		fast = nums[fast]
	}
	return slow
}
