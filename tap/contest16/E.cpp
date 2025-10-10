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

#pragma endregion

ll n, m;
ll mod = ll(1e9+7);

ll test(ll x, ll n){
    if(n == 0) return 1;
    if(x == 0) return 0;

    ll u = test(x, n/2);
    u = (u * u) % mod;

    if(n % 2){
        u = (u * x) % mod;
    }

    return u;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> m;

        ll even = 0, ans;
        for(int i = 0; i < m; i++){
            ll a;
            cin >> a;

            if(a % 2 == 0)
                even++;
        }

        ans = even;
        ll aux = 1;

        if(even > 0){
            aux = test(2, even);
        }

        if(ans == m){
            aux -= 1;
        }

        ans = aux % mod;
        
        cout << ans << "\n";
    }

    return 0;
}