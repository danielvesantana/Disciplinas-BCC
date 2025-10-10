#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base :: sync_with_stdio(0);
    cin.tie(nullptr);
    int n;
    cin >> n;

    int m, rest;
    m = 0;
    while(n > 0){
        rest = n % 2;

        if(rest)
            m++;
        
        n /= 2; 
    }

    cout << m << "\n";

    return 0;
}