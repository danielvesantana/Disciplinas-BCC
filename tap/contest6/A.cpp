#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(nullptr);
    int n;

    cin >> n;

    int v[n];
    for(int i = 0; i < n; i++)
        cin >> v[i];

    sort(v, v+n);

    for(int i = 0; i < n; i++)
        cout << v[i] << " ";

    return 0;
}