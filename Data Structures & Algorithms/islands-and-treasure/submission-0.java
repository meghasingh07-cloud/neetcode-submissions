class Solution {
    static class Node{
        int first, second, third;
        Node(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis= new int[n][m];
        int[][] dist=new int[n][m];
        Queue<Node>q=new LinkedList<>();
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(grid[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow= row+ delrow[i];
                int ncol= col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]!=-1){
                    vis[nrow][ncol]=1;
                    grid[nrow][ncol] = steps + 1;
                    q.add(new Node(nrow,ncol,steps+1));
                }
            }
        }

    }
}

