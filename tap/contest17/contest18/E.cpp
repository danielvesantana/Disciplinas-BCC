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
    cout << fixed << setprecision(8);
    double a, b;

    cin >> a >> b;

    double ans = ((a+b) - sqrt(a*a - a*b + b*b))/(6.0);

    cout << ans << "\n";

    return 0;
}