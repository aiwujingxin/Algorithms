#include <iostream>
#include <cstring>

using namespace std;

const int N = 210, M = N << 1, INF = 0x3f3f3f3f;

int n;
int w[M], s[M];
int f[M][M], g[M][M];

int main()
{
    //读入
    scanf("%d", &n);
    for (int i = 1; i <= n; ++ i) cin >> w[i], w[i + n] = w[i];

    //预处理前缀和（DP状态转移中会频繁的用到区间和）
    for (int i = 1; i <= n << 1; ++ i) s[i] = s[i - 1] + w[i];

    memset(f, -0x3f, sizeof f);//求最大值预处理成最小值（可以省掉，这题不会有负数状态所以0就是最小）
    memset(g, +0x3f, sizeof g);//求最小值预处理成最大值（不可省掉）

    for (int len = 1; len <= n; ++ len)//阶段
    {
        for (int l = 1, r; r = l + len - 1, r < n << 1; ++ l)//左右区间参数
        {
            if (len == 1) f[l][l] = g[l][l] = 0;//预处理初始状态
            else
            {
                for (int k = l; k + 1 <= r; ++ k)//枚举分开点
                {
                    f[l][r] = max(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]),
                    g[l][r] = min(g[l][r], g[l][k] + g[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
    }
    //目标状态中找出方案
    int minv = INF, maxv = -INF;
    for (int l = 1; l <= n; ++ l)
    {
        minv = min(minv, g[l][l + n - 1]);
        maxv = max(maxv, f[l][l + n - 1]);
    }

    //输出
    printf("%d\n%d\n", minv, maxv);

    return 0;
}
