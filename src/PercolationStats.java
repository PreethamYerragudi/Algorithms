import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation percolation;
    private double[] thresholds;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        percolation = new Percolation(n);
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniformInt(n), StdRandom.uniformInt(n));
            }
            thresholds[i] = percolation.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(thresholds.length);
    }

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(thresholds.length);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println(percolationStats.mean());
        System.out.println(percolationStats.stddev());
        System.out.println(percolationStats.confidenceLo());
        System.out.println(percolationStats.confidenceHi());
    }
}
