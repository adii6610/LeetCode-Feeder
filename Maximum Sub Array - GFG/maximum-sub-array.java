//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        ArrayList<Integer>al = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        int i=0;
        int preSum=0;
        int currSum=0;
        boolean isTrue=false;
        while(i<n){
            if(a[i]>=0){
                if(al.size()==0 || isTrue==false)
                al.add(a[i]);
                temp.add(a[i]);
                currSum+=a[i];
            }else{
                isTrue=true;
                if(currSum>preSum){
                    preSum=currSum;
                    al.clear();
                    al.addAll(temp);
                }
                currSum=0;
                temp.clear();
            }
            i++;
            
        }
          if(!isTrue){
              return al;
          }
        if(isTrue==true && currSum>preSum){
            al.clear();
            al.addAll(temp);
        }
        if(al.size()==0)
        al.add(-1);
        
        return al;   
    }
}