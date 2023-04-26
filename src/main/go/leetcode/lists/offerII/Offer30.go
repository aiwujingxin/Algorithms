package offerII

import "math/rand"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 16:26
 */

type RandomizedSet struct {
	nums []int
	mp   map[int]int
}

func ConstructorRandomizedSet() RandomizedSet {
	return RandomizedSet{[]int{}, map[int]int{}}
}

func (rs *RandomizedSet) Insert(val int) bool {
	if _, ok := rs.mp[val]; ok {
		return false
	}
	rs.mp[val] = len(rs.nums)
	rs.nums = append(rs.nums, val)
	return true
}

func (rs *RandomizedSet) Remove(val int) bool {
	index, ok := rs.mp[val]
	if !ok {
		return false
	}
	last := len(rs.nums) - 1
	rs.nums[index] = rs.nums[last]
	rs.mp[rs.nums[index]] = index
	rs.nums = rs.nums[:last]
	delete(rs.mp, val)
	return true
}

func (rs *RandomizedSet) GetRandom() int {
	return rs.nums[rand.Intn(len(rs.nums))]
}
