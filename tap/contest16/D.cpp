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

ll mod = ll(1e9+7);
map<char, ll> A;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    ll n;
    string str;

    cin >> n >> str;

    for(int i = 0; i < str.length(); i++){
        char c = str[i];

        A[c]++;
    }   

    ll ans = 1;
    for(auto it : A){
        ll m = it.second;

        ans = (ans * (m + 1)) % mod;
    }   

    cout << ans-1 << "\n";

    return 0;
}