package offerII

import (
	"fmt"
	"math"
	"sort"
	"strconv"
	"strings"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/15 19:28
 */

//["05:31","22:08","00:35"]
//["23:58","00:00","00:01"]
//["00:01","01:03"]

func findMinDifference(timePoints []string) int {
	if len(timePoints) == 0 {
		return 0
	}
	arr := make([][]int, 0)
	for i := 0; i < len(timePoints); i++ {
		t := timePoints[i]
		h, _ := strconv.Atoi(strings.Split(t, ":")[0])
		m, _ := strconv.Atoi(strings.Split(t, ":")[1])
		arr = append(arr, []int{h, m})
	}
	sort.Sort(times(arr))
	fmt.Println(timePoints)
	diff := func(s1, s2 []int) int {
		flag := 0
		mD := 0
		hD := 0
		h1 := s1[0]
		m1 := s1[1]
		h2 := s2[0]
		m2 := s2[1]
		if m1 < m2 {
			flag = -1
			mD = 60 + m1 - m2
		} else {
			mD = m1 - m2
		}
		hD = h1 - h2 + flag
		fmt.Println(hD)
		fmt.Println(mD)
		return hD*60 + mD
	}

	min := math.MaxInt32
	for i := 0; i < len(arr)-1; i++ {
		time1 := arr[i]
		time2 := arr[i+1]
		d := diff(time1, time2)
		if min > d {
			min = d
		}
	}
	return Min(diff([]int{24, 00}, arr[0])+diff(arr[len(arr)-1], []int{00, 00}), min)
}

type times [][]int

func (s times) Len() int {
	return len(s)
}
func (s times) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s times) Less(i, j int) bool {
	h1 := s[i][0]
	m1 := s[i][1]
	h2 := s[j][0]
	m2 := s[j][1]
	if h1 == h2 {
		return m1 > m2
	} else {
		return h1 > h2
	}
}
