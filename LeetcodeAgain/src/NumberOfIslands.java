/* LOGIC: Take the grid element, if it's 1, increment count for number of islands, and make that grid element 0,
and also recursively make the others that are horizontally and vertically adjacent as 0 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col)
    {
        int nRows = grid.length;
        int nCols = grid[0].length;

        if( row < 0 || col < 0 || row >= nRows || col >= nCols || grid[row][col]=='0')
            return;

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
