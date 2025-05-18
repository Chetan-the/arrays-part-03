import java.util.*;
public class countinversion {
    //count the no of pairs in an array in which the left element is greater than the right element a[i]>a[j]
    //Brute force solution
    public int countpairs(int[]arr){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    count++;

                }
            }
        }
        return count;
        //tc-o(n^2)
        //sc-o(1);

    }
    //optimal solution was by using merge sort
    //bcz in merge sort while dividing and checking the two arrays 
    //then if left is greater than right then move that means 
    //in here it is following the rule of a[i]>b[i];
    public int merge(int[]arr,int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<Integer>();
        int left=low;
        int right=mid+1;
        int cnt=0;


        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){

                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }

        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
   for(int i=low;i<=high;i++){
    arr[i]=temp.get(i-low);
   }
   return cnt;
    }
    public int mergesort(int[]arr,int low,int high){
        int cnt=0;
        while(low>=high){
            return cnt;
        }
        int mid=low+high/2;
        cnt+=mergesort(arr,low,mid);
        cnt+=mergesort(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;

    }
    public int countinversionpairs(int[]arr){
        int n=arr.length;
        int ans=mergesort(arr,0,n-1);
        return ans;

    }
}
