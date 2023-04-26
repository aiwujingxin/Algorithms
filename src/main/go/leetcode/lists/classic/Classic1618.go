package classic

import (
	"strings"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/17 12:55
 */

func patternMatching(pattern string, value string) bool {
	if len(pattern) == 0 {
		return len(value) == 0
	}
	if len(value) == 0 {
		return len(pattern) == 1
	}
	count := func(ch byte) int {
		sum := 0
		for i := 0; i < len(pattern); i++ {
			if ch == pattern[i] {
				sum++
			}
		}
		return sum
	}

	isEqual := func(s1 string, offset1, offset2, size int) bool {
		for i := 0; i < size; i++ {
			if s1[offset1+i] != s1[offset2+i] {
				return false
			}
		}
		return true
	}
	matches := func(aSize int, bIndex, bSize int) bool {
		index := aSize
		for i := 1; i < len(pattern); i++ {
			var size, offset int
			if pattern[i] == pattern[0] {
				size = aSize
				offset = 0
			} else {
				size = bSize
				offset = bIndex
			}
			if !isEqual(value, index, offset, size) {
				return false
			}
			index += size
		}
		return true
	}

	var aCh, bCh byte
	aCh = pattern[0]

	if aCh == 'a' {
		bCh = 'b'
	} else {
		bCh = 'a'
	}
	size := len(value)

	//一旦选定了 a，我们也就相应的选定了 b
	countA := count(aCh)
	countB := len(pattern) - countA
	firstB := strings.Index(pattern, string(bCh))

	for aSize := 3; aSize <= size/countA; aSize++ {
		remainingLength := size - aSize*countA
		if countB == 0 || remainingLength%countB == 0 {
			bIndex := firstB * aSize
			bSize := 0
			if countB != 0 {
				bSize = remainingLength / countB
			}
			if matches(aSize, bIndex, bSize) {
				if value[0:aSize] != value[aSize:aSize+bSize] {
					return true
				}
			}
		}
	}
	return false
}
