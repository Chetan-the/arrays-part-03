public class typeoftriangle {
   public String typeof(int[]arr){
    int a=arr[0];
    int b=arr[1];
    int c=arr[2];
    if(a+b<c && b+c<a && a+c<b){
        return "none";
    }
    if(a==b && b==c){
        return "equilateral";
    }
    else if(a==b || b==c || c==a){
        return "isoceles";
    }
    else{
        return "scalene";
    }
   }    
}
