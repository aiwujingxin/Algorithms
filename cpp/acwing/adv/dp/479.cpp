#include<bits/stdc++.h>
using namespace std;
const int N=35;
int a[N];
int f[N][N];//由i~j构成的二叉树的集合中加分的最大值
int g[N][N];//记录i~j构成的二叉树的根节点是谁
int n;
void print(int l,int r)//递归的输出该树的前序遍历
{
    if(l>r) return ;
    int root=g[l][r];
    cout<<root<<" ";
    print(l,root-1);
    print(root+1,r);
}
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++) cin>>a[i];
    for(int i=1;i<=n+1;i++)//初始化及边界问题
    {
        f[i][i]=a[i];//叶子的加分就是叶节点本身的分数
        f[i][i-1]=1;//若某个子树为空，规定其加分为1
        g[i][i]=i;
    }
    for(int len=2;len<=n;len++)
    {
        for(int i=1;i+len-1<=n;i++)//标准的区间dp板子
        {
            int l=i,r=i+len-1;
            for(int k=l;k<=r;k++)//枚举分界点，以根节点为分界点
            {
                //f[l][r]=max(f[l][r], f[l][k-1]*f[k+1][r]+a[k]);
                //把上面的max写成if形式，方便求出g数组
                if(f[l][r]<f[l][k-1]*f[k+1][r]+a[k])//这里不能用"<=",因为要取字典序最小的
                {
                    f[l][r]=f[l][k-1]*f[k+1][r]+a[k];
                    g[l][r]=k;//记录最后的更新值即为根
                }
            }
        }
    }
    cout<<f[1][n]<<endl;
    print(1,n);

    return 0;
}
