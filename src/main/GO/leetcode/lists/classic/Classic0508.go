package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/25 13:20
 */

func drawLine(length int, w int, x1 int, x2 int, y int) []int {

	screen := make([]int, length)

	start_offset := x1 % 32
	first_full_int := x1 / 32

	if start_offset != 0 {
		first_full_int++
	}

	end_offset := x2 % 32
	last_full_int := x2 / 32
	if end_offset != 31 {
		last_full_int--
	}

	for b := first_full_int; b <= last_full_int; b++ {
		screen[(w/32)*y+b] = -1
	}

	// 掩码
	start_mask := 0xFFFFFFFF >> start_offset
	//^ 取反 https://www.runoob.com/java/java-operators.html
	end_mask := ^(0xFFFFFFFF >> (end_offset + 1))

	if x1/32 == x2/32 {
		mask := start_mask & end_mask
		screen[w/32*y+x1/32] |= mask
	} else {
		if start_offset != 0 {
			byte_number := (w/32)*y + first_full_int - 1
			screen[byte_number] |= start_mask
		}

		if end_offset != 31 {
			byte_number := (w/32)*y + last_full_int + 1
			screen[byte_number] |= end_mask
		}
	}
	return screen
}
