/**
 * Created by MewX on 8/9/2017.
 */

class Inchworm {
    // calc the largest common divider
    private fun gcd(a: Int, b: Int): Int = if (a % b != 0) gcd(b, a % b) else b
    // calc the least common multiply using Euclidean Algorithm
    private fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)

    // target position is a extra rest and leaf position
    fun lunchtime(branch: Int, rest: Int, leaf: Int): Int = branch / lcm(rest, leaf) + 1
}

fun main(args: Array<String>) {
    println(Inchworm().lunchtime(11, 2, 4))
    println(Inchworm().lunchtime(12, 6, 4))
    println(Inchworm().lunchtime(20, 3, 7))
    println(Inchworm().lunchtime(21, 7, 3))
    println(Inchworm().lunchtime(15, 16, 5))
    println(Inchworm().lunchtime(1000, 3, 7))
    println(Inchworm().lunchtime(1000, 7, 3))
}
