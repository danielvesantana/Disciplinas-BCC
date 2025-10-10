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
int n, m;

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    

    return 0;
}#include <bits/stdc++.h>
using namespace std;

#pragma region
typedef long long ll; 
typedef pair<ll, ll> pll;
typedef pair<ll, ll> pii;
typedef vector<ll> vi;
typedef vector<ll> vl;

#define F first
#define S second
#define PB push_back
#define MP make_pair
const ll N = 200010;
ll vet[N];
ll n, m;

const ll N = 1000100;
const ll mod = 1e9+7LL;
ll fat[N], ifat[N];

#pragma endregion

ll exp(ll x, ll ){
    ll rs = 1;
    while(b){
        if(b&1){
            rs = rs * x %mod;
        }
        x = x * x %mod;
        b >>= 1;
    }
}

ll comb(ll a, ll b){
    ll rs = fat[a] * ifat[a-b] % mod;
    rs = rs * ifat[b] % mod;

    return rs;
}

int main(ll argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    for(ll i = 1; i < N; i++){
        fat[i] = fat[i-1] * i % mod;
    }

    for(ll i = 1; i < N; i++){
        ifat[i] = exp(fat[i], mod-2);
    }

    int n;
    cin >> n;

    while(n--){
        int a, b;
    }

    return 0;
}