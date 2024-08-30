#include <iostream>
#include <cstring>

using namespace std;

const int N = 110, M = N << 1;

int n, w[M], f[M][M];

int main()
{
    scanf("%d", &n);
    for (int i = 1; i <= n; ++ i) scanf("%d", &w[i]), w[n + i] = w[i];
    memset(f, -0x3f, sizeof f); //本题可以不用初始化，因为不存在负数的状态值，因此0就是最小的
    for (int len = 2; len <= n + 1; len++)
        for (int l = 1, r; (r = l + len - 1) <= n << 1; ++ l)
            if (len == 2) f[l][r] = 0; //初始化初始状态
            else
                for (int k = l + 1; k < r; k ++)
                    f[l][r] = max(f[l][r], f[l][k] + f[k][r] + w[l] * w[k] * w[r]);
    int res = 0;
    for (int l = 1; l <= n; ++ l) res = max(res, f[l][l + n]);
    printf("%d\n", res);
    return 0;
}
