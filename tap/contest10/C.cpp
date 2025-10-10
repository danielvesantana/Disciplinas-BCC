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
vector < int > adj[N];
int dist[N];
bool vis[N];
ll mod = int(1e9+7);

#pragma endregion

ll exp(ll a, ll b) {
    a %= mod;
    ll res = 1;
    while (b > 0) {
        if (b & 1)
            res = res * a % mod;
        a = a * a % mod;
        b >>= 1;
    }
    return res;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        ll a, b;

        cin >> a >> b;

        cout << exp(a, b) << "\n";
    }

    return 0;
}