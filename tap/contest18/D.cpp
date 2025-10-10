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

int n, m;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout << fixed << setprecision(8);
    double h, c, l;

    cin >> h >> c >> l;

    double ans1, ans2, ans3, ans4, res;

    ans1 = c + l;
    ans2 = sqrt( ((c+h)*(c+h)) + ((l+h)*(l+h)) ); 
    ans3 = sqrt( (c*c) + ((l+2*h)*(l+2*h)) );
    ans4 = sqrt( ((c+2*h)*(c+2*h)) + (l*l) );

    res = INT_MAX;

    res = min(res, ans1);
    res = min(res, ans2);
    res = min(res, ans3);
    res = min(res, ans4);

    cout << res << "\n";

    return 0;
}