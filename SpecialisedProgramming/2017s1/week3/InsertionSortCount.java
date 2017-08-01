public class InsertionSortCount {
    public int countMoves(int[] A) {
        int count = 0;
        // sorted part, i means the last unsorted index
        for (int i = 1; i < A.length; i ++) {
            // j means move [j] to [j - 1] if A[j] < A[j - 1]
            for (int j = i; j > 0; j --) {
                if (A[j] < A[j - 1]) {
                    // this is a swap
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                    // so, count it
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new InsertionSortCount().countMoves(new int[] {20,40,30,10}));
        System.out.println(new InsertionSortCount().countMoves(new int[] {-1,1,0}));
        System.out.println(new InsertionSortCount().countMoves(new int[] {-1000,0,1000}));
    }
}