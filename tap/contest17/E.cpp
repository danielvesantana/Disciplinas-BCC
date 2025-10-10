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
    string str1, str2;

    cin >> str1 >> str2;

    double ans;
    ll pos1, pos2, neg1, neg2, unr;
    pos1 = pos2 = neg1 = neg2 = unr = 0;

    for(int i = 0; i < str1.length(); i++){
        if(str1[i] == '+')
            pos1 += 1;
        else
            neg1 +=1;

        if(str2[i] == '+')
            pos2 += 1;
        else if(str2[i] == '-')
            neg2 += 1;
        else
            unr += 1;
    }

    if(pos2 + unr >= pos1 && neg2 + unr >= neg1){
        
    }else{
        ans = 0.0;
    }

    cout << ans << "\n";

    return 0;
}