// https://www.acwing.com/blog/content/25597/
#include <bits/stdc++.h>

using namespace std;

const int N = 110, M = 1 << 10;

int n, m;
int g[N];
int cnt[M]; //该状态中 1 的个数
int f[2][M][M]; //前 i 行已摆好，第 i 行状态是 a，第 i - 1 行状态是 b 的最大值
vector<int> state; //合法的状态
vector<int> head[M]; //该状态能够转移到的状态

//三个连续的数字里面最多只能有一个 1
bool check(int state) {
    return !(state & state >> 1 || state & state >> 2);
}

//每个状态 1 的个数
int count(int state) {
    int res = 0;
    for (int i = 0; i < m; i++) res += state >> i & 1;
    return res;
}

int main() {
    cin >> n >> m;

    for (int i = 1; i <= n; i++)
        for (int j = 0; j < m; j++) {
            char c;
            cin >> c;
            g[i] += (c == 'H') << j; //该行的状态跟枚举的状态不能有交集
        }

    //筛选出合法状态
    for (int i = 0; i < 1 << m; i++)
        if (check(i)) {
            state.push_back(i);
            cnt[i] = count(i);
        }

    //枚举出该状态能够转移的所有状态
    for (auto a: state)
        for (auto b: state)
            if (!(a & b))
                head[a].push_back(b);

    for (int i = 1; i <= n + 2; i++)
        for (auto a: state) //枚举第 i 行的状态
            for (auto b: head[a]) //枚举第 i - 1 行的状态
                for (auto c: head[b]) //枚举第 i - 2 行的状态
                {
                    if (g[i] & a) continue; //枚举的状态跟当前行不能有交集
                    if (a & b || a & c || b & c) continue; //枚举的三行状态之间不能有交集
                    f[i & 1][a][b] = max(f[i & 1][a][b], f[i - 1 & 1][b][c] + cnt[a]); //滚动数组求最大值
                }

    cout << f[n + 2 & 1][0][0] << endl;

    return 0;
}

