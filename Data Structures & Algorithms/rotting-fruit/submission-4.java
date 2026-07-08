class Solution {
    int fresh=0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        if(fresh==0)
            return 0;
        count = bfs(grid, queue);
        return count;
        
    }

    public int bfs(int[][] grid, Queue<int[]> queue){
        int count =0;

        while(!queue.isEmpty()){
            int s = queue.size();
            boolean rotten = false;

            for(int k=0; k<s;k++){
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];

            //if(i>grid.length && j>grid[0].length)
                //return count;

            //right
            if(j+1<grid[0].length && grid[i][j+1]==1){
                queue.add(new int[]{i, j+1});
                rotten=true;
                grid[i][j+1] =2;
                fresh--;
                
            }

            //down
            if(i+1<grid.length && grid[i+1][j]==1){
                queue.add(new int[]{i+1, j});
                rotten=true;
                grid[i+1][j] =2;
                fresh--;
                
            }

            //left
            if(j-1>=0 && grid[i][j-1]==1){
                queue.add(new int[]{i, j-1});
                rotten=true;
                grid[i][j-1] =2;
                fresh--;
                
            }

            //top
            if(i-1>=0 && grid[i-1][j]==1){
                queue.add(new int[]{i-1, j});
                rotten=true;
                grid[i-1][j] =2;
                fresh--;
                
            }
            }
            if(rotten)
                count++;
        }
        if(fresh>0)
            return -1;

        return count;


    }
}
