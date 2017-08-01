import java.util.*;

public class ChangingString {
    public int distance(String A, String B, int K) {
        ArrayList<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < A.length(); i ++) {
            int tempDiff = Math.abs(A.codePointAt(i) - B.codePointAt(i));
            if (tempDiff != 0) diffs.add(tempDiff); // add all diffs
        }

        diffs.sort((a, b) -> b - a); // sort to decreasing list
        if (K >= diffs.size()) return K - diffs.size(); // diffs array is set 0, the rest are 1
        
        // else set the first K elements to 0
        for (int i = 0; i < K; i ++) diffs.set(i, 0);
        return diffs.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(new ChangingString().distance("ab", "ba", 2));
        System.out.println(new ChangingString().distance("aa", "aa", 2));
        System.out.println(new ChangingString().distance("aaa", "baz", 1));
        System.out.println(new ChangingString().distance("fdfdfdfdfdsfabasd", "jhlakfjdklsakdjfk", 8));
        System.out.println(new ChangingString().distance("aa", "bb", 2));
    }
}
