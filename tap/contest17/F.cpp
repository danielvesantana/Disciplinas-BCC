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

double n, m, d;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n >> m >> d;

    double ans;

    if(d == 0){
        ans = ((n*m)-n)/(n*n);
    }else{
        ans = (2*(n-d)/(n*n))*(m-1);
    }

    printf("%.10lf\n", ans);

    return 0;
}