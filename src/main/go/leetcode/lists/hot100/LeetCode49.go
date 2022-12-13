package hot100

//https://leetcode.com/problems/group-anagrams/solutions/434269/golang-17-lines-of-easy-to-understand-solution-without-using-sort/
func groupAnagrams(strs []string) [][]string {
	mp := map[[26]int][]string{}
	for _, s := range strs {
		k := [26]int{}
		for i := 0; i < len(s); i++ {
			k[s[i]-'a'] += 1
		}
		mp[k] = append(mp[k], s)
	}
	var res [][]string
	for _, v := range mp {
		res = append(res, v)
	}
	return res
}
