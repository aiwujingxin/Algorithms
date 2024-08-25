#include <bits/stdc++.h>
using namespace std;
const int N=13,Mod=100000000;
vector<int> state,head[1<<N];
int n,m,x,f[14][1<<N],g[N];


inline bool check(int x)//快速判断有没有相邻的1
{
    return !(x&x>>1);
}
int main()
{
    scanf("%d%d",&n,&m);
    for(int i=1; i<=n; i++)
        for (int j=1; j<=m; j++)
        {
            scanf("%d",&x);
            g[i]+=(!x<<(j-1));//荒废土地是0，我们在这里转换为1
        }
    for(int i=0; i<(1<<m); i++)
        if (check(i))//这个状态不存在种植左右相邻的玉米
            state.push_back(i);

    for(int i=0; i<state.size(); i++)
        for(int j=0; j<state.size(); j++)
            if (!(state[i] & state[j]))//i对应的状态和j对应的状态没有在同一列种植玉米
                head[i].push_back(j);
    f[0][0]=1;
    for(int i=1; i<=n+1; i++)
        for(int a=0; a<state.size(); a++)
        {
            if (state[a] & g[i])//在第i行，状态a是否满足在荒废土地没有种植玉米
                continue;
            for(int b=0; b<head[a].size(); b++)//从上一行b对应的状态，转到本行a对应的状态
                f[i][a]=(f[i][a]+f[i-1][head[a][b]])%Mod;
        }
    printf("%d\n",f[n+1][0]);//表示第n+1行什么都没种植的状态，其实就是累加f[n][S]
}
