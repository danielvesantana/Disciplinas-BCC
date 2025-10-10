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
const int N = 200010;
int vet[N];
int n, m;
vector < int > adj[N];
int dist[N];
bool vis[N];

#pragma endregion

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    vector < string > v;
    cin >> n; 

    for(int i = 0; i < n; i++){
        string str;

        cin >> str;

        v.push_back(str);
    }

    bool flag = false;
    for(int i = 0; i < n; i++){
        if(v[i] == "and"){
            flag = true;
            break;
        }else if(v[i] == "not"){
            flag = true;
            break;
        }else if(v[i] == "that"){
            flag = true;
            break;
        }else if(v[i] == "the"){
            flag = true;
            break;
        }else if(v[i] == "you"){
            flag = true;
            break;
        }
    }

    if(flag) cout << "Yes\n";
    else cout << "No\n";

    return 0;
}