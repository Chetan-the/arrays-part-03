import java.util.*;
public class majority {
    //we have to return the majority element from an array if it apperas mre than n/2 times
    //brute force solution was
    public int majorityele(int[]arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    cnt++;
                }

            }
            if(cnt>n/2){
                return arr[i];
            }
        }
        return -1;
        //tc-o(n^2)
        //sc-o(1)
    }
    //better solution was inplace of using count
    //and keep track of count we use hashing technique(hashmap)
    public int majorityelement(int[]arr){
        int  n=arr.length;
        HashMap<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<n;i++){
           int value= mp.getOrDefault(arr[i],0);
           mp.put(arr[i],value+1);
        }
        for(Map.Entry<Integer,Integer>it:mp.entrySet()){
            if(it.getValue()>n/2){
                return it.getKey();
            }
        }
        return -1;

    }
    //optimal solution was using moores voting algorithm
    /*
     take an element and if it is the element then cnt++;
     else if another element then cnt--;
     if cnt=0 then change the element then like this continue till end 

     */
    public int findmajorityelement(int[]arr){
        int n=arr.length;
        int cnt=0;
          int element = 0;
        for(int i=0;i<n;i++){
            if(cnt==0){
              element=arr[i];
              cnt=1;
            }
            else if(element==arr[i]){
                cnt++;
                
            }
            else{
                cnt--;
            }  
          }
          for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                cnt++;
            }
          }
          if(cnt>n/2){
            return element;
          }
          return -1;
       
    }
    
}
