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

const int N = 100010;
ll vet[N];
ll n;

bool solve(string str){
    ll sum = 0;
    for(int i = 0; i < str.length(); i++){
        sum += str[i] - '0';
    }

    if(sum == 10) return true;
    else return false;
}

int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);
    cin >> n;

    ll i = 19, count = 0;
    while(count <= 10000){
        string str;

        str = to_string(i);
        if(solve(str)){
            vet[count] = i;
            count++;
        }
        i++;
    }   

    cout << vet[n-1] << "\n";

    return 0;
}