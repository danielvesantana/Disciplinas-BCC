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
    cin >> n;

    for(int i = 0; i < n; i++){
        ll l, r, a;

        cin >> l >> r >> a;

        ll x = ((r / a) * a) - 1;

        ll p = (x / a)+(x % a);
        ll q = (r / a)+(r % a);

        if(p > q && x >= l) cout << p << "\n";
        else cout << q << "\n";
    }
    

    return 0;
}