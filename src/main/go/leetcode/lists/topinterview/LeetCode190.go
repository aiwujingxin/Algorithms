package topinterview

func reverseBits(num uint32) uint32 {
	if num == 0 {
		return 0
	}
	var res uint32
	for i := 0; i < 32; i++ {
		res <<= 1
		if (num & 1) == 1 {
			res += 1
		}
		num >>= 1
	}
	return res
}
