public class missandrepeat{
    //find the missing number and repeating number in an array
     public static int[] missingAndRepeatingNumberBrute(int[] arr) {
        int n = arr.length;
        int[] ans = new int[2];

        for (int i = 1; i <= n; i++) { 
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            if (count == 0) {
                ans[1] = i;  // missing
            } else if (count == 2) {
                ans[0] = i;  // repeating
            }
        }
        return ans;
    }
    //better solution when ever using the count use the hashmapping
    //with the help of hash array
    public int[] missingndrepeatingnumber(int[]arr){
        int n=arr.length;
        int[]hasharray=new int[n+1];
        int[]ans=new int[2];
        for(int i=1;i<n;i++){
            hasharray[arr[i]]++;
        }
        
        for(int i=1;i<=n;i++){
            if(hasharray[i]==2){
                ans[0]=i;
            }
            else if(hasharray[i]==0){
                ans[1]=i;
            }
            
            
        }
        return ans;

    }
    //optimal solution was using the maths 
    //with the help of 2 equations
    //in 1st equation we sum up the first n natural numbers and sum up of numbers in an array
    //in 2nd equation we sum up the squares of first n natural numbers and sqaures of numbers in array
    //now we get two equations by solving this we get x and y where
    //x is repeating number and y is missing number
    public int[] findmissandrepeat(int[]arr){
        int[]ans=new int[2];
        int sn;
        int an;
         int an2;
        int sn2;
        int n=arr.length;
        sn=(n*(n-1)/2);
         sn2=(n*(n+1)*(2*n+1)/6);
         int sum=0;     
         int sumsquare=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
             sumsquare+=arr[i]*arr[i];
        }
        an=sum;
    int val1=an-sn;
    an2=sumsquare;
     int val2=an2-sn2;
     val2=val2/val1;
     int x=val1+val2/2;
     int y=val2-x;
     ans[0]=x;
     ans[1]=y; 
  return ans;

    }
  
}