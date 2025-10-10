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

const int N = 200010;
int n;
map<string, int> mp;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    int sum = 1;
    for(int i = 0; i < n; i++){
        string str;

        cin >> str;

        if(i == 0) mp[str] = 1;

        if(mp[str] != 1) {
            sum++;
        }

        mp[str] = 1;
    }

    cout << sum << "\n";

    return 0;
}