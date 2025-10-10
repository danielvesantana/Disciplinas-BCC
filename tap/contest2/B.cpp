#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    ll n, m, k, i, j, num = 0;
    cin >> n >> m >> k;
    ll apl[n], ap[m];
    for(i = 0; i < n; i++){
        cin >> apl[i];
    }
    for(i = 0; i < m; i++){
        cin >> ap[i];
    }
    i = j = 0;
    sort(apl, apl+n);
    sort(ap, ap+m);
    while((i != m) && (j != n)){
        if((ap[i] >= (apl[j] - k)) && (ap[i] <= (apl[j] + k))){
            num++;
            i++;
            j++;
        }else if(ap[i] < (apl[j] - k)){
            i++;
        }else if(ap[i] > apl[j] + k){
            j++;
        }
    }
    cout << num << "\n";

    return 0;
}
