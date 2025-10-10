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

map<char, ll> A;
ll mod = ll(1e9+7);

ll fat(ll n){
    ll ans = 1;
    for(int i = n; i >= 1; i--){
        ans = (ans * i) % mod;
    }

    return ans;
}

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
    string str;

    cin >> str;

    for(int i = 0; i < str.length(); i++){
        A[str[i]]++;
    }

    ll a = fat(str.length());
    ll b = 1;

    for(auto it : A){
        ll m = it.second;
        if(m > 1){
            b = (b * fat(m)) % mod;
        }
    }

    b = test(b, mod-2);

    ll ans = (a * b) % mod;

    cout << ans << "\n";

    return 0;
}