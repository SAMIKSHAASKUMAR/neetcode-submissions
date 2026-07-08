class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int area=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]!=1){
                    int a = dfs(i, j, grid, visited);
                    area = Math.max(area, a);
                }
            }
        }
        return area;
        
    }

    public int dfs(int i, int j, int[][] grid, int[][] visited){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return 0;

        if(visited[i][j]==1)
            return 0;
        
        if(grid[i][j]==0)
            return 0;
        
        visited[i][j] = 1;

        int area = 1; //current call's 1

        //right
        area+= dfs(i, j+1, grid, visited);

        //down
        area+= dfs(i+1, j, grid, visited);

        //left
        area+= dfs(i, j-1, grid, visited);

        //up
        area+= dfs(i-1, j, grid, visited);

        return area;

    }
        
    
}
