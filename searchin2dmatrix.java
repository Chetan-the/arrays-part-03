public class searchin2dmatrix{
    //given an nxm matrix with sorted then
    //our goal is to find the target variable in a 2d array if it lies return true else return false
    //Brute force solution was
    public boolean findtarget(int[][]arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
  //tc-o(n^2)
  //sc-o(1)
    }

    //better soln was
    public boolean binarysearch(int[]arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]>target){
                  high=mid-1;

            }
            else{
                low=mid+1;

            }
        }
        return false;

    }
    public boolean findtargetin2d(int[][]arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            if(arr[i][0]<target && arr[i][m-1]>target ){
                binarysearch(arr[i],target);
            }
        }
        return false;
    }
    //tc-o(n)+o(logn)
    //sc-o(1)

    //optimal solution was by converting 2d to 1d and doing binary search 
    //tc-o(logn)
    /*
     row=ind/m
     col=ind%m

     */
    public boolean findtargetin2dmatrix(int[][]arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        int low=0;
        int high=n*m-1;
        while(low<=high){
            int mid=low+high/2;
            int row=mid/m;
            int col=mid%m;
            if(arr[row][col]==target){
                return true;
            }
            else if(arr[row][col]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }

}