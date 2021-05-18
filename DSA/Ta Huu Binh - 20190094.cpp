// Ta Huu Binh 20190094
#include <bits/stdc++.h>

using namespace std;

char A[10000];
char B[10000];
int M[10001][10001];
int b[10001][10001]; //Save the optimize state

int LCS(char A[], char B[], int m, int n){
    //M[m][n] is the answer when A and B has m and n elements respectively
    for (int i = 0; i <= m; i++){
        M[i][0] = 0;
    }
    for (int j = 0; j <= n; j++){
        M[0][j] = 0;
    }
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++){
            if (A[i] == B[j]){
                M[i+1][j+1] = M[i][j] + 1;
                b[i+1][j+1] = 1;
            }

            else if (M[i][j] < M[i+1][j]){
                M[i+1][j+1] = M[i+1][j];
                b[i+1][j+1] = 2;
            }
            else if (M[i][j] < M[i][j+1]){
                M[i+1][j+1] = M[i][j+1];
                b[i+1][j+1] = 3;
            }

            else
                b[i+1][j+1] = 0;
            
        }
    return M[m][n];
}

void printLCS(char A[], char B[], int m, int n){
    if ((m == 0) || (n == 0))
        return;
    switch(b[m][n]){
        case 0:
            printLCS(A, B, m - 1, n - 1);
            break;
        case 1:
            printLCS(A, B, m - 1, n - 1);
            cout << A[m - 1] << ' ';
            break;
        case 2:
            printLCS(A, B, m - 1, n - 1);
            cout << A[m - 1] << ' ';
            break;
        case 3:
            printLCS(A, B, m - 1, n - 1);
            cout << B[n - 1] << ' ';
            break;
    }
}

int main(){
    //input A
    cout << "Number of elements in A: ";
    int m;
    cin >> m;
    for (int i = 0; i < m; ++i){
        cout << "A[" << i << "] = ";
        cin >> A[i];
    }
    //input B
    cout << "Number of elements in B: ";
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i){
        cout << "B[" << i << "] = ";
        cin >> B[i];
    }
    cout << "Max Length: ";
    cout << LCS(A, B, m, n) <<endl;
    cout << "Longest Common Subsequence: \n";
    printLCS(A, B, m, n);
    cout << endl;


    
    system("pause"); //Better remove when using DevCpp
    return 0;
}









