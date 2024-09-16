#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>

using namespace std;

#define N 15

int f[N][N];//f[i][j]表示i位数且最高位为j的不降序的方案数

void init()//dp过程
{
    for(int i=0;i<=9;i++) f[1][i]=1;
    //初始化,因为只有一位的方案数只有一个
    for(int i=2;i<N;i++)
     for(int j=0;j<=9;j++)
      for(int k=j;k<=9;k++)//状态划分
       f[i][j]+=f[i-1][k];
}

int dp(int n)
{
    if(!n) return 1;//n=0,只有0这一种方案
    //因为当n=0时,下面的while循环无法通过,所以要进行特判
    vector<int> num;

    while(n) num.push_back(n%10),n/=10;

    int ans=0;
    int lt=0;//保存上一位的最大值
    for(int i=num.size()-1;i>=0;i--)
    {
        int x=num[i];

        for(int j=lt;j<x;j++) //左边分支,因为要保持不降序,所以j>=lt
        ans+=f[i+1][j];

        if(lt>x) break;//如果上一位最大值大于x的话,不构成降序,所以右边分支结束
        lt=x;

        if(!i) ans++;//全部枚举完了也同样构成一种方案
    }

    return ans;
}

int main()
{
    int n,m;

    init();

    while(cin>>n>>m) printf("%d\n",dp(m)-dp(n-1));

    return 0;
}

