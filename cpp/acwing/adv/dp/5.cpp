#include<iostream>
using namespace std;

const int N = 12010, M = 2010;

int n, m;
int v[N], w[N]; //逐一枚举最大是N*logS
int f[M]; // 体积<M

int main()
{
    cin >> n >> m;
    int cnt = 0; //分组的组别
    for(int i = 1;i <= n;i ++)
    {
        int a,b,s;
        cin >> a >> b >> s;
        int k = 1; // 组别里面的个数
        while(k<=s)
        {
            cnt ++ ; //组别先增加
            v[cnt] = a * k ; //整体体积
            w[cnt] = b * k; // 整体价值
            s -= k; // s要减小
            k *= 2; // 组别里的个数增加
        }
        //剩余的一组
        if(s>0)
        {
            cnt ++ ;
            v[cnt] = a*s;
            w[cnt] = b*s;
        }
    }

    n = cnt ; //枚举次数正式由个数变成组别数

    //01背包一维优化
    for(int i = 1;i <= n ;i ++)
        for(int j = m ;j >= v[i];j --)
            f[j] = max(f[j],f[j-v[i]] + w[i]);

    cout << f[m] << endl;
    return 0;
}
