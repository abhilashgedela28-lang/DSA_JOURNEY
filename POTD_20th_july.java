class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] arr = new int[row][col];
        for(int i = 0;i<row;i++){
            list.add(new ArrayList());
        }
        k = k%(row*col);
        for(int i = 0;i<row*col;i++){
            int nind = i+k;
            int rind = nind/col;
            int cind = nind%col;
            if(rind>= row){
                rind = rind - row;
            }
            arr[rind][cind] = grid[i/col][i%col];
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                list.get(i).add(arr[i][j]);
            }
        }
        return list;
        
    }
}
