class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[] px = new int[n];
        int[] py = new int[n];

        for (int i = 0; i < m; i++) {
            int rowX = 0, rowY = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') rowX++;
                else if (grid[i][j] == 'Y') rowY++;

                px[j] += rowX;
                py[j] += rowY;

                if (px[j] == py[j] && px[j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}