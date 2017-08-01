
public class AlmostBipartiteMatching {
    public static void main(String[] args) {
        System.out.println(new AlmostBipartiteMatching().maxMatching(3, 3, new int[] {0,1,2}, new int[] {0,1,2}));
        System.out.println(new AlmostBipartiteMatching().maxMatching(3, 3, new int[] {0, 1}, new int[] {1, 2}));
        System.out.println(new AlmostBipartiteMatching().maxMatching(6, 6, new int[] {0, 0, 2, 3}, new int[] {2, 4, 5, 1}));
        System.out.println(new AlmostBipartiteMatching().maxMatching(13, 16, new int[] {5,2,6,2,7,2,7,6,2,6,1,3,0,10,12,11,10}, new int[] {7,3,10,12,0,0,3,4,7,2,5,2,14,15,1,1,1}));
    }

    // greedy
    public int maxMatching(int nA, int nB, int[] edgesA, int[] edgesB) {
        int sum = 0;
        sum += nA / 2 + nB / 2; // side interval
        if (nA % 2 == 0 || nB % 2 == 0) return sum;

        // finding a potential side edge
        for (int i = 0; i < edgesA.length; i ++) {
            if (edgesA[i] % 2 == 0 && edgesB[i] % 2 == 0)
                return sum + 1;
        }
        return sum; // unnecessary return
    }
}
