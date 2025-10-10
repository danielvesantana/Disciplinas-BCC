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
ll m1 = 1000000006;
ll m2 = 1000000007;

#pragma endregion

ll modpow2( int x, int n){
    if (n == 0) return 1;
    if (x == 0) return 0;

    ll u = modpow2( x, n/2);
    u = (u * u) % m2;

    if (n % 2)
    u = (u * x) % m2;

    return u;
}

ll modpow1( int x, int n){
    if (n == 0) return 1;
    if (x == 0) return 0;

    ll u = modpow1( x, n/2);
    u = (u * u) % m1;

    if (n % 2)
    u = (u * x) % m1;

    return u;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        ll a, b, c;

        cin >> a >> b >> c;

        ll aux = modpow1(b, c);
        ll ans = modpow2(a, aux);

        cout << ans << "\n";
    }

    return 0;
}