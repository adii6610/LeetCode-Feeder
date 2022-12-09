//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
   
    public void DFS(int r,int c,int vis[][],int grid[][], ArrayList<String>al,int r1,int c1){
        vis[r][c]=1;
       al.add(toString(r-r1,c-c1));
        int n=grid.length;
       int m=grid[0].length;
            int pRow[]={-1,0,1,0};
            int pCol[]={0,-1,0,1};
            for(int i=0;i<4;i++){
                int nRow=r+pRow[i];
                int nCol=c+pCol[i];
                if(nRow<n && nRow>=0 && nCol<m && nCol>=0 && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                     vis[nRow][nCol]=1;
                    DFS(nRow,nCol,vis,grid,al,r1,c1); 
                }
            }
    }
    public String toString(int n,int m){
        return Integer.toString(n)+" "+Integer.toString(m);
    }

    int countDistinctIslands(int[][] grid) {
       HashSet<ArrayList<String>>h= new HashSet<>();
       int n=grid.length;
       int m=grid[0].length;
       int vis[][]= new int [n][m];
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==1 && vis[i][j]==0){
                   ArrayList<String>al=new ArrayList<>();
                    DFS(i,j,vis,grid,al,i,j);
                    h.add(al);
               }
           }
       }
       return h.size();
       
    }
}
