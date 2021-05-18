#include <bits/stdc++.h>
using namespace std;
 
// Fills array S[] with span values
void calculateSpan(int price[], int n, int S[])
{
    S[0] = 0;
    stack<int> st;
    st.push(0);
    for (int i = 1; i < n; ++i){
        S[i] = 0;
        int t = st.top();
        while (price[i] > price[t]){
            S[i] = S[i]+1+S[t];
            st.pop();
            t = st.top();
        }
        st.push(i);
    }
}
 
// A utility function to print elements of array
void printArray(int arr[], int n)
{
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
}
 
// Driver code
int main()
{
    int price[] = { 100, 60, 70, 65, 80, 85 };
    int n = sizeof(price) / sizeof(price[0]);
    int S[n];
 
    // Fill the span values in array S[]
    calculateSpan(price, n, S);
 
    // print the calculated span values
    printArray(S, n);
    
    system("pause");
    return 0;
}