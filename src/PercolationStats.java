public class PercolationStats {
    Percolation percolation;
    double[] thresholds;
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        percolation = new Percolation(n);
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            while (!percolation.percolates()) {
                percolation.open((int) (Math.random() * n), (int) (Math.random() * n));
            }
            thresholds[i] = percolation.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        double ans = 0;
        for(double d: thresholds) {
            ans += d;
        }
        return ans / thresholds.length;
    }

    public double stddev() {
        double ans = 0;
        for(double d: thresholds) {
            ans += Math.pow(d - mean(), 2);
        }
        return Math.sqrt(ans/thresholds.length-1);
    }

    public double confidenceLo() {
        return mean() - 1.96*stddev() / Math.sqrt(thresholds.length);
    }

    public double confidenceHi() {
        return mean() + 1.96*stddev() / Math.sqrt(thresholds.length);
    }
}
