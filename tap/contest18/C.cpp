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

ll n;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    ll ans = 2;

    for(int i = 3; i <= n; i++){
        if(i % 2 == 0){
            ans = (ans * 2);
        }else{
            ans = (1 + ans * 2);
        }
    }   

    cout << ans << "\n";

    return 0;
}