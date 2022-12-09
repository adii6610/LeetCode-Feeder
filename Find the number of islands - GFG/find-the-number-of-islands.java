//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
   
    public void BFS(int r,int c,int vis[][],char grid[][]){
        Queue<Pair>q= new LinkedList<>();
        vis[r][c]=1;
        q.add(new Pair(r,c));
        int n=grid.length;
       int m=grid[0].length;
        while(!q.isEmpty()){
            int rn=q.peek().first;
            int cn=q.peek().second;
            q.poll();
            //for travesing to the neigbhours
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int curRow=rn+i;
                    int curCol=cn+j;
                    if(curRow>=0 && curRow<n && curCol>=0 && curCol<m && vis[curRow][curCol]==0 && grid[curRow][curCol]=='1'){
                        vis[curRow][curCol]=1;
                        q.add(new Pair(curRow,curCol));
                    }
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int vis[][]= new int [n][m];
       int cnt=0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]=='1' && vis[i][j]==0){
                    BFS(i,j,vis,grid);
                   cnt++;
                  
               }
           }
       }
       return cnt;
    }
}