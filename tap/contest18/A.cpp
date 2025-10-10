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

string ans = "6174";

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    string str, c;
    cin >> str;

    c = str;
    ll count = 0;
    while(str != ans){
        string aux1, aux2;
        aux1 = aux2 = str;

        sort(aux1.begin(), aux1.end());
        reverse(aux1.begin(), aux1.end());

        sort(aux2.begin(), aux2.end());

        int res = stoi(aux1) - stoi(aux2);

        str = to_string(res);
        count++;
    }

    if(c != ans)
        cout << count << "\n";
    else
        cout << "1\n";

    return 0;
}