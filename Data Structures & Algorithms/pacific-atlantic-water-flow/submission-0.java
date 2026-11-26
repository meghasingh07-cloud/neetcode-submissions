class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
    
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(i,0,pacific, heights);
            dfs(i,m-1,atlantic,heights);
        }

        for(int j=0;j<m;j++){
            dfs(0,j,pacific,heights);
            dfs(n-1,j,atlantic,heights);
        }
        List<List<Integer>> result= new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;

        }
    
    public void dfs(int row, int col, boolean[][] vis, int[][]heights){
        vis[row][col]=true;
        int n=heights.length;
        int m=heights[0].length;
    
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && !vis[nrow][ncol] && heights[row][col] <= heights[nrow][ncol]){
                dfs(nrow,ncol,vis,heights);
            }
        }
    }
}
