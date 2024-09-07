// 285.cpp
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1510;

int n;
int h[N], e[N], ne[N], idx;
int f[N][2];
bool not_root[N];

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx ++ ;
}
void dfs(int u)
{
    f[u][0] = 0, f[u][1] = 1;  //initialize
    for (int i = h[u]; ~i; i = ne[i])
    {
        int j = e[i];
        dfs(j);

        f[u][0] += f[j][1];
        f[u][1] += min(f[j][0], f[j][1]);
    }
}
int main()
{
    while (~scanf("%d", &n))
    {
        memset(h, -1, sizeof h); idx = 0;
        memset(not_root, 0, sizeof not_root);
        for (int i = 0; i < n; i ++ )
        {
            int a, b, siz;
            scanf("%d:(%d) ", &a, &siz);
            while (siz -- )
            {
                scanf("%d", &b);
                add(a, b);
                not_root[b] = true;
            }
        }
        int root = 0;
        while (not_root[root]) root ++ ;
        dfs(root);
        printf("%d\n", min(f[root][0], f[root][1]));
    }
    return 0;
}