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

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    double v1, v2;

    cin >> v1 >> v2;

    ll count = 1, ans = 0, aux = 3;
    while(1){
        if(v2 - (count * v1) >= 0){
            ans++;
        }else{
            break;
        }
        count += aux;
        aux += 2;
    }

    cout << ans << "\n";

    return 0;
}