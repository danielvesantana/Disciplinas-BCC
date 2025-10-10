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
int fat[N];
ll n, m;

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> m;

    ll ans1, ans2;
    ans1 = ans2 = 0;

    ans1 = (n*n-n)/2;
    ans2 = (m*m-m)/2;

    cout << ans1 + ans2 << "\n";

    return 0;
}