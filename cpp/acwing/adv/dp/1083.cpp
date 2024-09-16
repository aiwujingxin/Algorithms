#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int N = 11;

int f[N][10];// f[i][j]表示一共有i位, 且最高位数字为j的windy数的个数

void init()
{
    for (int i = 0; i <= 9; i ++ ) f[1][i] = 1; // 一位数

    for (int i = 2; i < N; i ++ )  // 阶段
        for (int j = 0; j <= 9; j ++ ) // 状态
            for (int k = 0; k <= 9; k ++ ) // 决策
                if (abs(j - k) >= 2)
                    f[i][j] += f[i - 1][k];
}

int dp(int n)
{
    if (!n) return 0; // 特判

    vector<int> nums;
    while (n) nums.push_back(n % 10), n /= 10;

    // 答案是cnt位的
    int res = 0;
    int last = -2; // last 表示上一位数字
    for (int i = nums.size() - 1; i >= 0; i -- )
    {
        int x = nums[i];
        for (int j = i == nums.size() - 1; j < x; j ++ )
            if (abs(j - last) >= 2)
                res += f[i + 1][j];

        if (abs(x - last) < 2) break;
        last = x;
        if (i==1) res ++ ; // 特判 走到a1的情况
    }

    // 小于cnt位的
    for (int i = 1; i < nums.size(); i ++ )
        for (int j = 1; j <= 9; j ++ )
            res += f[i][j]; // 累加答案

    return res;
}

int main()
{
    init();

    int l, r;
    cin >> l >> r;
    cout << dp(r) - dp(l - 1) << endl;

    return 0;
}
