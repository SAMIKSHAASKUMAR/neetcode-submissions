class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
        
    }

    public void dfs(int i, int j, char[][] grid, int[][] visited){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return;

        if(visited[i][j]==1)
            return;
        
        if(grid[i][j]=='0')
            return;
        
        visited[i][j] = 1;

        //right
            dfs(i, j+1, grid, visited);

        //down
        dfs(i+1, j, grid, visited);

        //left
        dfs(i, j-1, grid, visited);

        //up
        dfs(i-1, j, grid, visited);

    }
}
