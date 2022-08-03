class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        
        boolean vis[][] = new boolean[n][n];
        
        StringBuilder sb = new StringBuilder();
        
        dfs(0,0,m,n,ans,sb,vis);
        
        return ans;
    }
    
    static void dfs(int i,int j,int arr[][],int n,ArrayList<String> ans, StringBuilder s,boolean vis[][])
    {
        if(i<0 || j<0 || i>=n || j>=n || vis[i][j]==true || arr[i][j]==0)
        {
            return;
        }
        
        if(i==n-1 && j==n-1)
        {
            ans.add(s.toString());
            return;
        }
        
        vis[i][j] = true;
        s.append("D");
        dfs(i+1,j,arr,n,ans,s,vis);
        s = s.deleteCharAt(s.length()-1);
        
        vis[i][j] = true;
        s.append("R");
        dfs(i,j+1,arr,n,ans,s,vis);
        s = s.deleteCharAt(s.length()-1);
        
        vis[i][j] = true;
        s.append("U");
        dfs(i-1,j,arr,n,ans,s,vis);
        s = s.deleteCharAt(s.length()-1);
        
        vis[i][j] = true;
        s.append("L");
        dfs(i,j-1,arr,n,ans,s,vis);
        s = s.deleteCharAt(s.length()-1);
        
        vis[i][j] = false;
    }
}
