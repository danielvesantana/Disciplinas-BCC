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
const int N = 1000010;
int vet[N];
ll dp[N];
ll n, m;

#pragma endregion

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 1; i <= n; i++) {
        int aux1 = i;
        dp[i] = INT_MAX;

        while (aux1 > 0){
            dp[i] = min(dp[i], dp[i - aux1 % 10] + 1);

            aux1 /= 10;
        }
    }

    cout << dp[n] << "\n";

    return 0;
}
