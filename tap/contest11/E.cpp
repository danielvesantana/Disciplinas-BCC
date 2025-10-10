#include <bits/stdc++.h>
using namespace std;

#pragma region
typedef long long ll;
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<ll> vl;

#define F first
#define S second
#define PB push_back
#define MP make_pair
int n, m;

#pragma endregion

bool isPrime(int n) {
    if (n < 2) return false;

    for (int i = 2; (i * i) <= n; i++) {
        if (n % i == 0) return false;
    }

    return true;
}

int main(int argc, char *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    // cout << fixed << setprecision(2);
    cin >> m;

    int ans = 0;
    for (int i = 1; i <= m; i++) {
        int count = 0;

        for (int j = 1; j <= i; j++) {
            if (i % j == 0 && isPrime(j)) {
                count++;
            }
        }

        if (count == 2) ans++;
    }

    cout << ans << "\n";

    return 0;
}
