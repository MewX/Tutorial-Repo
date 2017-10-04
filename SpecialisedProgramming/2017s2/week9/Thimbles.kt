/**
 * Created by MewX on 10/04/2017.
 */

class Thimbles {
    fun thimbleWithBall(swaps: Array<String>) : Int = swaps
            .map { it.split("-").map { it.toInt() - 1 } }
            .fold(mutableListOf(true, false, false)) { save, i ->
                // swap trick
                save[i[0]] = save[i[0]] xor save[i[1]]
                save[i[1]] = save[i[1]] xor save[i[0]]
                save[i[0]] = save[i[0]] xor save[i[1]]
                save
            }.indexOf(true) + 1
}

fun main(args: Array<String>) {
    println(Thimbles().thimbleWithBall(arrayOf("1-2", "3-1")))
    println(Thimbles().thimbleWithBall(arrayOf("3-1", "2-3", "3-1", "3-2")))
    println(Thimbles().thimbleWithBall(arrayOf("2-3", "1-3", "2-3", "2-1", "3-1")))
    println(Thimbles().thimbleWithBall(arrayOf("1-2", "3-2", "1-2", "2-1", "2-1", "3-2", "1-3", "3-1", "1-2")))
}
