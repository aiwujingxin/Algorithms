#include<iostream>
#include<vector>
using namespace std;
int f[110][110];//f[x][v]表达选择以x为子树的物品，在容量不超过v时所获得的最大价值
vector<int> g[110];
int v[110],w[110];
int n,m,root;

int dfs(int x)
{
    for(int i=v[x];i<=m;i++) f[x][i]=w[x];//点x必须选，所以初始化f[x][v[x] ~ m]= w[x]
    for(int i=0;i<g[x].size();i++) //循环物品组
    {
        int y=g[x][i];
        dfs(y);

        // 分组背包
        for(int j=m;j>=v[x];j--) //循环体积 j的范围为v[x]~m, 小于v[x]无法选择以x为子树的物品
        {
            for(int k=0;k<=j-v[x];k++) // 循环决策 分给子树y的空间不能大于j-v[x],不然都无法选根物品x
            {
                f[x][j]=max(f[x][j],f[x][j-k]+f[y][k]);
            }
        }
    }
}

int main()
{
    cin>>n>>m;
    for(int i=1;i<=n;i++)
    {
        int fa;
        cin>>v[i]>>w[i]>>fa;
        if(fa==-1)
            root=i;
        else
            g[fa].push_back(i);
    }
    dfs(root);
    cout<<f[root][m];
    return 0;
}

