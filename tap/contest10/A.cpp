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
ll n, m;
vector < int > adj[N];
int dist[N];
bool vis[N];

#pragma endregion

void bb(){
    ll l, r, ans;

    l = ans = 0;
    r = 59;

    while(l <= r){
        m = (l + r)/2;
        long long aux = pow(2, m);
        if(aux <= n){
            ans = m;
            l = m + 1;
        }else{
            r = m - 1;
        }
    }

    cout << ans << "\n";
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    bb();

    return 0;
}