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
map < int, int > mp;

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    int n;

    cin >> n;

    for(int i = 0; i < n; i++){
        int a;

        cin >> a;

        if(mp[a]){
            mp[a] = 0;
            continue;
        }
        mp[a] = 1;
    }

    map<int , int > :: iterator it = mp.begin();

    int sum = 0;
    while(it != mp.end()){
        if(mp[it->first])
            sum++;

        ++it;
    }

    cout << sum << "\n";

    return 0;
}