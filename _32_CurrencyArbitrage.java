import java.util.*;

public class _32_CurrencyArbitrage {
    public boolean hasArbitrage(double[][] rates) {
        int n = rates.length;

        // Step 1: Convert exchange rates to their negative logarithms
        double[][] graph = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0; // No need to exchange the same currency.
                } else {
                    graph[i][j] = -Math.log(rates[i][j]); // Use the negative logarithm
                }
            }
        }

        // Step 2: Use Bellman-Ford to detect negative-weight cycles
        for (int source = 0; source < n; source++) {
            double[] dist = new double[n];
            Arrays.fill(dist, Double.POSITIVE_INFINITY);
            dist[source] = 0;

            // Relax edges up to n-1 times
            for (int i = 1; i < n; i++) {
                for (int u = 0; u < n; u++) {
                    for (int v = 0; v < n; v++) {
                        if (dist[u] + graph[u][v] < dist[v]) {
                            dist[v] = dist[u] + graph[u][v];
                        }
                    }
                }
            }

            // Step 3: Check for negative-weight cycles by relaxing edges one more time
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (dist[u] + graph[u][v] < dist[v]) {
                        return true; // Arbitrage found
                    }
                }
            }
        }

        return false; // No arbitrage found
    }

    public static void main(String[] args) {
        _32_CurrencyArbitrage ca = new _32_CurrencyArbitrage();
        
        // Example of currency exchange rates: 
        // Rates[i][j] = exchange rate from currency i to currency j
        double[][] rates = {
            {1, 0.5, 0.2},
            {2, 1, 0.4},
            {5, 2.5, 1}
        };
        
        if (ca.hasArbitrage(rates)) {
            System.out.println("Arbitrage detected!");
        } else {
            System.out.println("No arbitrage opportunity.");
        }
    }
}
