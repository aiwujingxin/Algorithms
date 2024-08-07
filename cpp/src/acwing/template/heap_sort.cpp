#include <algorithm>
#include <iostream>

using namespace std;

const int N = 100010;

int h[N], mySize;

int n, m;

void down(int u) {
    int t = u;
    if (2 * u <= mySize && h[t] > h[2 * u])
        t = 2 * u;
    if (2 * u + 1 <= mySize && h[t] > h[2 * u + 1])
        t = 2 * u + 1;
    if (u != t) {
        swap(h[u], h[t]);
        down(t);
    }
}

//因为n是最大值，n/2是n的父节点，因为n是最大，所以n/2是最大的有子节点的父节点，所以从n/2往前遍历，就可以把整个数组遍历一遍
int main() {
    cin >> n >> m;
    mySize = n;
    for (int i = 1; i <= n; i++)
        scanf("%d", &h[i]);
    for (int i = n / 2; i; i--)
        down(i);

    while (m--) {
        cout << h[1] << " ";
        h[1] = h[mySize--];
        down(1);
    }
    return 0;
}