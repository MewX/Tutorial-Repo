/**
 * Created by MewX on 8/9/2017.
 */

class InsertionSortCount {
    // kotlin extension functions
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }

    fun countMoves(A: IntArray): Int {
        val arr = A.toMutableList()
        var count = 0
        for (i in 1 .. A.size - 1) {
            for (j in i - 1 downTo 0) {
                while (arr[j] > arr[j + 1]) {
                    count ++
                    arr.swap(j, j + 1)
                }
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(InsertionSortCount().countMoves(intArrayOf(20,40,30,10)))
    println(InsertionSortCount().countMoves(intArrayOf(-1,1,0)))
    println(InsertionSortCount().countMoves(intArrayOf(-1000,0,1000)))
}