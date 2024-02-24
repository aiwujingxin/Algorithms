#include <iostream>
#include <cstring>

using namespace std;

const int N = 200010, M = N * 2;

int n;
int h[N], e[M], w[M], ne[M], idx; //邻接表
int d[N]; //设 d[i] 表示根节点为 root 时，从 i 出发流向子树的流量最大是多少
int f[N]; //设 f[i] 表示把 i 作为源点，流向整个水系，流量最大是多少
int deg[N]; //记录每个节点的度数
int root; //根节点

void add(int a, int b, int c) //添加边
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dp(int u, int father) //树形 dp，father 表示 u 的父节点，防止往回走导致死循环
{
    d[u] = 0; //初始化

    for(int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if(j == father) continue;

        dp(j, u); //向下递归

        //状态转移方程
        if(deg[j] == 1) d[u] += w[i];
        else d[u] += min(d[j], w[i]);
    }
}

void dfs(int u, int father) //dfs 换根，father 表示 u 的父节点，防止往回走导致死循环
{
    for(int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if(j == father) continue;

        //计算以 j 为源点的最大流量
        if(deg[u] == 1) f[j] = d[j] + w[i];
        else if(deg[j] == 1) f[j] = d[j] + min(f[u] - w[i], w[i]);
        else f[j] = d[j] + min(f[u] - min(d[j], w[i]), w[i]);

        //继续向下计算其他节点作为源点的最大流量
        dfs(j, u);
    }
}

int main()
{
    int T;
    scanf("%d", &T);
    while(T--)
    {
        scanf("%d", &n);

        memset(deg, 0, sizeof deg); //清空度数
        memset(h, -1, sizeof h); //初始化邻接表
        idx = 0;

        for(int i = 0; i < n - 1; i++)
        {
            int a, b, c;
            scanf("%d%d%d", &a, &b, &c);
            add(a, b, c), add(b, a, c); //无向边
            deg[a]++, deg[b]++; //度数 + 1
        }

        root = 1; //任选一个节点作为根节点
        dp(root, -1); //树形 dp 求出根节点为 root 时，从所有节点出发流向子树的最大流量

        f[root] = d[root]; //把 root 作为源点流向整个水系的流量已经计算出来了
        dfs(root, -1); //自顶向下递推除其他节点作为源点时的最大流量

        int res = 0; //记录最大流量
        for(int i = 1; i <= n; i++) res = max(res, f[i]);
        printf("%d\n", res);
    }

    return 0;
}

