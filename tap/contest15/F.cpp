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

#pragma endregion

ll fat[N];
int n, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);

    cin >> n;

    ll ans = 1;
    for(ll i = 1; i <= 11; i++){
        ans *= (n-i);
        ans /= i;
    }

    cout << ans << "\n";

    return 0;
}