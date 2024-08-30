#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

const int N = 16;
int n, m = 8;
int s[N][N];
double f[N][N][N][N][N];
double X;

double get(int x1, int y1, int x2, int y2)  //求该矩阵的 n\sigma^2
{
    double delta = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
    delta = delta - X;
    return delta * delta;
}
double dp(int k, int x1, int y1, int x2, int y2)
{
    if (f[k][x1][y1][x2][y2] >= 0) return f[k][x1][y1][x2][y2]; //记忆化搜索
    if (k == n) return f[k][x1][y1][x2][y2] = get(x1, y1, x2, y2);  //更新初始状态

    double t = 1e9; //初始化为无穷大
    for (int i = x1; i < x2; i ++ ) //横着切
    {
        t = min(t, dp(k + 1, x1, y1, i, y2) + get(i + 1, y1, x2, y2));
        t = min(t, dp(k + 1, i + 1, y1, x2, y2) + get(x1, y1, i, y2));
    }
    for (int i = y1; i < y2; i ++ ) //竖着切
    {
        t = min(t, dp(k + 1, x1, y1, x2, i) + get(x1, i + 1, x2, y2));
        t = min(t, dp(k + 1, x1, i + 1, x2, y2) + get(x1, y1, x2, i));
    }
    return f[k][x1][y1][x2][y2] = t;
}
int main()
{
    //读入
    scanf("%d", &n);
    for (int i = 1; i <= m; i ++ )
        for (int j = 1; j <= m; j ++ )
            scanf("%d", &s[i][j]);
    //预处理前缀和
    for (int i = 1; i <= m; i ++ )
        for (int j = 1; j <= m; j ++ )
            s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
    //初始化所有状态
    memset(f, -1, sizeof f);
    //计算均值X拔
    X = (double) s[m][m] / n;
    //记忆化搜索
    printf("%.3lf\n", sqrt(dp(1, 1, 1, m, m) / n));
    return 0;
}
