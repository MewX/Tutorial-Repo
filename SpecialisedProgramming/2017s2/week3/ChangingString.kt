/**
 * Created by MewX on 8/9/2017.
 */

class ChangingString {
    fun distance(A: String, B: String, K: Int): Int {
        val diffs = A.zip(B).map { Math.abs(it.first - it.second) }.filter { it != 0 }.sortedDescending()
        return if (K > diffs.size) K - diffs.size else diffs.subList(K, diffs.size).sum()
    }
}

fun main(args: Array<String>) {
    println(ChangingString().distance("ab", "ba", 2))
    println(ChangingString().distance("aa", "aa", 2))
    println(ChangingString().distance("aaa", "baz", 1))
    println(ChangingString().distance("fdfdfdfdfdsfabasd", "jhlakfjdklsakdjfk", 8))
    println(ChangingString().distance("aa", "bb", 2))
}
