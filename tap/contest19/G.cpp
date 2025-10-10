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

ll n, m;
ll p = 111111111;
bool flag;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);  
    //cout << fixed << setprecision(2);
    cin >> n;

    ll x;
    for(int i = 0; i < n; i++){
        cin >> x;
        flag = false;
        for(int j=0; j<100; j++){
            if(x % 11 == 0){
                flag = true;
                cout << "YES" << "\n";
            }

            x -= 111;
            if(x < 0) break;
        }

        if(!flag) cout << "NO\n"; 
    }


    return 0;
}