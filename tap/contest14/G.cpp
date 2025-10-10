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

#pragma endregion

unordered_map<int,int>mp;

	function<int(int)>fun=[&](int n)->int{

		if(n<12)return n;

		if(mp.find(n)!=mp.end()){

			return mp[n];

		}

		int sum=fun(n/2)+fun(n/3)+fun(n/4);

		mp[n]=sum;

		return sum;

	};


int main(int argc, char* argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    //cout << fixed << setprecision(2);

    while(cin>>n){

		cout<<fun(n)<<'\n';

	}

    return 0;
}