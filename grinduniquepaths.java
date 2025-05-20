public class grinduniquepaths {
    //given an 2d array (nxm)array from that it have
    //both starting and ending paths 
    //we have to find the no of ways to reach to end from start by moving only in right and botttom
    //brute force solution was by using recursion technique to reach from start to end
    public int ways(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        else{
            return ways(i+1,j,n,m)+ways(i,j+1,n,m);
        }
    }
    public int noofways(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        int ans=ways(0,0,n,m);
        return ans;

//time complexity was exponential so to optimal using dynamic programming with simply using hash table
    }
    public int see(int i,int j,int m,int n,int[][]dp){
        if(i==n-1 && j==m-1){
            return 0;
        }
        if(i>=n || j>=m){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        else return dp[i][j]=see(i+1,j,m,n,dp)+see(i,j+1,m,n,dp);

    }
    //better solution was
    public int noways(int[][]arr){
        int m=arr.length;
        int n=arr[0].length;
        int[][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        int ans=see(0,0,m,n,dp);
       return ans;
    }

    //optimal solution was by observing 
    /*
     we get the ways to reach we get 
     rrd pr rdr or drr in here we are taking rights of m-1 and downs of n-1 so no of ways is n+m-2;
     and the combination of n-1 or m-1 
     */
    public int noways(int m,int n){
        int value=m+n-2;
        int row=m-1;
        int ans=1;
        for(int i=0;i<row;i++){
             ans=ans*(value-i);
             ans=ans/i+1;
        }
        return ans;
    }
    public int noofwaystoreach(int [][]arr){
        int n=arr.length;
        int m=arr[0].length;
        int finalans=noways(m,n);
        return finalans;

    }
    
}
