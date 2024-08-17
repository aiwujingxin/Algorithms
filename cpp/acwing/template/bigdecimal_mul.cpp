/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2023-04-19 22:13:09
 * @LastEditTime: 2023-04-19 22:20:38
 * @LastEditors: aiwujingxin@gmail.com
 */
#include <iostream>
#include <vector>

using namespace std;

vector<int> mul(vector<int>& A, vector<int>& B) {
    vector<int> C(A.size() + B.size() + 7, 0);  // 初始化为 0，C的size可以大一点
    for (int i = 0; i < A.size(); i++) {
        for (int j = 0; j < B.size(); j++) {
            C[i + j] += A[i] * B[j];
        }
    }
    int t = 0;
    for (int i = 0; i < C.size(); i++) {  // i = C.size() - 1时 t 一定小于 10
        t += C[i];
        C[i] = t % 10;
        t /= 10;
    }

    while (C.size() > 1 && C.back() == 0) {
        C.pop_back();  // 必须要去前导 0，因为最高位很可能是 0
    }
    return C;
}

int main() {
    string a, b;
    cin >> a >> b;  // a = "1222323", b = "2323423423"

    vector<int> A, B;
    for (int i = a.size() - 1; i >= 0; i--) {
        A.push_back(a[i] - '0');
    }
    for (int i = b.size() - 1; i >= 0; i--) {
        B.push_back(b[i] - '0');
    }

    auto C = mul(A, B);

    for (int i = C.size() - 1; i >= 0; i--) {
        cout << C[i];
    }

    return 0;
}