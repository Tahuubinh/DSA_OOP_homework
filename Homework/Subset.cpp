// C++ program to find whether an array
// is subset of another array
#include <bits/stdc++.h>
using namespace std;
/* Return true if arr2[] is a subset of arr1[] */
 
bool isSubset(string arr1[], int m,
              string arr2[], int n)
{
    // Create a Frequency Table using STL
    map<string, int> frequency;
     
    // Increase the frequency of each element
    // in the frequency table.
    for (int i = 0; i < m; i++)
    {
        frequency[arr1[i]]++;
    }
    // Decrease the frequency if the
    // element was found in the frequency
    // table with the frequency more than 0.
    // else return 0 and if loop is
    // completed return 1.
    for (int i = 0; i < n; i++)
    {
        if (frequency[arr2[i]] > 0)
            frequency[arr2[i]]--;
        else
        {
            return false;
        }
    }
    return true;
}
 
// Driver Code
int main()
{
    string arr1[] = { "abc", "de", "abc"};
    string arr2[] = { "abc", "abc"};
    int m = sizeof(arr1) / sizeof(arr1[0]);
    int n = sizeof(arr2) / sizeof(arr2[0]);
 
    if (isSubset(arr1, m, arr2, n))
        cout << "arr2[] is subset of arr1[] "
             << "\n";
    else
        cout << "arr2[] is not a subset of arr1[] "
             << "\n";
    system("pause");
    return 0;
}
// This code is contributed by Dhawal Sarin.