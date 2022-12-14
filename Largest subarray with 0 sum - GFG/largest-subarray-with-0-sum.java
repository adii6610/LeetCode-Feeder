//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
       int len = 0;
       int maxlen = 0;
       int start = 0;
       int last = -1;
       int sum=0;
       int currsum = 0;
       for(int i = 0;i<n;i++)
       {
           currsum = currsum + arr[i];
           if(currsum == 0)
           {
               start = 0;
               last = i;
               len = (last-start) + 1;
               if(len>=maxlen)
               {
                   maxlen = len;
               }
           }
           if(m.containsKey(currsum - sum))
           {
               start = m.get(currsum - sum) + 1;
               last = i;
               len = (last - start) + 1;
                if(len>maxlen)
               {
                   maxlen = len;
               }
           }
           
           else
           {
               m.put(currsum,i);
           }
           
       }
       return maxlen;
    }
}