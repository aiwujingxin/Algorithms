#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int n;
int a[N], q[N];

int main(){
    cin >> n;
    for(int i = 0; i < n; i ++) scanf("%d", &a[i]);

    int len = 0;
    for(int i = 0; i < n; i ++){
        int k = 0;
        while(k < len && q[k] < a[i]) k ++;
        q[k] = a[i];
        if (k >= len) len ++;
    }

    cout << len << endl;
    return 0;
}


#include <iostream>
#include <algorithm>

using namespace std;
const int N = 1e5 + 10;
int n;
int a[N], q[N];

int main(){
    cin >> n;
    for(int i = 0; i < n; i ++) cin >> a[i];

    int len = 0;
    for(int i = 0; i < n; i ++){
        int l = 0, r = len; // 二分找到最大的小于当前数x的数c
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(q[mid] < a[i]) l = mid;
            else r = mid - 1;
        }

        q[r + 1] = a[i];
        if(r + 1 > len) len ++;
    }

    cout << len << endl;
    return 0;
}

