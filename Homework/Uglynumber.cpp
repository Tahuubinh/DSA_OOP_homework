#include <bits/stdc++.h>

using namespace std;

bool mem[1000];
bool visited[1000];

bool ugly(int n){
    if (n == 1){
        mem[1] = true;
        visited[1] = true;
        return true;
    }
    if (visited[n]){
        return mem[n];
    }
    if (n % 2 == 0){
        mem[n] = ugly(n / 2);
        visited[n] = true;
        return mem[n];
    }

    if (n % 3 == 0){
        mem[n] = ugly(n / 3);
        visited[n] = true;
        return mem[n];
    }

    if (n % 5 == 0){
        mem[n] = ugly(n / 5);
        visited[n] = true;
        return mem[n];
    }

    return false;
}

int main(){
    cout << "Hello" << " " << max(1, 2) << endl;

   
        cout << boolalpha << 33 << ". "<<ugly(33) << endl;


    system("pause");
    return 0;
}