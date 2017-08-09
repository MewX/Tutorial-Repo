/**
 * Created by MewX on 8/9/2017.
 */

class VolumeGuess {
    data class Condition(val box1: Int, val box2: Int, val smallest: Int)

    fun correctVolume(queries: Array<String>, numberOfBoxes: Int, ithBox: Int): Int =
        queries.map { it.split(",") }
                .map { Condition(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
                .filter { it.box1 == ithBox || it.box2 == ithBox }
                .sortedBy { it.smallest }.last().smallest
}

fun main(args: Array<String>) {
    println(VolumeGuess().correctVolume(arrayOf("1,2,10","1,3,10","2,3,20"), 3, 1))
    println(VolumeGuess().correctVolume(arrayOf("1,02,10","2,3,010","1,3,20"), 3, 2))
    println(VolumeGuess().correctVolume(arrayOf("1,2,31","1,3,9","1,4,31","2,4,32","3,4,9","3,2,9"), 4, 1))
    println(VolumeGuess().correctVolume(arrayOf("1,2,31","1,3,9","1,4,31","2,4,32","3,4,9","3,2,9"), 4, 3))
}
