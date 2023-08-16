package topinterview

//https://leetcode.com/problems/wiggle-sort-ii/solutions/956983/golang-quick-select-median-3-partition-solution/

/**
*利用快速筛选法求出排序后的数组中 nums[mid]，然后我们利用快排的 quickSelectPartition 方法将将原数组分为三部分：
严格小于nums[mid] 的部分，等于nums[mid] 的部分,严格大于nums[mid] 的部分
*/
func wiggleSort(nums []int) {
	if len(nums) == 0 {
		return
	}
	//partNums - partitioned slice
	partNums := make([]int, len(nums))
	copy(partNums, nums)

	k := (len(nums) - 1) / 2 //k is the median position

	quickSelect(partNums, k) //此处的quickSelect做不到完全有序，所以依靠下一步的part,

	mid := partNums[k] //quick select to find the mid

	part(partNums, mid) //quickSelectPartition process, move smaller than nums[mid] to left, move bigger than nums[mid] to right

	//split partNums into 2 lists
	list1 := partNums[:k+1]
	list2 := partNums[k+1:]

	//generate wiggle result from the 2 lists
	j := 0
	for i := 1; i <= len(list1); i++ {
		nums[j] = list1[len(list1)-i]
		j++
		if len(list2)-i >= 0 {
			nums[j] = list2[len(list2)-i]
		}
		j++
	}
	return
}

func part(nums []int, mid int) {
	left := 0
	right := len(nums) - 1
	index := 0
	for index <= right {
		if nums[index] > mid {
			swap(nums, index, right)
			right--
		} else if nums[index] < mid {
			swap(nums, index, left)
			left++
			index++
		} else {
			index++
		}
	}
}

func quickSelect(nums []int, k int) {
	pivot := len(nums) - 1
	i := 0
	j := 0
	for j < len(nums)-1 {
		if nums[j] >= nums[pivot] {
			j++
		} else {
			swap(nums, i, j)
			i++
			j++
		}
	}
	swap(nums, i, pivot)
	if i == k {
		return
	} else if i > k {
		quickSelect(nums[:i], k)
	} else {
		quickSelect(nums[i+1:], k-i-1)
	}
	return
}

func swap(nums []int, i, j int) {
	temp := nums[i]
	nums[i] = nums[j]
	nums[j] = temp
	return
}
