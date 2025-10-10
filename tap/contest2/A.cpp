#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    long long n, k = 0;
    cin >> n;
    vector < long long > v(n);

    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    for(int i = 0; i < n; i++){
        if(v[i] != v[i+1]){
            k++;
        }
    }
    cout << k;

    return 0;
}
