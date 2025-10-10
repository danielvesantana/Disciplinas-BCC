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

map<ll, ll> A;
ll n, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);

    cin >> n;

    for(int i = 0; i < n; i++){
        ll a;
        cin >> a;

        A[a]++;
    }

    ll ans = ((n*(n - 1))/2);

    for(auto it : A){
        m = it.second;
        if(m > 1) ans -= ((m*(m - 1))/2);
    }

    cout << ans << "\n";

    return 0;
}