#include <stdio.h>
#include<limits.h>
#include<bits/stdc++.h>

using namespace std;

/*int n,maxsum,sum;
int i,j,k;
int x=0,y=0; //chi so dau, cuoi cua day con lon nhat

struct MS{
	int weight;
	int x_inx;
	int y_inx;
};

struct MS ml(int a[], int low, int high){
	int maxsum = INT_MIN, sum =0;
	struct MS max;
	int k;
	for(k=high;k>=low;k--){
		sum+=a[k];
		if(sum>maxsum){
		    maxsum=sum;
		    max.x_inx=k;
	    }
	}
	max.weight=maxsum;
	return max;
	
}

struct MS mr(int a[], int low, int high){
	int maxsum = INT_MIN, sum =0;
	struct MS max;
	int k;
	for(k=low;k<=high;k++){
		sum+=a[k];
		if(sum>maxsum) {
		    maxsum=sum;
		    max.x_inx = k;
	    }
	}
	max.weight=maxsum;
	return max;
}



struct MS maxsub3(int a[], int low, int high){
	struct MS max;
	if (low==high){
		max.weight= a[low];
		max.x_inx= low;
		max.y_inx= low;
		return max;
	} 
	else {
		int mid = (low + high)/2;
		struct MS w1 = maxsub3(a,low,mid);
		struct MS w2 = maxsub3(a,mid+1,high);
		int u1 = w1.weight, u2=w2.weight;
		int u3 = ml(a,low,mid).weight + mr(a,mid+1,high).weight;
		if (u3>u1&& u3>u2){
			max.weight = u3;
			max.x_inx = ml(a,low,mid).x_inx;
			max.y_inx = mr(a,mid+1,high).x_inx;
		}
		else if (u1>u2){
			max.weight=u1;
			max.x_inx= w1.x_inx;
			max.y_inx= w1.y_inx;
		}
		else{
			max.weight=u2;
			max.x_inx= w2.x_inx;
			max.y_inx= w2.y_inx;
		}
		return max;
	}
}*/

/*int maxsub4() // quy hoach dong
{
    int u = a[0], maxsum = INT_MIN;
    for (i = 1; i < n; ++i)
    {
        u = max(a[i], u + a[i]);
        if( maxsum < u)
        { 
            maxsum = u;
             if ( u == a[i])  
            {
                 x=i;y=i;
            }
            else
            {
                y = i;
            }
        }
    }
    printf("maxsub4 = %d, day con la: ",maxsum);
    for(i=x;i<=y;i++) printf("%d ",a[i]);
}                           */

struct MS{
    int weight;
    int dau;
    int cuoi;
};

struct MS MaxLeft(int a[], int begin, int end){
    int max = INT_MIN;
    int c = end;
    int d = end;
    int sum = 0;
    for (int i = end; i >= begin; --i){
        sum += a[i];
        if (sum > max){
            max = sum;
            d = i;
        }
    }
    struct MS ans;
    ans.weight = max;
    ans.dau = d;
    ans.cuoi = c;
    return ans;
}

struct MS MaxRight(int a[], int begin, int end){
    int max = INT_MIN;
    int c = begin;
    int d = begin;
    int sum = 0;
    for (int i = begin; i <= end; ++i){
        sum += a[i];
        if (sum > max){
            max = sum;
            c = i;
        }
    }
    struct MS ans;
    ans.weight = max;
    ans.dau = d;
    ans.cuoi = c;
    return ans;
}

MS maxSub(int a[], int begin, int end){
    //void print(MS ms);
    struct MS ans;
    if (begin == end){
        ans.weight = a[begin];
        ans.dau = begin;
        ans.cuoi = end;
        return ans;
    }
    int mid = (begin + end) / 2;
    MS max_left = MaxLeft(a, begin, mid);
    MS max_right = MaxRight(a, mid + 1, end);
    MS lr;
    lr.weight = max_left.weight + max_right.weight;
    lr.dau = max_left.dau;
    lr.cuoi = max_right.cuoi;

    MS left = maxSub(a, begin, mid);
    MS right = maxSub(a, mid + 1, end);

    if (lr.weight > left.weight){
        ans = lr;
    } else{
        ans=left;
    }
    if (ans.weight < right.weight){
        ans = right;
    }
    return ans;
}

void print(MS ms){
    cout << ms.weight << endl;
    cout << ms.dau << endl;
    cout << ms.cuoi << endl;
}

int main(){       
    //-2,11, -4, 13, -5, 2
    int a[] = {-2,11, -4, 13, -5, 2};
    struct MS answer = maxSub(a, 0, 5);
    cout << answer.weight << endl;
    cout << answer.dau << endl;
    cout << answer.cuoi << endl;
    cout << endl;

    MS re = MaxRight(a, 0, 5);
    

    /*MS aa;
    aa.weight = 1;
    aa.dau = 2;
    aa.cuoi = 3;
    MS aplus = aa;
    cout << aplus.weight << endl;
    cout << aplus.dau << endl;
    cout << aplus.cuoi << endl;
    cout << endl;*/

    for (int i: a){
        cout << i << ' ';
    }


    cout << endl;
    system("pause");
    return 0;

}