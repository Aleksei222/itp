import java.util.*;

public class CountIslands {

    public static int countIslands(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i, j + 1, m, n);
        dfs(grid, visited, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        line = line.trim();
        if (line.startsWith("[[")) line = line.substring(1, line.length()-1);

        String[] rowStrings = line.split("\\],\\[");
        int m = rowStrings.length;
        int[][] grid = new int[m][];
        for (int i = 0; i < m; i++) {
            String row = rowStrings[i].replaceAll("[\\[\\]]", "");
            String[] nums = row.split(",");
            grid[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                grid[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        System.out.println(countIslands(grid));
    }
}
