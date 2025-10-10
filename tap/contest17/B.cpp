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
    cout << fixed << setprecision(12);
    int a, b, c, x;
    cin >> a >> b >> c >> x;

    if(x <= a){
        printf("%.12lf\n", 1.0/1.0);
    }else if(x > a && x <= b){
        double d = double(c);
        double e = double(b);
        double f = double(a);

        double ans = d/(e-f);

        cout << ans << "\n";
    }else{
        double ans = 0.0/3.0;

        cout << ans << "\n";
    }

    return 0;
}