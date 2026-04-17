class Solution {
    int[] diff = {0,1,0,-1,0};
    private void dfs(char[][] grid, int row, int col, int R, int C){
        grid[row][col] = '0';
        for(int di = 0 ; di < 4 ; di++){
            int adjR = row + diff[di], adjC = col + diff[di+1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && grid[adjR][adjC] == '1'){
                dfs(grid,adjR,adjC,R,C);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int R = grid.length, C = grid[0].length;
        for(int row = 0 ; row < R ; row++){
            for(int col = 0 ; col < C ; col++){
                if(grid[row][col] == '1'){
                    dfs(grid,row,col,R,C);
                    count++;
                }
            }
        }
        return count;
    }
}