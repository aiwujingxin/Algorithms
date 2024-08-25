#include <bits/stdc++.h>
using namespace std;

const int N = 12, M = 1<< N;
long long f[N][M] ;
bool st[M];
vector<vector<int>> state(M);
int m, n;
int main() {
    while (cin >> n >> m, n || m) {
        // 预处理 判断和并列的状态 i 是否合法
        // 如果合并列的某行是 1 表示横放，是 0 表示竖放
        // 如果合并列不存在连续的奇数个 0， 即为合法状态
        for(int i = 0; i < (1 << n); i ++) {
            int cnt = 0 ; // 记录合并列中连续 0 的个数
            bool isValid = true;
            for(int j = 0; j < n; j ++) {
                 if ((i >> j) & 1) { //  如果是 1
                    if (cnt & 1) { // 如果连续0的个数是奇数
                        isValid =false; break; // 记录 i 不合法
                    }
                    cnt = 0;
                 }
                 else cnt ++; //  如果是 0， 记录 0 的个数
            }
            if (cnt & 1)  isValid = false;
            st[i] = isValid; //  处理高位 0 的个数
        }
        // 状态计算
        memset(f, 0, sizeof f);
        f[0][0] = 1 ;// 第 0 列不横放是一种合法的方案
        for (int i = 1; i <= m; i ++) { // 阶段 枚举列
            for (int j = 0; j < (1<<n); j ++) {//状态 枚举第 i 列的状态
                for(int k = 0; k <  (1<<n); k++) // 状态 枚举第 i-1 列的状态
                    //两列状态兼容，不出现重叠的1，且不出现连续的奇数个0
                    if((j&k) == 0 && st[j|k])
                        f[i][j] += f[i-1][k]; // 前一列兼容状态的方案数之和
            }
        }
        cout << f[m][0] << endl;// 第 m 列不横放，即答案
    }
}
