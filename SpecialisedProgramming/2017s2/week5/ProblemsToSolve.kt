/**
 * Created by MewX on 8/23/2017.
 */

class ProblemsToSolve {
    fun minNumber(pleasantness: IntArray, variety: Int): Int =
            (0..pleasantness.size - 1).map { i ->
                (i + 1..pleasantness.size - 1)
                        .filter { Math.abs(pleasantness[i] - pleasantness[it]) >= variety }
                        .map { roads(0, i) + roads(i, it) - 1 }
                        .min() ?: pleasantness.size
            }.min() ?: pleasantness.size

    // include [from] and [to]
    // use a draft formula to simplified the calculation
    private fun roads(from: Int, to: Int): Int = (to - from).let { if (it % 2 == 1) it + 1 else it } / 2 + 1
}

fun main(args: Array<String>) {
    System.out.println(ProblemsToSolve().minNumber(intArrayOf(1, 2, 3), 2))
    System.out.println(ProblemsToSolve().minNumber(intArrayOf(1, 2, 3, 4, 5), 4))
    System.out.println(ProblemsToSolve().minNumber(intArrayOf(10, 1, 12, 101), 100))
    System.out.println(ProblemsToSolve().minNumber(intArrayOf(10, 1), 9))
    System.out.println(ProblemsToSolve().minNumber(intArrayOf(6, 2, 6, 2, 6, 3, 3, 3, 7), 4))
}
