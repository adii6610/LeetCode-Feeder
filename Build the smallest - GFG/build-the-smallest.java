//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int N) {
        Stack<Character>s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            while(!s.isEmpty() && s.peek()>c &&N>0){
                N--;
                s.pop();
            }
            if(!s.isEmpty() || c!='0')
            s.push(c);
        }
        while(!s.isEmpty() && N-->0){
            s.pop();
            if(s.isEmpty()){
                return "0";
            }
        }
         StringBuilder sb = new StringBuilder();
        while(s.size()>0) {
            char c = s.pop();
            if(N>0) {
                N--;
                continue;
            }
            sb.append(Character.toString(c));
        }
        
        String ans = sb.reverse().toString();
        return ans;
}
}