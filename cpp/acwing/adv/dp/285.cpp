#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

vector<int> son[10010];
int f[10010][2], v[10010], h[10010], n;

void dp(int x) {
    f[x][0] = 0;
    f[x][1] = h[x];

    for(int i = 0; i < son[x].size(); i++) {
        int y = son[x][i];
        dp(y);
        f[x][0] += max(f[y][0], f[y][1]);
        f[x][1] += f[y][0];
    }
}


int main() {
    cin >> n;
    for(int i = 1; i <= n ; i++) scanf("%d", &h[i]);
    for(int i = 1; i < n ; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        v[x] = 1;
        son[y].push_back(x);
    }
    int root;
    for(int i = 1; i <= n; i++) {
        if(!v[i]) {
            root = i;
            break;
        }
    }
    dp(root);
    cout << max(f[root][0], f[root][1]) << endl;
}