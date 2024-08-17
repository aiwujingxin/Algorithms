#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 60;

int n;
int h[N];
int up[N], down[N];

bool dfs(int depth, int u, int su, int sd)
{
    // 如果上升序列个数 + 下降序列个数 > 总个数是上限，则回溯
    if (su + sd > depth) return false;
    if (u == n) return true;

    // 枚举放到上升子序列中的情况
    bool flag = false;
    for (int i = 1; i <= su; i ++ )
        if (up[i] < h[u])
        {
            int t = up[i];
            up[i] = h[u];
            if (dfs(depth, u + 1, su, sd)) return true;
            up[i] = t;
            flag = true;
            break;  // 注意由上述证明的贪心原理，只要找到第一个可以放的序列，就可以结束循环了
        }
    if (!flag)  // 如果不能放到任意一个序列后面，则单开一个新的序列
    {
        up[su + 1] = h[u];
        if (dfs(depth, u + 1, su + 1, sd)) return true;
    }

    // 枚举放到下降子序列中的情况
    flag = false;
    for (int i = 1; i <= sd; i ++ )
        if (down[i] > h[u])
        {
            int t = down[i];
            down[i] = h[u];
            if (dfs(depth, u + 1, su, sd)) return true;
            down[i] = t;
            flag = true;
            break;  // 注意由上述证明的贪心原理，只要找到第一个可以放的序列，就可以结束循环了
        }
    if (!flag)  // 如果不能放到任意一个序列后面，则单开一个新的序列
    {
        down[sd + 1] = h[u];
        if (dfs(depth, u + 1, su, sd + 1)) return true;
    }

    return false;
}

int main()
{
    while (cin >> n, n)
    {
        for (int i = 0; i < n; i ++ ) cin >> h[i];

        int depth = 0;
        while (!dfs(depth, 0, 0, 0)) depth ++ ;     // 迭代加深搜索

        cout << depth << endl;
    }

    return 0;
}
