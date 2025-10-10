#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base :: sync_with_stdio(0);
    cin.tie(nullptr);
    long long x, b;
    cin >> x >> b;

    if (x == 0) {
        cout << 1 << endl;
    } else {
        int digits = floor(log10(x) / log10(b)) + 1;
        cout << digits << endl;
    }

    return 0;
}
