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

ll n, m;
char vet[26];

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    string str;
    cin >> n >> m;
    cin >> str;

    for(int i = 0; i < m; i++){
        cin >> vet[i];
    }

    ll count, ans;
    ans = count = 0;
    for(int i = 0; i < str.length(); i++){

        bool flag = false;
        for(int j = 0; j < m; j++){
            if(str[i] == vet[j]){
                count++;
                flag = true;
                break;
            }
        }

        if(!flag){
            ans += (count*(count+1))/2;
            count = 0;
        }

    }
    ans += (count*(count+1))/2;

    cout << ans << "\n";

    return 0;
}