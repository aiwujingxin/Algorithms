package classic

import (
	"fmt"
	"strconv"
	"strings"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/22 08:37
 */

func printBin(num float64) string {
	if num == 0 {
		return ""
	}
	str := "0."
	mp := make(map[float64]bool)
	for num < 1 {
		num = num * 2
		if mp[num] || num == 0 {
			break
		}
		mp[num] = true
		if num >= 1 {
			str += "1"
			i, _ := strconv.Atoi(strings.Split(fmt.Sprintf("%f", num), ".")[0])
			num = num - float64(i)
		} else {
			str += "0"
		}
	}
	if len(str) > 32 {
		return "ERROR"
	}
	return str
}
