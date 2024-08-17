 #include <cstdio>
 #include <iostream>
 #include <algorithm>

 using namespace std;

 const int N = 3010;

 int n;
 int a[N], b[N];
 int f[N][N];

 int main()
 {
     scanf("%d", &n);
     for (int i = 1; i <= n; i ++ ) scanf("%d", &a[i]);
     for (int i = 1; i <= n; i ++ ) scanf("%d", &b[i]);
    /* for (int i = 1; i <= n; i ++ )
    {
        for (int j = 1; j <= n; j ++ )
        {
            f[i][j] = f[i - 1][j]; // 不包含 a[i]
            if (a[i] == b[j]) // 包含 a[i], 则寻找b 数组中a[i] == b[j] 且 最长的上升子序列
            {
                int maxv = 1;
                for (int k = 1; k < j; k ++ )
                    if (a[i] > b[k])
                        maxv = max(maxv, f[i - 1][k] + 1);
                f[i][j] = max(f[i][j], maxv);
            }
        }
    }*/
    // 等价优化，变成二重循环， 减少 k 那一层的循环
     for (int i = 1; i <= n; i ++ )
     {
         int maxv = 1; // 某个前缀的最大值， 可以用一个变量替代
         for (int j = 1; j <= n; j ++ )
         {
             f[i][j] = f[i - 1][j];
             if (a[i] == b[j]) f[i][j] = max(f[i][j], maxv);
             if (a[i] > b[j]) maxv = max(maxv, f[i - 1][j] + 1);
         }
     }

     int res = 0;
     for (int i = 1; i <= n; i ++ ) res = max(res, f[n][i]);
     printf("%d\n", res);
     return 0;
 }
