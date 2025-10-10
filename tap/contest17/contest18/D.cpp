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
    cout << fixed << setprecision(4);
    double h, c, l;

    cin >> h >> c >> l;

    double case1, case2, case3;

    case1 = c+l;
    case2 = 2*h + sqrt(c*c + l*l);
    case3 = sqrt((c/2)*(c/2) + h*h) + sqrt((c/2)*(c/2) + (l/2)*(l/2)) + sqrt((l/2)*(l/2) + h*h);

    double ans;
    ans = min(case1, case2);
    ans = min(ans, case3);

    cout << ans << "\n";

    return 0;
}