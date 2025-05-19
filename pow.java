public class pow{
    //given the value of x and n pow(2,10) we will return 1024 bcz 2^10=1024
    //Brute force solution was:
    
    public double myPow(double x, int n) {
        double ans=1;
        int N=n;
        if(n<0){
            N=-n;
            for(int i=0;i<N;i++){
            ans=ans*1/x;
            }
            return ans;
        }
        
        for(int i=0;i<N;i++){
            ans=ans*x;
        }
        
        return ans;
    }
    //tc-0(n) and sc is o(1);
    //optimal solution was 
    /*
    when n%2==0
    x*=x and n=n/2
    and when n%2==1
    ans*=x; and n=n-1 
    */ 
    public double power(double x,int n){
        int N=n;
        if(n<0){
            N=-n;
        }
        double ans=1;
       while(N>0){
        if(N%2==0){
            x*=x;
            n/=2;
        }
        ans*=ans*x;
        n=n-1;

       }
       if(N<0) return 1/ans;
return ans;


    }
}