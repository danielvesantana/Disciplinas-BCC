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
    double a, b, x, v;

    cin >> a >> b;

    x = ((3.0*a + 2.0*b) - sqrt(9.0*a*a - 6.0*a*b + 4.0*b*b))/(18.0);

    v = x*(a-2*x)*(b-3*x)/2;

    cout << x << " " << v << "\n";

    return 0;
}