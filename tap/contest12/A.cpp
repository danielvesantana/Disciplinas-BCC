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
const int N = 200010;
int vet[N];
int n;
ll m = 1000000007;

#pragma endregion

ll modpow( int x, int n){
    if (n == 0) return 1;
    if (x == 0) return 0;

    ll u = modpow( x, n/2);
    u = (u * u) % m;

    if (n % 2)
    u = (u * x) % m;

    return u;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        ll a, b;

        cin >> a >> b;

        ll ans = modpow(a, b);
        cout << ans << "\n";
    }

    return 0;
}