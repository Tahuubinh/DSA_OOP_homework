#include <bits/stdc++.h>

using namespace std;

// Find the first time of integer x, which makes f(x) > 0

int f(int x){
    return x*x -4*x -8;
}

int main(){
    int x = 1;
    while( f(x) < 0 ){
        x *= 2;
    }
    cout << x << endl;

    int low = x/2;
    int high = x;
    int mid;

    while (high - low > 1){
        mid = (high + low)/2;
        if ( f(mid) > 0 ){
            high = mid;
        }
        if ( f(mid) < 0){
            low = mid;
        }
    }
    cout << low << high << endl;
    cout << f(high) << endl;

    system("pause");
    return 0;
}