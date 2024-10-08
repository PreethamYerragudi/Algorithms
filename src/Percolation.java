public class Percolation {
    private int[][] grid;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new int[n][n];
    }

    public void open(int row, int col) {
        if (grid[row][col] == 1) {
            return;
        } else {
            grid[row][col] = 1;
        }
    }

    public boolean isOpen(int row, int col) {
        if (row > grid.length || col > grid[row].length || row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
        if (grid[row][col] == 1) {
            return true;
        }
        return false;
    }

    public boolean isFull(int row, int col) {
        if (row > grid.length || col > grid[row].length || row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
        if (grid[row][col] == 0) {
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isOpen(i, j)) {
                    num++;
                }
            }
        }
        return num;
    }

    private int root(int[] arr, int i) {
        while (i != arr[i]) {
            i = arr[i];
        }
        return i;
    }

    private boolean connected(int[] arr, int i, int j) {
        return root(arr, i) == root(arr, j);
    }

    private void union(int[] arr, int i, int j) {
        int root1 = root(arr, i);
        int root2 = root(arr, j);
        arr[root1] = root2;
    }

    public boolean percolates() {
        int[] arr = new int[grid.length * grid[0].length + 2];
        arr[0] = 0;
        arr[grid.length * grid[0].length + 1] = grid.length * grid[0].length + 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr[i * grid.length + j + 1] = i * grid.length + j + 1;
                if (i == 0) {
                    union(arr, i * grid.length + j + 1, 0);
                }
                if (i == grid.length - 1) {
                    union(arr, i * grid.length + j + 1, arr[grid.length * grid[0].length + 1]);
                }
                if (isOpen(i, j)) {
                    // Connect to the open site above
                    if (i > 0 && isOpen(i - 1, j)) {
                        union(arr, i * grid.length + j + 1, (i - 1) * grid.length + j + 1);
                    }
                    // Connect to the open site below
                    if (i < grid.length - 1 && isOpen(i + 1, j)) {
                        union(arr, i * grid.length + j + 1, (i + 1) * grid.length + j + 1);
                    }
                    // Connect to the open site to the left
                    if (j > 0 && isOpen(i, j - 1)) {
                        union(arr, i * grid.length + j + 1, i * grid.length + (j - 1) + 1);
                    }
                    // Connect to the open site to the right
                    if (j < grid.length - 1 && isOpen(i, j + 1)) {
                        union(arr, i * grid.length + j + 1, i * grid.length + (j + 1) + 1);
                    }
                }
            }
        }
        return connected(arr, 0, grid.length * grid[0].length + 1);
    }

}
