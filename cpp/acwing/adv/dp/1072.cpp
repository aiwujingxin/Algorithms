#include <iostream>
#include <cstring>

using namespace std;

const int N = 1e4 + 10, M = N << 1; //初始不确定树的拓扑结构，因此要建立双向边

int n;
int h[N], e[M], w[M], ne[M], idx;
int f1[N], f2[N], res;

void add(int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx ++ ;
}

void dfs(int u, int father)
{
    f1[u] = f2[u] = 0;
    for (int i = h[u]; ~i; i = ne[i])
    {
        int j = e[i];
        if (j == father) continue;
        dfs(j, u);
        if (f1[j] + w[i] >= f1[u]) f2[u] = f1[u] ,f1[u] = f1[j] + w[i]; //最长路转移
        else if (f1[j] + w[i] > f2[u]) f2[u] = f1[j] + w[i];            //次长路转移
    }
    res = max(res, f1[u] + f2[u]);
}
int main()
{
    memset(h, -1, sizeof h);
    scanf("%d", &n);
    for (int i = 0; i < n - 1; i ++ )
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    dfs(1, -1); //我们可以任意选取一个点作为根节点，这样整棵树的拓扑结构被唯一确定下来了
    printf("%d\n", res);
    return 0;
}
