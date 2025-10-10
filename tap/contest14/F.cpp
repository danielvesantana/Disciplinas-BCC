#include <bits/stdc++.h>
using namespace std;

typedef long long ll; 
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<ll> vl;

const int N = 200010;
int vet[N];
ll n, m;
unordered_map<ll, ll> dp;

ll solve(int m) {
    if (m < 12)
        return m;

    if (dp.find(m) != dp.end()) {
        return dp[m];
    }

    ll ans = 0;

    ans += solve(m/2) + solve(m/3) + solve(m/4);

    dp[m] = ans;

    return ans;
}

int main(int argc, char* argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);

    while (cin >> n) {

        cout << solve(n) << "\n";
    }

    return 0;
}
