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

const int N = 1000;
int n, m;
int vetR[N], vetB[N];

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> m;

        string strR, strB;

        cin >> strR >> strB;

        ll R, B;
        R = B = 0;
        for(int i = 0; i < strR.length(); i++){
            if(strR[i] > strB[i])
                R++;
            else if(strB[i] > strR[i])
                B++;
        }

        if(R > B) cout << "RED\n";
        else if(B > R) cout << "BLUE\n";
        else cout << "EQUAL\n";
    }

    return 0;
}