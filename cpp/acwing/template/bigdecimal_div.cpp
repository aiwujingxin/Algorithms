/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-20 21:22:15
 * @LastEditTime: 2023-04-20 21:38:22
 * @LastEditors: aiwujingxin@gmail.com
 */
#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
vector<int> div(vector<int>& A, int b, int& r) {
    vector<int> C;
    r = 0;
    for (int i = A.size() - 1; i >= 0; i--) {
        r = r * 10 + A[i];
        C.push_back(r / b);
        r %= b;
    }
    reverse(C.begin(), C.end());
    while (C.size() > 1 && C.back() == 0) {
        C.pop_back();  // 必须要去前导 0，因为最高位很可能是 0
    }
    return C;
}

int main() {
    string a;
    int B, r = 0;  // 代表余数
    cin >> a >> B;
    vector<int> A;
    for (int i = a.size() - 1; i >= 0; i--) {
        A.push_back(a[i] - '0');
    }
    auto C = div(A, B, r);
    for (int i = C.size() - 1; i >= 0; i--)
        cout << C[i];   // 将C从最高位传给最低位
    cout << endl << r;  // 输出余数
    cout << endl;
    return 0;
}