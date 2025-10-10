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
ll n, x, y;

ll solve(int aux, bool flag) {
    if (aux == 1){
        if(flag)
            return 0;
        else
            return 1;
    }
    
    if(flag)
        return solve(aux - 1, true) + solve(aux, false) * x;
    else
        return solve(aux - 1, true) + solve(aux - 1, false) * y;
}

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> x >> y;

    ll ans;
    ans = solve(n, true);

    cout << ans << "\n";

    return 0;
}