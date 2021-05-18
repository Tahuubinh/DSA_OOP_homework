#include <bits/stdc++.h>

using namespace std;
int board[9][9];
int a[9];
int b[9];
int countaa = 0;

void print(){
    for (int i = 1; i <= 8; ++i){
        for (int j = 1; j <= 8; ++j){
            if (board[i][j] == 0)
                cout << "0 ";
            else 
                cerr <<"1 ";
        }
        cout << endl;
    }
    cout << endl;
    cout << "--------------------------------------------------------------" << endl;
}

void clear(){
    for (int i = 1; i <= 8; ++i){
        for (int j = 1; j <= 8; ++j){
            board[i][j] = 0;
        }
    }
}

void draw(){
    for (int i = 1; i < 9; ++i){
        board[i][a[i]] = 1;
    }
}

bool UCV(int h, int k){
    for (int i = 1; i < k; ++i){
        if ( (k - i)*(k - i) == (h - a[i])*(h - a[i]) ){
            return false;
        }
    }
    return true;
}

void Try (int k){
    if (k == 9){
        ++countaa;
        if (countaa < 10){
            clear();
            draw();
            print();
        }
    } else{
        for (int i = 1; i < 9; ++i){
            if (b[i] == 0){
                if (UCV(i, k)){
                    a[k] = i;
                    b[i] = 1;
                    Try (k + 1);
                    b[i] = 0;
                }
            }
        }
    }
}

int main(){
    Try (1);
    
        cout << countaa << endl;

    cout << endl;
    system("pause");
    return 0;
}