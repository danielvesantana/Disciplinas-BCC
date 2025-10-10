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
double res, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout << fixed << setprecision(8);
    cin >> n >> m;

    res = (1.0 / (1.0 - cos((2.0 * acos(-1.0)) / (n)))) * (n) * m;    

    cout << res << "\n";

    return 0;
}