public class HandsShaking {
    public static void main(String[] args) {
        System.out.println(new HandsShaking().countPerfect(2));
        System.out.println(new HandsShaking().countPerfect(4));
        System.out.println(new HandsShaking().countPerfect(6));
        System.out.println(new HandsShaking().countPerfect(8));
        System.out.println(new HandsShaking().countPerfect(50));
    }

    /**
     * The idea is "divide and conquer" (blue line first, then yellow line):
     * 1. select a possible base line to separate the table into two sides,
     *    (here "possible" means: every side has exactly even number of people.)
     * 2. each side from is a smaller shaking hanks problem (DIVIDE),
     *    multiply the two sides to get results using this base line.
     * 3. sum up all results from all possible base lines. (CONQUER)
     */
    public long countPerfect(int n) {
        // define history states, which can be used by future calculation
        // `n` can only be even
        long[] table = new long [51];
        table[0] = 1; // n = 0
        table[2] = 1; // n = 2

        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i; j += 2) {
                table[i] += table[j] * table[i - j - 2];
            }
        }
        return table[n];
    }
}
