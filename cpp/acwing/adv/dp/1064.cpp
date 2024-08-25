#include<iostream>
#include<cstring>
#include<cstdio>
#include<algorithm>
#include<vector>

using namespace std;

typedef long long LL;

const int N=12;

const int M=1<<10,K=110;

int n,m;

vector<int> state;

vector<int> head[M];

int cnt[M];

LL f[N][K][M];

bool check(int state)
{
    for(int i=0;i<n;i++)
     if((state >> i & 1)&&(state >> i + 1 & 1))
       return false;
    return true;
}

int count(int state)
{
    int res=0;
    for(int i=0;i<n;i++)res+=state>>i&1;
    return res;
}

int main()
{
    cin>>n>>m;

    for(int i=0;i<1<<n;i++)
       if(check(i))
       {
           state.push_back(i);
           cnt[i]=count(i);
       }

    // 建立状态转移的关系
    for(int i = 0;i< state.size();i ++ )
      for(int j=0;j<state.size();j++)
      {
          int a=state[i],b=state[j];
          if((a&b)==0&&check(a|b))
             head[i].push_back(j); //下标
      }

      f[0][0][0]=1;

      for(int i=1;i<=n+1;i++)
         for(int j=0;j<=m;j++)
           for(int a=0;a<state.size();a++)
             for(int b : head[a])
             {
                 int c=cnt[state[a]];
                 if(j>=c)
                 {
                     f[i][j][a]+=f[i-1][j-c][b];
                 }
             }

    cout<<f[n+1][m][0]<<endl;
    return 0;
}

