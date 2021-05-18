#include <bits/stdc++.h>

using namespace std;

stack<int> s;

bool isPair(char a, char b){
    if(a == '(' && b == ')') 
        return true;
    if(a == '{' && b == '}') 
        return true;
    if(a == '[' && b == ']') 
        return true;
    return false;
}

bool solve(char* a, int n){
    for (int i = 0; i < n; ++i){
        if ( a[i] == '[' || a[i] == '(' || a[i] == '{'  ){
            s.push(a[i]);
        }
        
        else{
            if (s.empty()){
                cerr << i;
                return false;
            }
            else if (isPair(s.top(), a[i])){
                s.pop();
            }
            else {
                cerr << i;
                return false;
            }
        }
    }
    cerr << n;
    return s.empty();
}


int main(){
    bool ok = solve("[({})]()",8);
    if (ok) 
        cout<<"Parentheses in the expression are balanced"; 
    else 
        cout<<"Not balanced";

    cout << endl;
    system("pause");
    return 0;
}